package v4;

import battlecode.common.*;

public class BellmanFord {
public static boolean doBellmanFord(RobotController rc, MapLocation target) throws GameActionException {
    MapLocation bot = rc.getLocation();
MapLocation pos;
Direction currentDir;
int wellCost;
boolean open00 = false;
int cost00 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + -2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open00 = true;
        cost00 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open00 = true;
    cost00 = 100 * pos.distanceSquaredTo(target);
}
boolean open01 = false;
int cost01 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open01 = true;
        cost01 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open01 = true;
    cost01 = 100 * pos.distanceSquaredTo(target);
}
boolean open02 = false;
int cost02 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + 0);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open02 = true;
        cost02 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open02 = true;
    cost02 = 100 * pos.distanceSquaredTo(target);
}
boolean open03 = false;
int cost03 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open03 = true;
        cost03 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open03 = true;
    cost03 = 100 * pos.distanceSquaredTo(target);
}
boolean open04 = false;
int cost04 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open04 = true;
        cost04 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open04 = true;
    cost04 = 100 * pos.distanceSquaredTo(target);
}
boolean open10 = false;
int cost10 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + -2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open10 = true;
        cost10 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open10 = true;
    cost10 = 100 * pos.distanceSquaredTo(target);
}
boolean open11 = false;
int cost11 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open11 = true;
        cost11 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open11 = true;
    cost11 = 100 * pos.distanceSquaredTo(target);
}
boolean open12 = false;
int cost12 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + 0);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open12 = true;
        cost12 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open12 = true;
    cost12 = 100 * pos.distanceSquaredTo(target);
}
boolean open13 = false;
int cost13 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open13 = true;
        cost13 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open13 = true;
    cost13 = 100 * pos.distanceSquaredTo(target);
}
boolean open14 = false;
int cost14 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open14 = true;
        cost14 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open14 = true;
    cost14 = 100 * pos.distanceSquaredTo(target);
}
boolean open20 = false;
int cost20 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + -2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open20 = true;
        cost20 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open20 = true;
    cost20 = 100 * pos.distanceSquaredTo(target);
}
boolean open21 = false;
int cost21 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open21 = true;
        cost21 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open21 = true;
    cost21 = 100 * pos.distanceSquaredTo(target);
}
boolean open22 = false;
int cost22 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + 0);
open22 = true;
cost22 = 100 * (pos.distanceSquaredTo(target));
boolean open23 = false;
int cost23 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open23 = true;
        cost23 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open23 = true;
    cost23 = 100 * pos.distanceSquaredTo(target);
}
boolean open24 = false;
int cost24 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open24 = true;
        cost24 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open24 = true;
    cost24 = 100 * pos.distanceSquaredTo(target);
}
boolean open30 = false;
int cost30 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + -2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open30 = true;
        cost30 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open30 = true;
    cost30 = 100 * pos.distanceSquaredTo(target);
}
boolean open31 = false;
int cost31 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open31 = true;
        cost31 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open31 = true;
    cost31 = 100 * pos.distanceSquaredTo(target);
}
boolean open32 = false;
int cost32 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + 0);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open32 = true;
        cost32 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open32 = true;
    cost32 = 100 * pos.distanceSquaredTo(target);
}
boolean open33 = false;
int cost33 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open33 = true;
        cost33 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open33 = true;
    cost33 = 100 * pos.distanceSquaredTo(target);
}
boolean open34 = false;
int cost34 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open34 = true;
        cost34 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open34 = true;
    cost34 = 100 * pos.distanceSquaredTo(target);
}
boolean open40 = false;
int cost40 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + -2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open40 = true;
        cost40 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open40 = true;
    cost40 = 100 * pos.distanceSquaredTo(target);
}
boolean open41 = false;
int cost41 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open41 = true;
        cost41 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open41 = true;
    cost41 = 100 * pos.distanceSquaredTo(target);
}
boolean open42 = false;
int cost42 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + 0);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open42 = true;
        cost42 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open42 = true;
    cost42 = 100 * pos.distanceSquaredTo(target);
}
boolean open43 = false;
int cost43 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open43 = true;
        cost43 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open43 = true;
    cost43 = 100 * pos.distanceSquaredTo(target);
}
boolean open44 = false;
int cost44 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open44 = true;
        cost44 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open44 = true;
    cost44 = 100 * pos.distanceSquaredTo(target);
}

    int minCost = 2147483647;
Direction dir = null;
int newcost00 = 2147483647;
int newcost01 = 2147483647;
int newcost02 = 2147483647;
int newcost03 = 2147483647;
int newcost04 = 2147483647;
int newcost10 = 2147483647;
int newcost11 = 2147483647;
int newcost12 = 2147483647;
int newcost13 = 2147483647;
int newcost14 = 2147483647;
int newcost20 = 2147483647;
int newcost21 = 2147483647;
int newcost22 = 2147483647;
int newcost23 = 2147483647;
int newcost24 = 2147483647;
int newcost30 = 2147483647;
int newcost31 = 2147483647;
int newcost32 = 2147483647;
int newcost33 = 2147483647;
int newcost34 = 2147483647;
int newcost40 = 2147483647;
int newcost41 = 2147483647;
int newcost42 = 2147483647;
int newcost43 = 2147483647;
int newcost44 = 2147483647;
if (open00) {
    minCost = cost00;
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
newcost00 = minCost;
}
if (open01) {
    minCost = cost01;
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
newcost01 = minCost;
}
if (open02) {
    minCost = cost02;
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
newcost02 = minCost;
}
if (open03) {
    minCost = cost03;
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
newcost03 = minCost;
}
if (open04) {
    minCost = cost04;
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
newcost04 = minCost;
}
if (open10) {
    minCost = cost10;
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
newcost10 = minCost;
}
if (open11) {
    minCost = cost11;
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
newcost11 = minCost;
}
if (open12) {
    minCost = cost12;
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
newcost12 = minCost;
}
if (open13) {
    minCost = cost13;
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost13 = minCost;
}
if (open14) {
    minCost = cost14;
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost14 = minCost;
}
if (open20) {
    minCost = cost20;
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
newcost20 = minCost;
}
if (open21) {
    minCost = cost21;
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
newcost21 = minCost;
}
if (open22) {
    minCost = cost22;
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
newcost22 = minCost;
}
if (open23) {
    minCost = cost23;
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
newcost23 = minCost;
}
if (open24) {
    minCost = cost24;
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
newcost24 = minCost;
}
if (open30) {
    minCost = cost30;
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
newcost30 = minCost;
}
if (open31) {
    minCost = cost31;
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
newcost31 = minCost;
}
if (open32) {
    minCost = cost32;
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
newcost32 = minCost;
}
if (open33) {
    minCost = cost33;
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
newcost33 = minCost;
}
if (open34) {
    minCost = cost34;
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
newcost34 = minCost;
}
if (open40) {
    minCost = cost40;
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
newcost40 = minCost;
}
if (open41) {
    minCost = cost41;
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
newcost41 = minCost;
}
if (open42) {
    minCost = cost42;
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
newcost42 = minCost;
}
if (open43) {
    minCost = cost43;
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
newcost43 = minCost;
}
if (open44) {
    minCost = cost44;
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
newcost44 = minCost;
}
cost00 = newcost00;
cost01 = newcost01;
cost02 = newcost02;
cost03 = newcost03;
cost04 = newcost04;
cost10 = newcost10;
cost11 = newcost11;
cost12 = newcost12;
cost13 = newcost13;
cost14 = newcost14;
cost20 = newcost20;
cost21 = newcost21;
cost22 = newcost22;
cost23 = newcost23;
cost24 = newcost24;
cost30 = newcost30;
cost31 = newcost31;
cost32 = newcost32;
cost33 = newcost33;
cost34 = newcost34;
cost40 = newcost40;
cost41 = newcost41;
cost42 = newcost42;
cost43 = newcost43;
cost44 = newcost44;
if (open00) {
    minCost = cost00;
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
newcost00 = minCost;
}
if (open01) {
    minCost = cost01;
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
newcost01 = minCost;
}
if (open02) {
    minCost = cost02;
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
newcost02 = minCost;
}
if (open03) {
    minCost = cost03;
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
newcost03 = minCost;
}
if (open04) {
    minCost = cost04;
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
newcost04 = minCost;
}
if (open10) {
    minCost = cost10;
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
newcost10 = minCost;
}
if (open11) {
    minCost = cost11;
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
newcost11 = minCost;
}
if (open12) {
    minCost = cost12;
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
newcost12 = minCost;
}
if (open13) {
    minCost = cost13;
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost13 = minCost;
}
if (open14) {
    minCost = cost14;
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost14 = minCost;
}
if (open20) {
    minCost = cost20;
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
newcost20 = minCost;
}
if (open21) {
    minCost = cost21;
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
newcost21 = minCost;
}
if (open22) {
    minCost = cost22;
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
newcost22 = minCost;
}
if (open23) {
    minCost = cost23;
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
newcost23 = minCost;
}
if (open24) {
    minCost = cost24;
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
newcost24 = minCost;
}
if (open30) {
    minCost = cost30;
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
newcost30 = minCost;
}
if (open31) {
    minCost = cost31;
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
newcost31 = minCost;
}
if (open32) {
    minCost = cost32;
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
newcost32 = minCost;
}
if (open33) {
    minCost = cost33;
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
newcost33 = minCost;
}
if (open34) {
    minCost = cost34;
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
newcost34 = minCost;
}
if (open40) {
    minCost = cost40;
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
newcost40 = minCost;
}
if (open41) {
    minCost = cost41;
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
newcost41 = minCost;
}
if (open42) {
    minCost = cost42;
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
newcost42 = minCost;
}
if (open43) {
    minCost = cost43;
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
newcost43 = minCost;
}
if (open44) {
    minCost = cost44;
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
newcost44 = minCost;
}
cost00 = newcost00;
cost01 = newcost01;
cost02 = newcost02;
cost03 = newcost03;
cost04 = newcost04;
cost10 = newcost10;
cost11 = newcost11;
cost12 = newcost12;
cost13 = newcost13;
cost14 = newcost14;
cost20 = newcost20;
cost21 = newcost21;
cost22 = newcost22;
cost23 = newcost23;
cost24 = newcost24;
cost30 = newcost30;
cost31 = newcost31;
cost32 = newcost32;
cost33 = newcost33;
cost34 = newcost34;
cost40 = newcost40;
cost41 = newcost41;
cost42 = newcost42;
cost43 = newcost43;
cost44 = newcost44;
if (open00) {
    minCost = cost00;
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
newcost00 = minCost;
}
if (open01) {
    minCost = cost01;
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
newcost01 = minCost;
}
if (open02) {
    minCost = cost02;
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
newcost02 = minCost;
}
if (open03) {
    minCost = cost03;
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
newcost03 = minCost;
}
if (open04) {
    minCost = cost04;
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
newcost04 = minCost;
}
if (open10) {
    minCost = cost10;
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
newcost10 = minCost;
}
if (open11) {
    minCost = cost11;
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open00) {
    minCost = Math.min(minCost, cost00 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
newcost11 = minCost;
}
if (open12) {
    minCost = cost12;
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open01) {
    minCost = Math.min(minCost, cost01 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
newcost12 = minCost;
}
if (open13) {
    minCost = cost13;
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open02) {
    minCost = Math.min(minCost, cost02 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost13 = minCost;
}
if (open14) {
    minCost = cost14;
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open03) {
    minCost = Math.min(minCost, cost03 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost14 = minCost;
}
if (open20) {
    minCost = cost20;
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
newcost20 = minCost;
}
if (open21) {
    minCost = cost21;
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open10) {
    minCost = Math.min(minCost, cost10 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
newcost21 = minCost;
}
if (open22) {
    minCost = cost22;
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open11) {
    minCost = Math.min(minCost, cost11 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
newcost22 = minCost;
}
if (open23) {
    minCost = cost23;
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open12) {
    minCost = Math.min(minCost, cost12 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
newcost23 = minCost;
}
if (open24) {
    minCost = cost24;
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open13) {
    minCost = Math.min(minCost, cost13 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
newcost24 = minCost;
}
if (open30) {
    minCost = cost30;
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
newcost30 = minCost;
}
if (open31) {
    minCost = cost31;
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open20) {
    minCost = Math.min(minCost, cost20 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
newcost31 = minCost;
}
if (open32) {
    minCost = cost32;
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open21) {
    minCost = Math.min(minCost, cost21 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
newcost32 = minCost;
}
if (open33) {
    minCost = cost33;
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open22) {
    minCost = Math.min(minCost, cost22 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
newcost33 = minCost;
}
if (open34) {
    minCost = cost34;
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open23) {
    minCost = Math.min(minCost, cost23 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
newcost34 = minCost;
}
if (open40) {
    minCost = cost40;
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
newcost40 = minCost;
}
if (open41) {
    minCost = cost41;
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open30) {
    minCost = Math.min(minCost, cost30 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
newcost41 = minCost;
}
if (open42) {
    minCost = cost42;
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open31) {
    minCost = Math.min(minCost, cost31 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
newcost42 = minCost;
}
if (open43) {
    minCost = cost43;
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open32) {
    minCost = Math.min(minCost, cost32 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
newcost43 = minCost;
}
if (open44) {
    minCost = cost44;
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
newcost44 = minCost;
}
cost00 = newcost00;
cost01 = newcost01;
cost02 = newcost02;
cost03 = newcost03;
cost04 = newcost04;
cost10 = newcost10;
cost11 = newcost11;
cost12 = newcost12;
cost13 = newcost13;
cost14 = newcost14;
cost20 = newcost20;
cost21 = newcost21;
cost22 = newcost22;
cost23 = newcost23;
cost24 = newcost24;
cost30 = newcost30;
cost31 = newcost31;
cost32 = newcost32;
cost33 = newcost33;
cost34 = newcost34;
cost40 = newcost40;
cost41 = newcost41;
cost42 = newcost42;
cost43 = newcost43;
cost44 = newcost44;

    Direction bestDir = Direction.CENTER;
int bestCost = 2147483647;
if (open23) {
    if (cost23 < bestCost) {
        bestCost = cost23;
        bestDir = Direction.NORTH;
    }
}
if (open33) {
    if (cost33 < bestCost) {
        bestCost = cost33;
        bestDir = Direction.NORTHEAST;
    }
}
if (open32) {
    if (cost32 < bestCost) {
        bestCost = cost32;
        bestDir = Direction.EAST;
    }
}
if (open31) {
    if (cost31 < bestCost) {
        bestCost = cost31;
        bestDir = Direction.SOUTHEAST;
    }
}
if (open21) {
    if (cost21 < bestCost) {
        bestCost = cost21;
        bestDir = Direction.SOUTH;
    }
}
if (open11) {
    if (cost11 < bestCost) {
        bestCost = cost11;
        bestDir = Direction.SOUTHWEST;
    }
}
if (open12) {
    if (cost12 < bestCost) {
        bestCost = cost12;
        bestDir = Direction.WEST;
    }
}
if (open13) {
    if (cost13 < bestCost) {
        bestCost = cost13;
        bestDir = Direction.NORTHWEST;
    }
}


    MapLocation next = rc.getLocation().add(bestDir);
    if (rc.canMove(bestDir)) {
        rc.move(bestDir);
    } else if (rc.canFill(next)) {
        rc.fill(next);
        if (rc.canMove(bestDir)) {
            rc.move(bestDir);
        }
    }
    
    return false;
}
}

