package v3;

import battlecode.common.*;

public class CrumbMicro {
    static void doScoutCrumb(RobotController rc) throws GameActionException {
        MapLocation[] crumbLocs = rc.senseNearbyCrumbs(-1);
        if (crumbLocs.length > 0) {
            Pathing.moveTowards(rc, crumbLocs[0]);
        }
    }
}
