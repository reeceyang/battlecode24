package v2;

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
                enemy = enemyRobots[0];
            }
            prevEnemyLoc = enemy.getLocation();
            // pursue enemies with flags or outside action radius
            if (enemy.hasFlag() || rc.getLocation().distanceSquaredTo(enemy.getLocation()) > GameConstants.ATTACK_RADIUS_SQUARED) {
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
        RobotInfo[] enemyRobots = rc.senseNearbyRobots(GameConstants.ATTACK_RADIUS_SQUARED, rc.getTeam().opponent());
        if (enemyRobots.length != 0) {
            MapLocation enemyLoc = enemyRobots[0].getLocation();
            if (rc.canAttack(enemyLoc)) {
                rc.attack(enemyLoc);
                return enemyRobots[0];
            }
        }
        return null;
    }
}
