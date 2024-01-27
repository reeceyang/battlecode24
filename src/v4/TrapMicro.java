package v4;

import battlecode.common.*;

public class TrapMicro {
    static TrapType decideTrap(RobotController rc) {
        return TrapType.EXPLOSIVE;
//        if (rc.getCrumbs() > 2400) {
//            return TrapType.EXPLOSIVE;
//        }
//        return TrapType.STUN;
    }

    static void doSetFlagTraps(RobotController rc, MapLocation flagLoc) throws GameActionException {
        if (rc.getLocation().equals(flagLoc)) {
            TrapType flagTrap = decideTrap(rc);
            for (Direction dir : Direction.allDirections()) {
                MapLocation loc = flagLoc.add(dir);
                if (rc.canBuild(flagTrap, loc)) {
                    rc.build(flagTrap, loc);
                }
            }
        } else {
            Pathing.moveTowards(rc, flagLoc);
        }
    }

    static int numTrapsNearby(RobotController rc, MapInfo[] nearbyLocs) {
        int numTraps = 0;
        for (int j = 0; j < nearbyLocs.length; j++) {
            if (nearbyLocs[j].getTrapType() != TrapType.NONE) {
                numTraps++;
            }
        }
        return numTraps;
    }

    static void doSetEnemyTraps(RobotController rc) throws GameActionException {
        MapInfo[] nearbyLocs = rc.senseNearbyMapInfos(10);
        for (int i = 0; i < nearbyLocs.length; i++) {
            if (nearbyLocs[i].getTeamTerritory() != rc.getTeam()) { // Near enemy territory: might want to place trap
                if (numTrapsNearby(rc, nearbyLocs) != 0) {
                    return;
                }
                if (rc.canBuild(decideTrap(rc), rc.getLocation())) {
                    rc.build(decideTrap(rc), rc.getLocation());
                }
            }
        }
    }

}
