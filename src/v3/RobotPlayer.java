package v3;

import battlecode.common.*;

import java.util.Random;

enum MacroState {
    SETUP, BATTLE
}

enum RobotType {
    ATTACKER, DEFENDER
}

class FlagHome {
    MapLocation loc;
    int flagID;

    FlagHome(MapLocation loc, int flagID) {
        this.loc = loc;
        this.flagID = flagID;
    }

    @Override
    public String toString() {
        return "FlagHome{" +
                "loc=" + loc +
                ", flagID=" + flagID +
                '}';
    }
}

/**
 * RobotPlayer is the class that describes your main robot strategy.
 * The run() method inside this class is like your main function: this is what we'll call once your robot
 * is created!
 */
public strictfp class RobotPlayer {

    /**
     * Array containing all the possible movement directions.
     */
    static final Direction[] directions = {
            Direction.NORTH,
            Direction.NORTHEAST,
            Direction.EAST,
            Direction.SOUTHEAST,
            Direction.SOUTH,
            Direction.SOUTHWEST,
            Direction.WEST,
            Direction.NORTHWEST,
    };
    static final int RETREAT_THRESHOLD = 500;
    static final int ABANDON_THRESHOLD = 80;
    static int abandonCountdown = ABANDON_THRESHOLD;

    /**
     * A random number generator.
     * We will use this RNG to make some random moves. The Random class is provided by the java.util.Random
     * import at the top of this file. Here, we *seed* the RNG with a constant number (6147); this makes sure
     * we get the same sequence of numbers every time this code is run. This is very useful for debugging!
     */
    static Random rng;
    /**
     * The current state of this duck.
     */
    static MacroState macroState = MacroState.SETUP;
    static RobotType robotType = RobotType.ATTACKER;
    static String indicator;
    static FlagHome[] flagHomes = new FlagHome[GameConstants.NUMBER_FLAGS];
    static int flagHomeIdx;

    /**
     * run() is the method that is called when a robot is instantiated in the Battlecode world.
     * It is like the main function for your robot. If this method returns, the robot dies!
     *
     * @param rc The RobotController object. You use it to perform actions from this robot, and to get
     *           information on its current status. Essentially your portal to interacting with the world.
     **/
    @SuppressWarnings("unused")
    public static void run(RobotController rc) throws GameActionException {
        rng = new Random(rc.getID());
//        robotType = rc.getID() % 8 == 1 ? RobotType.DEFENDER : RobotType.ATTACKER;
        Pathing.leftHanded = rc.getID() % 2 == 0;
        flagHomeIdx = rc.getID() % GameConstants.NUMBER_FLAGS;

        while (true) {
            // This code runs during the entire lifespan of the robot, which is why it is in an infinite
            // loop. If we ever leave this loop and return from run(), the robot dies! At the end of the
            // loop, we call Clock.yield(), signifying that we've done everything we want to do.
            indicator = robotType + " ";

            // Try/catch blocks stop unhandled exceptions, which cause your robot to explode.
            try {
                if (rc.getRoundNum() >= GameConstants.SETUP_ROUNDS) {
                    // Battle
                    macroState = MacroState.BATTLE;

                    // make sure the home flag still exists
                    FlagStatus flagStatus = Communication.getHomeFlagStatus(rc);
                    if (flagStatus == FlagStatus.UNKNOWN) {
                        abandonCountdown--;
                    } else {
                        abandonCountdown = ABANDON_THRESHOLD;
                    }
                    indicator += "h " + flagHomes[flagHomeIdx].loc + " ";
                    if (abandonCountdown <= 0) {
//                        System.out.println("abandoning " + flagHomes[flagHomeIdx].loc);
                        robotType = RobotType.ATTACKER;
                        flagHomeIdx = (flagHomeIdx + 1) % GameConstants.NUMBER_FLAGS;
                    }
                } else {
                    // Setup
                    if (flagHomes[0] == null || flagHomes[1] == null || flagHomes[2] == null) {
                        flagHomes = Communication.getFlagHomes(rc);
//                    System.out.println(flagHomeIdx + " " + flagHomes[flagHomeIdx].flagID + " " + flagHomes[flagHomeIdx].loc);
                    }
                }
                // Make sure you spawn your robot in before you attempt to take any actions!
                // Robots not spawned in do not have vision of any tiles and cannot perform any actions.
                if (!rc.isSpawned() && flagHomes[flagHomeIdx] != null) {
                    // Try to spawn at home first.
                    for (Direction dir : Direction.allDirections()) {
                        MapLocation loc = flagHomes[flagHomeIdx].loc.add(dir);
                        if (rc.canSpawn(loc)) {
                            rc.spawn(loc);
                            break;
                        }
                    }
                }
                if (!rc.isSpawned()) {
                    MapLocation[] spawnLocs = rc.getAllySpawnLocations();
                    // Pick the first possible spawn location
                    for (MapLocation loc : spawnLocs) {
                        if (rc.canSpawn(loc)) {
                            rc.spawn(loc);
                            break;
                        }
                    }
                }
                if (rc.isSpawned()) {
                    for (FlagInfo flagInfo : rc.senseNearbyFlags(-1)) {
                        Communication.reportFlag(rc, flagInfo);
                    }
                    switch (macroState) {
                        case SETUP:
                            if (rc.getRoundNum() == 1 && rc.senseNearbyRobots(-1).length == 0) {
                                flagHomes = Communication.getFlagHomes(rc);
                                robotType = RobotType.DEFENDER;
                                for (int i = 0; i < flagHomes.length; i++) {
                                    if (flagHomes[i] != null && flagHomes[i].loc.distanceSquaredTo(rc.getLocation()) < GameConstants.ATTACK_RADIUS_SQUARED) {
                                        flagHomeIdx = i;
                                        break;
                                    }
                                }
//                                System.out.println("Assigned defender at " + flagHomes[flagHomeIdx].loc);
                            }
                            break;
                        case BATTLE:
                            break;
                    }
//                    Communication.printFlagInfo(rc);
                    switch (robotType) {
                        case ATTACKER:
                            AttackerStrategy.doAttackerStrategy(rc);
                            break;
                        case DEFENDER:
                            DefenderStrategy.doDefenderStrategy(rc);
                            break;
                    }
                }

                rc.setIndicatorString(indicator);
            } catch (GameActionException e) {
                // Oh no! It looks like we did something illegal in the Battlecode world. You should
                // handle GameActionExceptions judiciously, in case unexpected events occur in the game
                // world. Remember, uncaught exceptions cause your robot to explode!
                System.out.println("GameActionException");
                e.printStackTrace();

            } catch (Exception e) {
                // Oh no! It looks like our code tried to do something bad. This isn't a
                // GameActionException, so it's more likely to be a bug in our code.
                System.out.println("Exception");
                e.printStackTrace();

            } finally {
                // Signify we've done everything we want to do, thereby ending our turn.
                // This will make our code wait until the next turn, and then perform this loop again.
                Clock.yield();
            }
            // End of loop: go back to the top. Clock.yield() has ended, so it's time for another turn!
        }

        // Your code should never reach here (unless it's intentional)! Self-destruction imminent...
    }

    public static void updateEnemyRobots(RobotController rc) throws GameActionException {
        // Sensing methods can be passed in a radius of -1 to automatically
        // use the largest possible value.
        RobotInfo[] enemyRobots = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
        if (enemyRobots.length != 0) {
            rc.setIndicatorString("There are nearby enemy robots! Scary!");
            // Save an array of locations with enemy robots in them for future use.
            MapLocation[] enemyLocations = new MapLocation[enemyRobots.length];
            for (int i = 0; i < enemyRobots.length; i++) {
                enemyLocations[i] = enemyRobots[i].getLocation();
            }
            // Let the rest of our team know how many enemy robots we see!
            if (rc.canWriteSharedArray(0, enemyRobots.length)) {
                rc.writeSharedArray(0, enemyRobots.length);
                int numEnemies = rc.readSharedArray(0);
            }
        }
    }
}
