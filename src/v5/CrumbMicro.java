package v5;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

public class CrumbMicro {
    static void doScoutCrumb(RobotController rc) throws GameActionException {
        MapLocation[] crumbLocs = rc.senseNearbyCrumbs(-1);
        if (crumbLocs.length > 0) {
            Pathing.moveTowards(rc, crumbLocs[0]);
        }
    }
}
