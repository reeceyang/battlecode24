package v3;

import battlecode.common.*;

import static v3.RobotPlayer.*;

enum DefenderState {
    PATROL, COMBAT
}

class DefenderStrategy {

    static DefenderState state = DefenderState.PATROL;

    static void doDefenderStrategy(RobotController rc) throws GameActionException {
        Direction randomDir = directions[rng.nextInt(directions.length)];
        switch (macroState) {
            case SETUP:

                // If designated a trap-setting duck and 2 or fewer traps exist in vicinity of spawn, set traps
                if (rc.senseMapInfo(rc.getLocation()).isSpawnZone() && rc.getID() % 10 == 0 && TrapMicro.numTrapsNearby(rc, rc.senseNearbyMapInfos(-1)) < 3) {
                    TrapMicro.doSetFlagTraps(rc, rc.senseNearbyFlags(-1)[0].getLocation());
                }

                // If a crumb is sensed, move towards the crumb.
                CrumbMicro.doScoutCrumb(rc);

                // Set a trap if near enemy territory and if no traps are nearby.
                TrapMicro.doSetEnemyTraps(rc);

                // Move and attack randomly if no objective.
                if (rc.canMove(randomDir)) {
                    rc.move(randomDir);
                }

                // Rarely attempt placing traps behind the robot.
                MapLocation prevLoc = rc.getLocation().subtract(randomDir);
                if (rc.canBuild(TrapType.EXPLOSIVE, prevLoc) && rng.nextInt() % 37 == 1)
                    rc.build(TrapType.EXPLOSIVE, prevLoc);
                break;
            case BATTLE:
                RobotInfo[] enemyRobots = rc.senseNearbyRobots(-1, rc.getTeam().opponent());

                switch (state) {
                    case PATROL:
                        if (enemyRobots.length != 0) {
                            CombatMicro.doCombatMicro(rc, enemyRobots);
                            state = DefenderState.COMBAT;
                        } else {
//                            MapLocation[] spawnLocs = rc.getAllySpawnLocations();
//                            Pathing.moveTowards(rc, spawnLocs[rng.nextInt(spawnLocs.length)]);
                            RetreatMicro.doRetreat(rc);
                            HealingMicro.doTryHeal(rc);
                            // Rarely attempt placing traps behind the robot.
                            if (rc.canBuild(TrapType.EXPLOSIVE, rc.getLocation()) && rng.nextInt() % 37 == 1)
                                rc.build(TrapType.EXPLOSIVE, rc.getLocation());
                        }
                        break;
                    case COMBAT:
                        switch (CombatMicro.doCombatMicro(rc, enemyRobots)) {
                            case FIGHTING:
                                break;
                            case SAFE:
                                HealingMicro.doTryHeal(rc);
                                state = DefenderState.PATROL;
                                break;
                        }
                        break;
                }
                break;
        }
        indicator += state + " " + Pathing.currentTarget;
    }
}
