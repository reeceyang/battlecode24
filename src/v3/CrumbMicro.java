package v3;

import battlecode.common.*;

public class CrumbMicro {
    static void doScoutCrumb(RobotController rc) throws GameActionException {
        MapLocation[] crumbLocs = rc.senseNearbyCrumbs(-1);
        int i = 0;
        while (i < crumbLocs.length) {
            Direction dir = rc.getLocation().directionTo(crumbLocs[i]);
            if (rc.canMove(dir)) {
                rc.move(dir);
                i = crumbLocs.length;
            } else {
                i++;
            }
        }
    }
}
