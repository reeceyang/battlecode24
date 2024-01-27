package v4;

import battlecode.common.*;

import static v4.RobotPlayer.*;

enum DefenderState {
    PATROL, COMBAT
}

class DefenderStrategy {

    static DefenderState state = DefenderState.PATROL;

    static void doDefenderStrategy(RobotController rc) throws GameActionException {
        switch (macroState) {
            case SETUP:

                // If designated a trap-setting duck and 2 or fewer traps exist in vicinity of spawn, set traps
//                if (rc.senseMapInfo(rc.getLocation()).isSpawnZone() && rc.getID() % 10 == 0 && TrapMicro.numTrapsNearby(rc, rc.senseNearbyMapInfos(-1)) < 3) {
//                    TrapMicro.doSetFlagTraps(rc, rc.senseNearbyFlags(-1)[0].getLocation());
//                }
                if (flagHomes[flagHomeIdx] != null) {
                    Pathing.doCheckedNaiveMoveTowards(rc, flagHomes[flagHomeIdx].loc);
                    TrapMicro.doSetFlagTraps(rc, flagHomes[flagHomeIdx].loc);
                    Symmetry.updateSymmetries(rc, flagHomes);
                } else {
                    TrapMicro.doSetFlagTraps(rc, rc.getLocation());
                }

                // If a crumb is sensed, move towards the crumb.
//                CrumbMicro.doScoutCrumb(rc);

                // Set a trap if near enemy territory and if no traps are nearby.
//                TrapMicro.doSetEnemyTraps(rc);

                // Move and attack randomly if no objective.

                // Rarely attempt placing traps behind the robot.
//                MapLocation prevLoc = rc.getLocation().subtract(randomDir);
//                if (rc.canBuild(TrapType.EXPLOSIVE, prevLoc) && rng.nextInt() % 37 == 1)
//                    rc.build(TrapType.EXPLOSIVE, prevLoc);
                break;
            case BATTLE:
                RobotInfo[] enemyRobots = rc.senseNearbyRobots(-1, rc.getTeam().opponent());

                switch (state) {
                    case PATROL:
                        if (enemyRobots.length != 0) {
//                            state = DefenderState.COMBAT;
                        }
                        CombatMicro.doTryShoot(rc);
                        if (rc.getLocation().distanceSquaredTo(flagHomes[flagHomeIdx].loc) >= GameConstants.INTERACT_RADIUS_SQUARED) {
                            Pathing.doCheckedNaiveMoveTowards(rc, flagHomes[flagHomeIdx].loc);
                        } else {
                            // Move randomly if no objective.
                            Pathing.doMoveRealRandom(rc);
                        }
                        HealingMicro.doTryHeal(rc);
                        TrapMicro.doSetFlagTraps(rc, flagHomes[flagHomeIdx].loc); // TODO: this moves at the end, avoid
                        TrapMicro.doSetFlagTraps(rc, rc.getLocation()); // TODO: this moves at the end, avoid
                        break;
                    case COMBAT:
                        switch (CombatMicro.doCombatMicro(rc)) {
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
