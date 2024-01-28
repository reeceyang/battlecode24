package v5;

import battlecode.common.*;

import static v5.RobotPlayer.*;

enum FlagStatus {
    HOME(3),
    DROPPED(1),
    HELD(2),
    UNKNOWN(0);

    final int value;

    FlagStatus(int value) {
        this.value = value;
    }
}

public class Communication {
    static final int FLAG_INFO_SIZE = 2;
    static final int FLAG_LOC_OFFSET = 0;
    static final int FLAG_META_OFFSET = 1;
    static final int OUR_FLAGS_START_IDX = 0;
    static final int ENEMY_FLAGS_START_IDX = OUR_FLAGS_START_IDX + GameConstants.NUMBER_FLAGS * FLAG_INFO_SIZE;
    static final int HOME_ENEMY_COUNTS_START_IDX = ENEMY_FLAGS_START_IDX + GameConstants.NUMBER_FLAGS * FLAG_INFO_SIZE;
    static final int SYMMETRY_IDX = GameConstants.SHARED_ARRAY_LENGTH - 1;
    static final int X_MASK = 0b1;
    static final int Y_MASK = 0b10;
    static final int ROT_MASK = 0b100;

    static int getFlagsStartIdx(RobotController rc, Team team) {
        return team.equals(rc.getTeam()) ? OUR_FLAGS_START_IDX : ENEMY_FLAGS_START_IDX;
    }

    static void reportFlag(RobotController rc, FlagInfo flagInfo) throws GameActionException {
        int flagsStartIdx = getFlagsStartIdx(rc, flagInfo.getTeam());
        for (int i = 0; i < GameConstants.NUMBER_FLAGS; i++) {
            int metaIdx = flagsStartIdx + i * FLAG_INFO_SIZE + FLAG_META_OFFSET;
            int locIdx = flagsStartIdx + i * FLAG_INFO_SIZE + FLAG_LOC_OFFSET;
            int oldMeta = rc.readSharedArray(metaIdx);
            // TODO: is initial value guaranteed to be 0?
            if (oldMeta == 0 || readBitPackedFlagID(oldMeta) == flagInfo.getID()) {
                rc.writeSharedArray(locIdx, bitPackLoc(flagInfo.getLocation()));
                FlagStatus flagStatus;
                if (flagInfo.isPickedUp()) {
                    flagStatus = FlagStatus.HELD;
                } else {
                    flagStatus = FlagStatus.DROPPED;
                }
                rc.writeSharedArray(metaIdx, bitPackFlagMeta(flagInfo.getID(), flagStatus));
                return;
            }
        }
    }

    static void invalidateFlag(RobotController rc, int flagID, int metaIdx) throws GameActionException {
        rc.writeSharedArray(metaIdx, bitPackFlagMeta(flagID, FlagStatus.UNKNOWN));
    }

    static int bitPackLoc(MapLocation loc) {
//        System.out.println("bitPackLoc: ");
//        System.out.println(loc.x + " " + loc.y);
//        System.out.println(loc.x << 8 + loc.y);
        return (loc.x << 8) + loc.y;
    }

    static MapLocation readBitPackedLoc(int bitPackedLoc) {
        return new MapLocation(bitPackedLoc >> 8, bitPackedLoc & 0x00ff);
    }

    static int bitPackFlagMeta(int flagID, FlagStatus flagStatus) {
//        System.out.println("bitPackFlagMeta: ");
//        System.out.println(flagInfo.getID() + " " + flagStatus.value);
//        System.out.println(flagInfo.getID() << 2 + flagStatus.value);
        return (flagID << 2) + flagStatus.value;
    }

    static int readBitPackedFlagID(int bitPackedFlagMeta) {
        return bitPackedFlagMeta >> 2;
    }

    static FlagStatus readBitPackedFlagStatus(int bitPackedFlagMeta) {
        switch (bitPackedFlagMeta & 0x0003) {
            case 1:
                return FlagStatus.DROPPED;
            case 2:
                return FlagStatus.HELD;
            case 3:
                return FlagStatus.HOME;
        }
        return FlagStatus.UNKNOWN;
    }

    /**
     * Returns the nearest flag owned by `team` with status `flagStatus`.
     * Invalidate flags that are not where they are supposed to be.
     *
     * @param rc
     * @param team        the team that owns the flag
     * @param flagStatus
     * @param nearbyFlags array of nearby flags this robot sensed
     * @return the nearest flag owned by `team` with status `flagStatus`.
     * @throws GameActionException
     */
    static MapLocation getNearestFlag(RobotController rc, Team team, FlagStatus flagStatus, FlagInfo[] nearbyFlags) throws GameActionException {
        MapLocation nearestLoc = null;
        int flagsStartIdx = getFlagsStartIdx(rc, team);
        for (int i = 0; i < GameConstants.NUMBER_FLAGS; i++) {
            int metaIdx = flagsStartIdx + i * FLAG_INFO_SIZE + FLAG_META_OFFSET;
            int locIdx = flagsStartIdx + i * FLAG_INFO_SIZE + FLAG_LOC_OFFSET;
            int bitPackedMeta = rc.readSharedArray(metaIdx);
            int bitPackedLoc = rc.readSharedArray(locIdx);
            FlagStatus readFlagStatus = readBitPackedFlagStatus(bitPackedMeta);
            if (readFlagStatus == flagStatus) {
                MapLocation flagLoc = readBitPackedLoc(bitPackedLoc);

                // invalidate flags in locations we can sense
                if (rc.canSenseLocation(flagLoc)) {
                    boolean found = false;
                    for (FlagInfo nearbyFlag : nearbyFlags) {
                        if (nearbyFlag.getLocation().equals(flagLoc)) {
//                            System.out.println("validated " + readBitPackedFlagID(bitPackedMeta) + " " + flagLoc);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
//                        System.out.println("invalidated " + readBitPackedFlagID(bitPackedMeta) + " " + flagLoc);
                        invalidateFlag(rc, readBitPackedFlagID(bitPackedMeta), metaIdx);
                        continue;
                    }
                }
                return flagLoc;

//                if (nearestLoc == null ||
//                        rc.getLocation().distanceSquaredTo(flagLoc) < rc.getLocation().distanceSquaredTo(nearestLoc)) {
//                    nearestLoc = flagLoc;
//                }
            }
        }
        return null;
//        return nearestLoc;
    }

    static void printFlagInfo(RobotController rc) throws GameActionException {
        System.out.println("Our flags: ");
        printFlagInfoHelper(rc, OUR_FLAGS_START_IDX);

        System.out.println("Enemy flags: ");
        printFlagInfoHelper(rc, ENEMY_FLAGS_START_IDX);
    }

    private static void printFlagInfoHelper(RobotController rc, int flagsStartIdx) throws GameActionException {
        for (int i = 0; i < GameConstants.NUMBER_FLAGS; i++) {
            int metaIdx = flagsStartIdx + i * FLAG_INFO_SIZE + FLAG_META_OFFSET;
            int locIdx = flagsStartIdx + i * FLAG_INFO_SIZE + FLAG_LOC_OFFSET;
            int bitPackedMeta = rc.readSharedArray(metaIdx);
            int bitPackedLoc = rc.readSharedArray(locIdx);
            System.out.println(readBitPackedFlagID(bitPackedMeta) + " " + readBitPackedFlagStatus(bitPackedMeta) + " " + readBitPackedLoc(bitPackedLoc));
        }
    }

    static FlagHome[] getFlagHomes(RobotController rc) throws GameActionException {
        FlagHome[] flagHomes = new FlagHome[GameConstants.NUMBER_FLAGS];
        for (int i = 0; i < GameConstants.NUMBER_FLAGS; i++) {
            int metaIdx = OUR_FLAGS_START_IDX + i * FLAG_INFO_SIZE + FLAG_META_OFFSET;
            int locIdx = OUR_FLAGS_START_IDX + i * FLAG_INFO_SIZE + FLAG_LOC_OFFSET;
            int bitPackedMeta = rc.readSharedArray(metaIdx);
            int bitPackedLoc = rc.readSharedArray(locIdx);
            if (readBitPackedFlagStatus(bitPackedMeta) != FlagStatus.UNKNOWN) {
                flagHomes[i] = new FlagHome(readBitPackedLoc(bitPackedLoc), readBitPackedFlagID(bitPackedMeta));
            }
        }
        return flagHomes;
    }

    static FlagStatus getHomeFlagStatus(RobotController rc) throws GameActionException {
        for (int i = 0; i < GameConstants.NUMBER_FLAGS; i++) {
            int metaIdx = OUR_FLAGS_START_IDX + i * FLAG_INFO_SIZE + FLAG_META_OFFSET;
            int bitPackedMeta = rc.readSharedArray(metaIdx);
            int flagID = readBitPackedFlagID(bitPackedMeta);
            if (flagID == flagHomes[flagHomeIdx].flagID) {
                return readBitPackedFlagStatus(bitPackedMeta);
            }
        }
        return FlagStatus.UNKNOWN;
    }

    static void reportHomeEnemyCount(RobotController rc, int flagIdx, int numEnemies) throws GameActionException {
        rc.writeSharedArray(HOME_ENEMY_COUNTS_START_IDX + flagIdx, numEnemies);
    }

    static MapLocation getMostEnemyCountHome(RobotController rc) throws GameActionException {
        MapLocation loc = null;
        int mostEnemyCount = 0;
        for (int i = 0; i < GameConstants.NUMBER_FLAGS; i++) {
            int metaIdx = OUR_FLAGS_START_IDX + i * FLAG_INFO_SIZE + FLAG_META_OFFSET;
            int bitPackedMeta = rc.readSharedArray(metaIdx);
            // Don't reinforce a flag of an unknown status
            if (readBitPackedFlagStatus(bitPackedMeta) == FlagStatus.UNKNOWN) {
                continue;
            }
            int enemyCount = rc.readSharedArray(HOME_ENEMY_COUNTS_START_IDX + i);
            if (enemyCount > mostEnemyCount) {
                mostEnemyCount = enemyCount;
                loc = flagHomes[i].loc;
            }
        }
        return loc;
    }

    static void printHomeEnemyCounts(RobotController rc) throws GameActionException {
        for (int i = 0; i < GameConstants.NUMBER_FLAGS; i++) {
            int enemyCount = rc.readSharedArray(HOME_ENEMY_COUNTS_START_IDX + i);
        }
    }
}
