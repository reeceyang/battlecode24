package v3a;

import battlecode.common.*;

import static v3a.RobotPlayer.*;

enum DefenderState {
    PATROL, COMBAT
}

class DefenderStrategy {

    static DefenderState state = DefenderState.PATROL;

    static void doDefenderStrategy(RobotController rc) throws GameActionException {
        Direction randomDir = directions[rng.nextInt(directions.length)];
        switch (macroState) {
            case SETUP:
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
                            MapLocation[] spawnLocs = rc.getAllySpawnLocations();
                            Pathing.moveTowards(rc, spawnLocs[rng.nextInt(spawnLocs.length)]);
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
