package v4;

import battlecode.common.*;

import static v4.RobotPlayer.*;

enum AttackerState {
    SCOUT, COMBAT, FLAG_SPOTTED, FLAG_HOLDING, RETREAT, ESCORT, RECAPTURE, REINFORCE
}

public class AttackerStrategy {

    static AttackerState state = AttackerState.SCOUT;
    static MapLocation scoutTarget = null;

    public static void doAttackerStrategy(RobotController rc) throws GameActionException {
        switch (macroState) {

            case SETUP:
                // Move and attack randomly if no objective.
                CrumbMicro.doScoutCrumb(rc);
                if (flagHomes[0] != null) {
                    Symmetry.updateSymmetries(rc, flagHomes);
//                    Pathing.moveTowards(rc, Symmetry.decidePlausibleLoc(rc, flagHomes));
                }

                MapInfo[] mapInfos = rc.senseNearbyMapInfos();
                MapLocation closestDam = null;
                for (MapInfo mapInfo : mapInfos) {
                    if (mapInfo.isDam() &&
                            (closestDam == null
                                    || mapInfo.getMapLocation().distanceSquaredTo(rc.getLocation()) < closestDam.distanceSquaredTo(rc.getLocation()))) {
                        closestDam = mapInfo.getMapLocation();
                    }
                }
                if (closestDam != null) {
                    if (!rc.getLocation().isAdjacentTo(closestDam)) {
                        Pathing.moveTowards(rc, closestDam);
                    }
                } else if (rc.getRoundNum() > 150) {
                    Pathing.moveTowards(rc, flagHomes[flagHomeIdx].loc);
                } else {
                    Pathing.doMoveRandom(rc);
                }
                break;
            case BATTLE:
                FlagInfo[] nearbyEnemyFlags = rc.senseNearbyFlags(-1, rc.getTeam().opponent());
                FlagInfo[] nearbyOurFlags = rc.senseNearbyFlags(-1, rc.getTeam());
                FlagInfo nearbyFlag = null;
                for (FlagInfo flagInfo : nearbyEnemyFlags) {
//                  TODO: make this the closest flag
                    if (!flagInfo.isPickedUp()) {
                        nearbyFlag = flagInfo;
                        break;
                    }
                }
                MapLocation nearbyFlagLoc = nearbyFlag == null ? null : nearbyFlag.getLocation();
                MapLocation nearestEnemyFlagWeHold = Communication.getNearestFlag(rc, rc.getTeam().opponent(), FlagStatus.HELD, nearbyEnemyFlags);
                MapLocation nearestOurFlagEnemyHolds = Communication.getNearestFlag(rc, rc.getTeam(), FlagStatus.HELD, nearbyOurFlags);
                MapLocation nearestDroppedEnemyFlagLoc = Communication.getNearestFlag(rc, rc.getTeam().opponent(), FlagStatus.DROPPED, nearbyEnemyFlags);
                MapLocation mostEnemyCountHomeLoc = Communication.getMostEnemyCountHome(rc);
//                indicator += "r " + mostEnemyCountHomeLoc + " ";
//                indicator += "uh " + nearestEnemyFlagWeHold + " ";
//                indicator += "eh " + nearestOurFlagEnemyHolds + " ";
                indicator += "ed " + nearestDroppedEnemyFlagLoc + " ";
                switch (state) {
                    case SCOUT:
                        CombatMicro.doCombatMicro(rc);
                        if (nearbyFlag != null) {
                            doMoveShoot(rc, nearbyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.FLAG_SPOTTED;
//                        } else if (enemyRobots.length != 0) {
//                            CombatMicro.doCombatMicro(rc, enemyRobots);
//                            state = AttackerState.COMBAT;
                        } else if (nearestEnemyFlagWeHold != null && nearestEnemyFlagWeHold.distanceSquaredTo(rc.getLocation()) > GameConstants.VISION_RADIUS_SQUARED) {
                            Pathing.moveTowards(rc, nearestEnemyFlagWeHold);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.ESCORT;
                        } else if (nearestOurFlagEnemyHolds != null) {
                            Pathing.moveTowards(rc, nearestOurFlagEnemyHolds);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.RECAPTURE;
                            // TODO: prevent too many ducks from crowding the flag holder
//                        } else if (mostEnemyCountHomeLoc != null) {
//                            Pathing.moveTowards(rc, mostEnemyCountHomeLoc);
//                            HealingMicro.doTryHeal(rc);
//                            state = AttackerState.REINFORCE;
//                        } else if (rc.getHealth() < RETREAT_THRESHOLD) {
//                            RetreatMicro.doRetreatHome(rc);
//                            HealingMicro.doTryHeal(rc);
//                            state = AttackerState.RETREAT;
                        } else {
                            doScout(rc, nearestDroppedEnemyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                        }
                        break;
                    case COMBAT:
                        if (rc.canPickupFlag(rc.getLocation())) {
                            rc.pickupFlag(rc.getLocation());
                            RetreatMicro.doRetreatClosestSpawn(rc);
                            state = AttackerState.FLAG_HOLDING;
                        } else if (nearbyFlag != null) {
                            doMoveShoot(rc, nearbyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.FLAG_SPOTTED;
                        } else {
//                        if (rc.getHealth() < RETREAT_THRESHOLD) {
//                            RetreatMicro.doRetreat(rc);
//                            state = AttackerState.RETREAT;
//                        } else {
                            switch (CombatMicro.doCombatMicro(rc)) {
                                case FIGHTING:
                                    break;
                                case SAFE:
                                    doScout(rc, nearestDroppedEnemyFlagLoc);
                                    HealingMicro.doTryHeal(rc);
                                    state = AttackerState.SCOUT;
                                    break;
                            }
                        }
                        break;
                    case FLAG_SPOTTED:
                        // TODO: go over the priorities here
                        if (rc.canPickupFlag(rc.getLocation())) {
                            rc.pickupFlag(rc.getLocation());
                            RetreatMicro.doRetreatClosestSpawn(rc);
                            state = AttackerState.FLAG_HOLDING;
                        } else if (nearbyFlag != null) {
                            doMoveShoot(rc, nearbyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                        } else {
                            CombatMicro.doCombatMicro(rc);
//                            state = AttackerState.COMBAT;
//                        } else if (rc.getHealth() < RETREAT_THRESHOLD) {
//                            RetreatMicro.doRetreatHome(rc);
//                            HealingMicro.doTryHeal(rc);
//                            state = AttackerState.RETREAT;
                            doScout(rc, nearestDroppedEnemyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                    case FLAG_HOLDING:
                        // If we are holding an enemy flag, singularly focus on moving towards
                        // an ally spawn zone to capture it!
                        if (rc.hasFlag()) {
                            RetreatMicro.doRetreatClosestSpawn(rc);
                        } else {
                            CombatMicro.doCombatMicro(rc);
                            doScout(rc, nearestDroppedEnemyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                    case RETREAT:
                        if (rc.getHealth() < RETREAT_THRESHOLD) {
                            RetreatMicro.doRetreatHome(rc);
                            HealingMicro.doTryHeal(rc);
                        } else {
                            doScout(rc, nearestDroppedEnemyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                    case RECAPTURE:
                        CombatMicro.doCombatMicro(rc);
//                            state = AttackerState.COMBAT;
                        if (nearestOurFlagEnemyHolds != null) {
                            doMoveShoot(rc, nearestOurFlagEnemyHolds);
                            HealingMicro.doTryHeal(rc);
                        } else {
                            doScout(rc, nearestDroppedEnemyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                    case ESCORT:
                        if (rc.canPickupFlag(rc.getLocation())) {
                            rc.pickupFlag(rc.getLocation());
                            RetreatMicro.doRetreatClosestSpawn(rc);
                            state = AttackerState.FLAG_HOLDING;
                        } else if (nearbyFlag != null) {
                            doMoveShoot(rc, nearbyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.FLAG_SPOTTED;
                        } else {
                            CombatMicro.doCombatMicro(rc);
//                            state = AttackerState.COMBAT;
//                        } else if (nearestEnemyFlagWeHold != null) {
//                            doMoveShoot(rc, nearestEnemyFlagWeHold.subtract(rc.getLocation().directionTo(nearestEnemyFlagWeHold)));
//                            HealingMicro.doTryHeal(rc);
                            if (nearestEnemyFlagWeHold != null && nearestEnemyFlagWeHold.distanceSquaredTo(rc.getLocation()) > GameConstants.VISION_RADIUS_SQUARED) {
                                Pathing.moveTowards(rc, nearestEnemyFlagWeHold);
                                HealingMicro.doTryHeal(rc);
                                state = AttackerState.ESCORT;
                            } else {
                                doScout(rc, nearestDroppedEnemyFlagLoc);
                                HealingMicro.doTryHeal(rc);
                                state = AttackerState.SCOUT;
                            }
                        }
                        break;
                    case REINFORCE:
                        CombatMicro.doCombatMicro(rc);
                        if (nearbyFlag != null) {
                            doMoveShoot(rc, nearbyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.FLAG_SPOTTED;
//                        } else if (enemyRobots.length != 0) {
//                            CombatMicro.doCombatMicro(rc, enemyRobots);
//                            state = AttackerState.COMBAT;
                        } else if (nearestEnemyFlagWeHold != null && nearestEnemyFlagWeHold.distanceSquaredTo(rc.getLocation()) > GameConstants.ATTACK_RADIUS_SQUARED) {
                            Pathing.moveTowards(rc, nearestEnemyFlagWeHold);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.ESCORT;
                        } else if (nearestOurFlagEnemyHolds != null) {
                            Pathing.moveTowards(rc, nearestOurFlagEnemyHolds);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.RECAPTURE;
                            // TODO: prevent too many ducks from crowding the flag holder
                        }
//                        if (enemyRobots.length != 0) {
//                            CombatMicro.doCombatMicro(rc, enemyRobots);
//                            state = AttackerState.COMBAT;
                        else if (mostEnemyCountHomeLoc != null) {
                            Pathing.moveTowards(rc, mostEnemyCountHomeLoc);
                            HealingMicro.doTryHeal(rc);
                        } else {
                            doScout(rc, nearestDroppedEnemyFlagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                }
                break;
        }
        indicator += state + " " + Pathing.currentTarget;
    }


    static void doMoveShoot(RobotController rc, MapLocation loc) throws GameActionException {
        Pathing.moveTowards(rc, loc);
        CombatMicro.doTryShoot(rc);
    }

    static void doScout(RobotController rc, MapLocation nearestDroppedEnemyFlagLoc) throws GameActionException {
        if (nearestDroppedEnemyFlagLoc != null) {
            Pathing.moveTowards(rc, nearestDroppedEnemyFlagLoc);
            scoutTarget = nearestDroppedEnemyFlagLoc;
            return;
        }

        Symmetry.updateSymmetries(rc, flagHomes);
        MapLocation plausibleEnemyLoc = Symmetry.decidePlausibleLoc(rc, flagHomes);
        if (plausibleEnemyLoc != null) {
            Pathing.moveTowards(rc, plausibleEnemyLoc);
//            rc.setIndicatorLine(rc.getLocation(), plausibleEnemyLoc, 255, 255, 255);
            scoutTarget = plausibleEnemyLoc;
            return;
        }

        MapLocation[] broadcastFlagLocs = rc.senseBroadcastFlagLocations();
        if (broadcastFlagLocs.length != 0) {
            Pathing.moveTowards(rc, broadcastFlagLocs[0]);
            scoutTarget = broadcastFlagLocs[0];
            return;
        }

        Pathing.doMoveRandom(rc);
    }
}
