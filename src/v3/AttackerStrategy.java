package v3;

import battlecode.common.*;

import static v3.RobotPlayer.*;

enum AttackerState {
    SCOUT, COMBAT, FLAG_SPOTTED, FLAG_HOLDING, RETREAT
}

public class AttackerStrategy {

    static AttackerState state = AttackerState.SCOUT;

    public static void doAttackerStrategy(RobotController rc) throws GameActionException {
        Direction randomDir = directions[rng.nextInt(directions.length)];
        switch (macroState) {

            case SETUP:
                // Move and attack randomly if no objective.
                CrumbMicro.doScoutCrumb(rc);
                if (rc.canMove(randomDir)) {
                    rc.move(randomDir);
                }
                break;
            case BATTLE:
                RobotInfo[] enemyRobots = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
                FlagInfo nearbyFlag = null;
                for (FlagInfo flagInfo : rc.senseNearbyFlags(-1, rc.getTeam().opponent())) {
                    if (!flagInfo.isPickedUp()) {
                        nearbyFlag = flagInfo;
                        break;
                    }
                }
                switch (state) {
                    case SCOUT:
                        if (rc.getHealth() < RETREAT_THRESHOLD) {
                            RetreatMicro.doRetreat(rc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.RETREAT;
                        } else if (enemyRobots.length != 0) {
                            CombatMicro.doCombatMicro(rc, enemyRobots);
                            state = AttackerState.COMBAT;
                        } else if (nearbyFlag != null) {
                            MapLocation flagLoc = nearbyFlag.getLocation();
                            Pathing.moveTowards(rc, flagLoc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.FLAG_SPOTTED;
                        } else {
                            MapLocation[] broadcastFlagLocs = rc.senseBroadcastFlagLocations();
                            if (broadcastFlagLocs.length != 0) {
                                Pathing.moveTowards(rc, broadcastFlagLocs[0]);
                            } else {
                                // Move randomly if no objective.
                                if (rc.canMove(randomDir)) {
                                    rc.move(randomDir);
                                }
                            }
                            HealingMicro.doTryHeal(rc);
                        }
                        break;
                    case COMBAT:
                        if (rc.getHealth() < RETREAT_THRESHOLD) {
                            RetreatMicro.doRetreat(rc);
                            state = AttackerState.RETREAT;
                        } else {
                            switch (CombatMicro.doCombatMicro(rc, enemyRobots)) {
                                case FIGHTING:
                                    break;
                                case SAFE:
                                    state = AttackerState.SCOUT;
                                    break;
                            }
                        }
                        break;
                    case FLAG_SPOTTED:
                        if (rc.getHealth() < RETREAT_THRESHOLD) {
                            RetreatMicro.doRetreat(rc);
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.RETREAT;
                        } else if (rc.canPickupFlag(rc.getLocation())) {
                            rc.pickupFlag(rc.getLocation());
                            RetreatMicro.doRetreat(rc);
                            state = AttackerState.FLAG_HOLDING;
                        } else if (nearbyFlag != null) {
                            MapLocation flagLoc = nearbyFlag.getLocation();
                            Pathing.moveTowards(rc, flagLoc);
                            HealingMicro.doTryHeal(rc);
                        } else if (enemyRobots.length != 0) {
                            CombatMicro.doCombatMicro(rc, enemyRobots);
                            state = AttackerState.COMBAT;
                        } else {
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                    case FLAG_HOLDING:
                        // If we are holding an enemy flag, singularly focus on moving towards
                        // an ally spawn zone to capture it!
                        if (rc.hasFlag()) {
                            RetreatMicro.doRetreat(rc);
                        } else {
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                    case RETREAT:
                        if (rc.getHealth() < RETREAT_THRESHOLD) {
                            RetreatMicro.doRetreat(rc);
                            HealingMicro.doTryHeal(rc);
                        } else {
                            HealingMicro.doTryHeal(rc);
                            state = AttackerState.SCOUT;
                        }
                        break;
                }
                break;
        }
        indicator += state + " " + Pathing.currentTarget;
    }

    public static void doGoToFlag(RobotController rc, FlagInfo nearbyFlag) {
    }

    public static void doScout(RobotController rc) {
    }
}
