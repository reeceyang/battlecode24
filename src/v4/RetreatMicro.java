package v4;

import battlecode.common.*;

import static v4.RobotPlayer.*;

class RetreatMicro {
    static void doRetreatClosestSpawn(RobotController rc) throws GameActionException {
        MapLocation[] spawnLocs = rc.getAllySpawnLocations();
        MapLocation closestSpawnLoc = spawnLocs[0];
        for (int i = 1; i < spawnLocs.length; i++) {
            if (rc.getLocation().distanceSquaredTo(spawnLocs[i]) < rc.getLocation().distanceSquaredTo(closestSpawnLoc)) {
                closestSpawnLoc = spawnLocs[i];
            }
        }
        Pathing.moveTowards(rc, closestSpawnLoc);
        CombatMicro.doTryShoot(rc); // attempt to move-shoot
        TrapMicro.doSetFlagTraps(rc, closestSpawnLoc); // TODO: is this useful
    }

    static void doRetreatHome(RobotController rc) throws GameActionException {
        Pathing.moveTowards(rc, flagHomes[flagHomeIdx].loc);
        CombatMicro.doTryShoot(rc); // attempt to move-shoot
        TrapMicro.doSetFlagTraps(rc, flagHomes[flagHomeIdx].loc); // TODO: is this useful
    }
}
