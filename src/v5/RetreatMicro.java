package v5;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

import static v5.RobotPlayer.*;

class RetreatMicro {
    static void doRetreatClosestSpawn(RobotController rc) throws GameActionException {
        MapLocation closestSpawnLoc = flagHomes[0].loc;
        for (int i = 1; i < flagHomes.length; i++) {
            if (rc.getLocation().distanceSquaredTo(flagHomes[i].loc) < rc.getLocation().distanceSquaredTo(closestSpawnLoc)) {
                closestSpawnLoc = flagHomes[i].loc;
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
