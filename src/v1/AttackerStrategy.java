package v1;

import battlecode.common.*;

import static v1.RobotPlayer.*;

public class AttackerStrategy {
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
                            state = State.COMBAT;
                        } else if (nearbyFlag != null) {
                            MapLocation flagLoc = nearbyFlag.getLocation();
                            Pathing.moveTowards(rc, flagLoc);
                            state = State.FLAG_SPOTTED;
                        } else {
                            MapLocation[] broadcastFlagLocs = rc.senseBroadcastFlagLocations();
                            if (broadcastFlagLocs.length != 0) {
                                Pathing.moveTowards(rc, broadcastFlagLocs[0]);
                            } else {
                                // Move and attack randomly if no objective.
                                if (rc.canMove(randomDir)) {
                                    rc.move(randomDir);
                                }
                            }
                        }
                        break;
                    case COMBAT:
                        if (enemyRobots.length != 0) {
                            // Save an array of locations with enemy robots in them for future use.
                            MapLocation enemyLoc = enemyRobots[0].getLocation();
                            if (rc.canAttack(enemyLoc)) {
                                rc.attack(enemyLoc);
                            } else {
                                Pathing.moveTowards(rc, enemyLoc);
                            }
                        } else {
                            state = State.SCOUT;
                        }
                        break;
                    case FLAG_SPOTTED:
                        if (rc.canPickupFlag(rc.getLocation())) {
                            rc.pickupFlag(rc.getLocation());
                            rc.setIndicatorString("Holding a flag!");
                            state = State.FLAG_HOLDING;
                        } else if (nearbyFlag != null) {
                            MapLocation flagLoc = nearbyFlag.getLocation();
                            Pathing.moveTowards(rc, flagLoc);
                        } else if (enemyRobots.length != 0) {
                            state = State.COMBAT;
                        } else {
                            state = State.SCOUT;
                        }
                        break;
                    case FLAG_HOLDING:
                        // If we are holding an enemy flag, singularly focus on moving towards
                        // an ally spawn zone to capture it!
                        if (rc.hasFlag()) {
                            MapLocation[] spawnLocs = rc.getAllySpawnLocations();
                            MapLocation firstLoc = spawnLocs[0];
                            Pathing.moveTowards(rc, firstLoc);
                        } else {
                            state = State.SCOUT;
                        }
                        break;
                }
                break;
        }
    }
}
