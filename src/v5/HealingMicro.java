package v5;

import battlecode.common.GameActionException;
import battlecode.common.GameConstants;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;

class HealingMicro {
    static void doTryHeal(RobotController rc) throws GameActionException {
        RobotInfo[] healableRobots = rc.senseNearbyRobots(GameConstants.HEAL_RADIUS_SQUARED, rc.getTeam());
        if (healableRobots.length == 0) {
            return;
        }
        RobotInfo lowestRobot = healableRobots[0];
        for (int i = 1; i < healableRobots.length; i++) {
            if (healableRobots[i].getHealth() < lowestRobot.getHealth()) {
                lowestRobot = healableRobots[i];
            }
        }
        if (lowestRobot.getHealth() < GameConstants.DEFAULT_HEALTH && rc.canHeal(lowestRobot.getLocation())) {
            rc.heal(lowestRobot.getLocation());
        }
    }
}
