package v3;

import battlecode.common.*;

public class Pathing {

    static final int baseExclusionRadius = 16;
    // Basic bug nav - Bug 0
    static final int STUCK_RADIUS_SQ = 16;
    static final int TIME_LIMIT = 3;
    public static boolean leftHanded = false;
    public static int BUG_MODE_TIME_LIMIT;
    static Direction currentDirection = null;
    static MapLocation previousTarget = null;
    static MapLocation currentTarget = null;
    static int progressCountdown = TIME_LIMIT;
    static int closest = Integer.MAX_VALUE;
    static boolean bugMode = false;

    static void moveTowards(RobotController rc, MapLocation target) throws GameActionException {
        currentTarget = target;
        if (rc.getLocation().equals(target)) {
//            bugMode = false;
//            progressCountdown = TIME_LIMIT;
            return;
        }
        if (!rc.isMovementReady()) {
            return;
        }
        if (!target.equals(previousTarget)) {
            previousTarget = target;
            closest = rc.getLocation().distanceSquaredTo(target);
        }
//        if (rc.getLocation().isAdjacentTo(target)) {
//            bugMode = false;
//            progressCountdown = TIME_LIMIT;
//        }
        // apply bug mode override
//        if (bugOverride) bugMode = true;
//        if (!bugMode) {
//            int bytecodesLeft = Clock.getBytecodesLeft();
//            if (bytecodesLeft > 7000) {
//                BellmanFord.doBellmanFord(rc, target, moveTwice);
//            } else if (bytecodesLeft > 6000) {
//                BellmanFord.doCheapBellmanFord(rc, target, moveTwice);
//            } else {
//                BellmanFord.doCheapestBellmanFord(rc, target, moveTwice);
//            }
//			rc.setIndicatorString("bellman ford used " + (bytecodesLeft - Clock.getBytecodesLeft()));
//        } else {
        doBugMode(rc, target);
//        rc.setIndicatorString("bugmode" + bugMode + " " + progressCountdown + " " + target + "left" + leftHanded + currentDirection + closest + " " + rc.getLocation().distanceSquaredTo(target));
        int currentDistance = rc.getLocation().distanceSquaredTo(target);
        if (currentDistance < closest) {
            closest = currentDistance;
        }
//        } else {
//            progressCountdown--;
//            if (progressCountdown <= 0) {
//                bugMode = !bugMode;
//                progressCountdown = bugMode ? BUG_MODE_TIME_LIMIT : TIME_LIMIT;
//            }
//        }
    }

    static void doBeeline(RobotController rc, Direction d) throws GameActionException {
        if (rc.canMove(d)) {
            rc.move(d);
            currentDirection = null; // there is no obstacle we're going around
        }
    }

    static void doCircle(RobotController rc) throws GameActionException {
        if (rc.canMove(currentDirection)) {
            rc.move(currentDirection);
            if (leftHanded) {
                currentDirection = currentDirection.rotateRight();
            } else {
                currentDirection = currentDirection.rotateLeft();
            }
        }
    }

    static void doBugMode(RobotController rc, MapLocation target) throws GameActionException {
        Direction d = rc.getLocation().directionTo(target);
        MapLocation next = rc.getLocation().add(d);
        // only start moving towards the target again if we've actually gotten closer
        if (next.distanceSquaredTo(target) < closest) {
            if (rc.canMove(d)) {
                doBeeline(rc, d);
                return;
            }
            if (rc.canFill(next)) {
                rc.fill(next);
                doBeeline(rc, d);
                return;
            }
        }
        // Going around some obstacle: can't move towards d because there's an obstacle there
        // Idea: keep the obstacle on our right hand
        if (currentDirection == null) {
            currentDirection = d;
        }
        // Try to move in a way that keeps the obstacle on our right or left
        for (int i = 0; i < 8; i++) {
            next = rc.getLocation().add(currentDirection);
            // TODO: consider implementing if we're adjacent to the target then we can only move to a location that is also adjacent
            if (rc.canMove(currentDirection)) {
                doCircle(rc);
                return;
            }
            if (rc.canFill(next)) {
                rc.fill(next);
                doCircle(rc);
                return;
            }
            if (leftHanded) {
                currentDirection = currentDirection.rotateLeft();
            } else {
                currentDirection = currentDirection.rotateRight();
            }
        }
    }


}