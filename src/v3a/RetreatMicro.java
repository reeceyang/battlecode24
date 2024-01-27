package v3a;

import battlecode.common.*;

class RetreatMicro {
    public static void doRetreat(RobotController rc) throws GameActionException {
        MapLocation[] spawnLocs = rc.getAllySpawnLocations();
        MapLocation closestSpawnLoc = spawnLocs[0];
        for (int i = 1; i < spawnLocs.length; i++) {
            if (rc.getLocation().distanceSquaredTo(spawnLocs[i]) < rc.getLocation().distanceSquaredTo(closestSpawnLoc)) {
                closestSpawnLoc = spawnLocs[i];
            }
        }
        Pathing.moveTowards(rc, closestSpawnLoc);
        CombatMicro.doTryShoot(rc); // attempt to move-shoot
    }
}
