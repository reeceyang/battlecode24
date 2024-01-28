package v5;

import battlecode.common.*;

enum MapSymmetry {
    X, // symmetric in x, i.e. in reflection over y-axis
    Y, // symmetric in y, i.e. in reflection over x-axis
    ROT // symmetric by 180-degree rotation
}

public class Symmetry {

    static void updateSymmetries(RobotController rc, FlagHome[] flagHomes) throws GameActionException {
        if (isSymmetryPossible(rc, MapSymmetry.X)) {
            if (!isSymmetryCompatible(rc, MapSymmetry.X, flagHomes) || !checkEnemyFlags(rc, MapSymmetry.X, flagHomes)) {
                updateSymmetryNot(rc, MapSymmetry.X);
            }
        }
        if (isSymmetryPossible(rc, MapSymmetry.Y)) {
            if (!isSymmetryCompatible(rc, MapSymmetry.Y, flagHomes) || !checkEnemyFlags(rc, MapSymmetry.Y, flagHomes)) {
                updateSymmetryNot(rc, MapSymmetry.Y);
            }
        }
        if (isSymmetryPossible(rc, MapSymmetry.ROT)) {
            if (!isSymmetryCompatible(rc, MapSymmetry.ROT, flagHomes) || !checkEnemyFlags(rc, MapSymmetry.ROT, flagHomes)) {
                updateSymmetryNot(rc, MapSymmetry.ROT);
            }
        }
    }


    // Compare current location to locations of 3 known flags to determine presence/absence of symmetry
    static boolean isSymmetryCompatible(RobotController rc, MapSymmetry s, FlagHome[] flagHomes) throws GameActionException {
        MapLocation currLoc = rc.getLocation();
        for (FlagHome flagHome : flagHomes) {
            if (flagHome == null) {
                continue;
            }
            MapLocation symmFlagLoc = findSymmetricLoc(rc, flagHome.loc, s);
            rc.setIndicatorDot(symmFlagLoc, ((s == MapSymmetry.X) ? 1 : 0) * 255, ((s == MapSymmetry.Y) ? 1 : 0) * 255, ((s == MapSymmetry.ROT) ? 1 : 0) * 255);
            if (symmFlagLoc.isWithinDistanceSquared(currLoc, GameConstants.VISION_RADIUS_SQUARED)) {
                MapInfo symmInfo = rc.senseMapInfo(symmFlagLoc);
                if (!symmInfo.isSpawnZone()) {
                    return false;
                }
            }
        }
        return true;
    }

    static int sMask(MapSymmetry s) {
        int mask = 0;
        switch (s) {
            case X:
                mask = Communication.X_MASK;
                break;
            case Y:
                mask = Communication.Y_MASK;
                break;
            case ROT:
                mask = Communication.ROT_MASK;
                break;
        }
        return mask;
    }

    // Update shared array to write that map is not compatible with one symmetry
    static void updateSymmetryNot(RobotController rc, MapSymmetry s) throws GameActionException {
        int readSymmetry = rc.readSharedArray(Communication.SYMMETRY_IDX);
        if (isSymmetryPossible(rc, s)) {
            rc.writeSharedArray(Communication.SYMMETRY_IDX, readSymmetry - sMask(s));
        }
    }

    // Read from shared array to see whether certain symmetry is still possible
    static boolean isSymmetryPossible(RobotController rc, MapSymmetry s) throws GameActionException {
        int readSymmetry = rc.readSharedArray(Communication.SYMMETRY_IDX);
        boolean isPossible = (readSymmetry & sMask(s)) > 0;
        return isPossible;
    }

    static MapLocation decidePlausibleLoc(RobotController rc, FlagHome[] flagHomes) throws GameActionException {
        MapLocation[] plausibleLocs = {null, null, null};
        for (MapSymmetry s : new MapSymmetry[]{MapSymmetry.X, MapSymmetry.Y, MapSymmetry.ROT}) {
            if (isSymmetryPossible(rc, s)) {
                for (int i = 0; i < 3; i++) {
                    plausibleLocs[i] = findSymmetricLoc(rc, flagHomes[i].loc, s);
                }
                return plausibleLocs[0];
            }
        }
        return null;
    }

    static MapLocation[] getPlausibleLocs(RobotController rc, FlagHome[] flagHomes) throws GameActionException {
        MapLocation[] plausibleLocs = {null, null, null};
        for (MapSymmetry s : new MapSymmetry[]{MapSymmetry.X, MapSymmetry.Y, MapSymmetry.ROT}) {
            if (isSymmetryPossible(rc, s)) {
                for (int i = 0; i < 3; i++) {
                    plausibleLocs[i] = findSymmetricLoc(rc, flagHomes[i].loc, s);
                }
            }
        }
        return plausibleLocs;
    }

    // Compare other team's flags' broadcasted location to locations of 3 known flags to determine presence/absence of symmetry
    static boolean checkEnemyFlags(RobotController rc, MapSymmetry s, FlagHome[] flagHomes) throws GameActionException {
        MapLocation[] approxEnemyFlagLocs = rc.senseBroadcastFlagLocations();
        for (FlagHome flagHome : flagHomes) {
            if (flagHome == null) {
                continue;
            }
            MapLocation symmFlagLoc = findSymmetricLoc(rc, flagHome.loc, s);
            for (MapLocation enemyFlagLoc : approxEnemyFlagLocs) {
                if (symmFlagLoc.isWithinDistanceSquared(enemyFlagLoc, GameConstants.FLAG_BROADCAST_NOISE_RADIUS)) {
                    return true;
                }
            }
        }
        return false;
    }

    static MapLocation findSymmetricLoc(RobotController rc, MapLocation loc, MapSymmetry s) {
        int h = rc.getMapHeight();
        int w = rc.getMapWidth();
        MapLocation newLoc = null;
        switch (s) {
            case Y:
                newLoc = new MapLocation(loc.x, h - loc.y - 1);
                break;
            case X:
                newLoc = new MapLocation(w - loc.x - 1, loc.y);
                break;
            case ROT:
                newLoc = new MapLocation(w - loc.x - 1, h - loc.y - 1);
                break;
        }
        return newLoc;
    }
}
