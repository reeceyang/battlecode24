package v4;

import battlecode.common.*;

enum CombatResult {
    FIGHTING, SAFE
}

class CombatMicro {

    static MapLocation prevEnemyLoc;

    static CombatResult doCombatMicro(RobotController rc, RobotInfo[] enemyRobots) throws GameActionException {
        if (enemyRobots.length != 0) {
            RobotInfo enemy = doTryShoot(rc);
            Direction nextDir;
            if (enemy == null) {
                enemy = getNextTarget(enemyRobots);
            }
            prevEnemyLoc = enemy.getLocation();
            // if we can attack the next turn and we have enough health
            if (rc.getActionCooldownTurns() <= 1 && rc.getHealth() > RobotPlayer.RETREAT_THRESHOLD
                    // pursue enemies with flags or outside action radius
                    && (enemy.hasFlag() || rc.getLocation().distanceSquaredTo(enemy.getLocation()) > GameConstants.ATTACK_RADIUS_SQUARED)
            ) {
                nextDir = rc.getLocation().directionTo(enemy.getLocation());
            } else {
                // kite away from enemies in action radius
                nextDir = enemy.getLocation().directionTo(rc.getLocation());
            }
            MapLocation nextLoc = rc.getLocation().add(nextDir);
            Pathing.moveTowards(rc, nextLoc);
            doTryShoot(rc); // move shoot
            return CombatResult.FIGHTING;
        }
        if (prevEnemyLoc != null) {
            // attempt to find the enemy again
            Pathing.moveTowards(rc, prevEnemyLoc);
            RobotInfo[] newNearbyRobots = rc.senseNearbyRobots(-1, rc.getTeam().opponent());
            if (newNearbyRobots.length != 0) {
                prevEnemyLoc = newNearbyRobots[0].getLocation();
//                MapLocation trapLoc = rc.getLocation().add(rc.getLocation().directionTo(prevEnemyLoc));
//                if (rc.getActionCooldownTurns() == 0 && rc.canBuild(TrapType.EXPLOSIVE, trapLoc)) {
//                    rc.build(TrapType.EXPLOSIVE, trapLoc);
//                }
                return CombatResult.FIGHTING;
            }
        }
        prevEnemyLoc = null;
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
     * Returns the next target out of an array of enemies. Prefers enemies with flags.
     *
     * @param enemyRobots NONEMPTY array to search through
     * @return best next target
     */
    static RobotInfo getNextTarget(RobotInfo[] enemyRobots) {
        // pursue enemy robots with flags
        for (int i = 1; i < enemyRobots.length; i++) {
            if (enemyRobots[i].hasFlag()) {
                return enemyRobots[i];
            }
        }
        return enemyRobots[0];
    }
}
