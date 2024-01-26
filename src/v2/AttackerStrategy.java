package v2;

import battlecode.common.*;

import static v2.RobotPlayer.*;

enum AttackerState {
    SCOUT, COMBAT, FLAG_SPOTTED, FLAG_HOLDING,
}

public class AttackerStrategy {

    static AttackerState state = AttackerState.SCOUT;

    public static void doAttackerStrategy(RobotController rc) throws GameActionException {
        Direction randomDir = directions[rng.nextInt(directions.length)];
        switch (macroState) {

            case SETUP:
                // Move and attack randomly if no objective.
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
                        if (enemyRobots.length != 0) {
                            CombatMicro.doCombatMicro(rc, enemyRobots);
                            state = AttackerState.COMBAT;
                        } else if (nearbyFlag != null) {
                            MapLocation flagLoc = nearbyFlag.getLocation();
                            Pathing.moveTowards(rc, flagLoc);
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
                        }
                        break;
                    case COMBAT:
                        switch (CombatMicro.doCombatMicro(rc, enemyRobots)) {
                            case FIGHTING:
                                break;
                            case SAFE:
                                state = AttackerState.SCOUT;
                                break;
                        }
                        break;
                    case FLAG_SPOTTED:
                        if (rc.canPickupFlag(rc.getLocation())) {
                            rc.pickupFlag(rc.getLocation());
                            rc.setIndicatorString("Holding a flag!");
                            state = AttackerState.FLAG_HOLDING;
                        } else if (nearbyFlag != null) {
                            MapLocation flagLoc = nearbyFlag.getLocation();
                            Pathing.moveTowards(rc, flagLoc);
                        } else if (enemyRobots.length != 0) {
                            state = AttackerState.COMBAT;
                        } else {
                            state = AttackerState.SCOUT;
                        }
                        break;
                    case FLAG_HOLDING:
                        // If we are holding an enemy flag, singularly focus on moving towards
                        // an ally spawn zone to capture it!
                        if (rc.hasFlag()) {
                            MapLocation[] spawnLocs = rc.getAllySpawnLocations();
                            MapLocation closestSpawnLoc = spawnLocs[0];
                            for (int i = 1; i < spawnLocs.length; i++) {
                                if (rc.getLocation().distanceSquaredTo(spawnLocs[i]) < rc.getLocation().distanceSquaredTo(closestSpawnLoc)) {
                                    closestSpawnLoc = spawnLocs[i];
                                }
                            }
                            Pathing.moveTowards(rc, closestSpawnLoc);
                        } else {
                            state = AttackerState.SCOUT;
                        }
                        break;
                }
                break;
        }
        indicator += state + " " + Pathing.currentTarget;
    }
}
