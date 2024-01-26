package v3;

import battlecode.common.*;

public class TrapMicro {
    static TrapType decideTrap(RobotController rc) {
        if (rc.getCrumbs() > 2400) {
            return TrapType.EXPLOSIVE;
        }
        return TrapType.STUN;
    }

    static void doSetFlagTraps(RobotController rc, MapLocation flagLoc) throws GameActionException {
        if (rc.getLocation().equals(flagLoc)) {
            TrapType flagTrap = decideTrap(rc);
            MapLocation[] flagLocs = {flagLoc.add(Direction.NORTH), flagLoc.add(Direction.EAST), flagLoc.add(Direction.SOUTH), flagLoc.add(Direction.WEST)};
            for (int i = 0; i < 4; i++) {
                if (rc.canBuild(flagTrap, flagLocs[i])) {
                    rc.build(flagTrap, flagLocs[i]);
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
                if (rc.canBuild(TrapType.STUN, rc.getLocation())) {
                    rc.build(decideTrap(rc), rc.getLocation());
                }
            }
        }
    }

}
