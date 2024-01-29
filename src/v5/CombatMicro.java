package v5;

import battlecode.common.*;

enum CombatResult {
    FIGHTING, SAFE
}

class CombatMicro {

    static MapLocation prevEnemyLoc;

    // TODO: add arg that is to be reckless
    static CombatResult doCombatMicro(RobotController rc) throws GameActionException {
        RobotInfo[] enemyRobots = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
        RobotInfo[] ourRobots = rc.senseNearbyRobots(-1, rc.getTeam());
        if (enemyRobots.length != 0) {
            RobotInfo enemy = doTryShoot(rc);
            if (enemy == null) {
                enemy = getNextTarget(enemyRobots);
            }
            prevEnemyLoc = enemy.getLocation();
            if (!RobotPlayer.BE_SAFER || AttackerStrategy.state == AttackerState.REINFORCE || AttackerStrategy.state == AttackerState.RECAPTURE) {

            }
            // if we can attack the next turn and we have enough health
            else if (rc.getActionCooldownTurns() <= 1 //&& rc.getHealth() > RobotPlayer.RETREAT_THRESHOLD
                    // pursue enemies with flags or outside action radius
                    && (enemy.hasFlag()
                    || rc.getLocation().distanceSquaredTo(enemy.getLocation()) > GameConstants.ATTACK_RADIUS_SQUARED)
            ) {
                Pathing.moveTowards(rc, enemy.getLocation());
            } else if (ourRobots.length > 0) {
                Pathing.moveTowards(rc, ourRobots[0].getLocation());
            } else if (enemyRobots.length > 1) {
                // kite away from enemies in action radius
                Direction nextDir = enemy.getLocation().directionTo(rc.getLocation());
                Pathing.moveTowards(rc, rc.getLocation().add(nextDir));
            }
            doTryShoot(rc); // move shoot

            HealingMicro.doTryHeal(rc);
            return CombatResult.FIGHTING;
        }

        // no nearby enemies, try to heal?
        HealingMicro.doTryHeal(rc);

//        if (prevEnemyLoc != null) {
//            // attempt to find the enemy again
//            Pathing.moveTowards(rc, prevEnemyLoc);
//            RobotInfo[] newNearbyRobots = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
//            if (newNearbyRobots.length != 0) {
//                prevEnemyLoc = newNearbyRobots[0].getLocation();
////                MapLocation trapLoc = rc.getLocation().add(rc.getLocation().directionTo(prevEnemyLoc));
////                if (rc.getActionCooldownTurns() == 0 && rc.canBuild(TrapType.EXPLOSIVE, trapLoc)) {
////                    rc.build(TrapType.EXPLOSIVE, trapLoc);
////                }
//                return CombatResult.FIGHTING;
//            }
//        }
//        prevEnemyLoc = null;
        return CombatResult.SAFE;
    }

    static RobotInfo doTryShoot(RobotController rc) throws GameActionException {
        RobotInfo[] shootableEnemyRobots = rc.senseNearbyRobots(GameConstants.ATTACK_RADIUS_SQUARED, rc.getTeam().opponent());
        if (shootableEnemyRobots.length != 0) {
            RobotInfo target = getNextTarget(shootableEnemyRobots);
            MapLocation enemyLoc = target.getLocation();
            if (rc.canAttack(enemyLoc)) {
                rc.attack(enemyLoc);
                return target;
            }
        }
        return null;
    }

    /**
     * Returns the next target out of a NONEMPTY array of enemies.
     * Prefers enemies with flags, then lowest health enemies.
     *
     * @param enemyRobots NONEMPTY array to search through
     * @return best next target
     */
    static RobotInfo getNextTarget(RobotInfo[] enemyRobots) {
        RobotInfo lowestEnemy = enemyRobots[0];
        for (int i = 1; i < enemyRobots.length; i++) {
            if (enemyRobots[i].hasFlag()) {
                return enemyRobots[i];
            } else if (enemyRobots[i].getHealth() < lowestEnemy.getHealth()) {
                lowestEnemy = enemyRobots[i];
            }
        }
        return lowestEnemy;
    }
}
