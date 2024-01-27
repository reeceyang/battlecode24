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
pos = new MapLocation(bot.x + -3, bot.y + -3);
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
pos = new MapLocation(bot.x + -3, bot.y + -2);
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
pos = new MapLocation(bot.x + -3, bot.y + -1);
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
pos = new MapLocation(bot.x + -3, bot.y + 0);
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
pos = new MapLocation(bot.x + -3, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open04 = true;
        cost04 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open04 = true;
    cost04 = 100 * pos.distanceSquaredTo(target);
}
boolean open05 = false;
int cost05 = 2147483647;
pos = new MapLocation(bot.x + -3, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open05 = true;
        cost05 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open05 = true;
    cost05 = 100 * pos.distanceSquaredTo(target);
}
boolean open06 = false;
int cost06 = 2147483647;
pos = new MapLocation(bot.x + -3, bot.y + 3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open06 = true;
        cost06 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open06 = true;
    cost06 = 100 * pos.distanceSquaredTo(target);
}
boolean open10 = false;
int cost10 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + -3);
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
pos = new MapLocation(bot.x + -2, bot.y + -2);
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
pos = new MapLocation(bot.x + -2, bot.y + -1);
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
pos = new MapLocation(bot.x + -2, bot.y + 0);
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
pos = new MapLocation(bot.x + -2, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open14 = true;
        cost14 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open14 = true;
    cost14 = 100 * pos.distanceSquaredTo(target);
}
boolean open15 = false;
int cost15 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open15 = true;
        cost15 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open15 = true;
    cost15 = 100 * pos.distanceSquaredTo(target);
}
boolean open16 = false;
int cost16 = 2147483647;
pos = new MapLocation(bot.x + -2, bot.y + 3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open16 = true;
        cost16 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open16 = true;
    cost16 = 100 * pos.distanceSquaredTo(target);
}
boolean open20 = false;
int cost20 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + -3);
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
pos = new MapLocation(bot.x + -1, bot.y + -2);
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
pos = new MapLocation(bot.x + -1, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open22 = true;
        cost22 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open22 = true;
    cost22 = 100 * pos.distanceSquaredTo(target);
}
boolean open23 = false;
int cost23 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + 0);
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
pos = new MapLocation(bot.x + -1, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open24 = true;
        cost24 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open24 = true;
    cost24 = 100 * pos.distanceSquaredTo(target);
}
boolean open25 = false;
int cost25 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open25 = true;
        cost25 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open25 = true;
    cost25 = 100 * pos.distanceSquaredTo(target);
}
boolean open26 = false;
int cost26 = 2147483647;
pos = new MapLocation(bot.x + -1, bot.y + 3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open26 = true;
        cost26 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open26 = true;
    cost26 = 100 * pos.distanceSquaredTo(target);
}
boolean open30 = false;
int cost30 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + -3);
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
pos = new MapLocation(bot.x + 0, bot.y + -2);
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
pos = new MapLocation(bot.x + 0, bot.y + -1);
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
pos = new MapLocation(bot.x + 0, bot.y + 0);
open33 = true;
cost33 = 100 * (pos.distanceSquaredTo(target));
boolean open34 = false;
int cost34 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open34 = true;
        cost34 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open34 = true;
    cost34 = 100 * pos.distanceSquaredTo(target);
}
boolean open35 = false;
int cost35 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open35 = true;
        cost35 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open35 = true;
    cost35 = 100 * pos.distanceSquaredTo(target);
}
boolean open36 = false;
int cost36 = 2147483647;
pos = new MapLocation(bot.x + 0, bot.y + 3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open36 = true;
        cost36 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open36 = true;
    cost36 = 100 * pos.distanceSquaredTo(target);
}
boolean open40 = false;
int cost40 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + -3);
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
pos = new MapLocation(bot.x + 1, bot.y + -2);
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
pos = new MapLocation(bot.x + 1, bot.y + -1);
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
pos = new MapLocation(bot.x + 1, bot.y + 0);
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
pos = new MapLocation(bot.x + 1, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open44 = true;
        cost44 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open44 = true;
    cost44 = 100 * pos.distanceSquaredTo(target);
}
boolean open45 = false;
int cost45 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open45 = true;
        cost45 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open45 = true;
    cost45 = 100 * pos.distanceSquaredTo(target);
}
boolean open46 = false;
int cost46 = 2147483647;
pos = new MapLocation(bot.x + 1, bot.y + 3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open46 = true;
        cost46 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open46 = true;
    cost46 = 100 * pos.distanceSquaredTo(target);
}
boolean open50 = false;
int cost50 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + -3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open50 = true;
        cost50 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open50 = true;
    cost50 = 100 * pos.distanceSquaredTo(target);
}
boolean open51 = false;
int cost51 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + -2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open51 = true;
        cost51 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open51 = true;
    cost51 = 100 * pos.distanceSquaredTo(target);
}
boolean open52 = false;
int cost52 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open52 = true;
        cost52 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open52 = true;
    cost52 = 100 * pos.distanceSquaredTo(target);
}
boolean open53 = false;
int cost53 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + 0);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open53 = true;
        cost53 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open53 = true;
    cost53 = 100 * pos.distanceSquaredTo(target);
}
boolean open54 = false;
int cost54 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open54 = true;
        cost54 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open54 = true;
    cost54 = 100 * pos.distanceSquaredTo(target);
}
boolean open55 = false;
int cost55 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open55 = true;
        cost55 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open55 = true;
    cost55 = 100 * pos.distanceSquaredTo(target);
}
boolean open56 = false;
int cost56 = 2147483647;
pos = new MapLocation(bot.x + 2, bot.y + 3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open56 = true;
        cost56 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open56 = true;
    cost56 = 100 * pos.distanceSquaredTo(target);
}
boolean open60 = false;
int cost60 = 2147483647;
pos = new MapLocation(bot.x + 3, bot.y + -3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open60 = true;
        cost60 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open60 = true;
    cost60 = 100 * pos.distanceSquaredTo(target);
}
boolean open61 = false;
int cost61 = 2147483647;
pos = new MapLocation(bot.x + 3, bot.y + -2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open61 = true;
        cost61 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open61 = true;
    cost61 = 100 * pos.distanceSquaredTo(target);
}
boolean open62 = false;
int cost62 = 2147483647;
pos = new MapLocation(bot.x + 3, bot.y + -1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open62 = true;
        cost62 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open62 = true;
    cost62 = 100 * pos.distanceSquaredTo(target);
}
boolean open63 = false;
int cost63 = 2147483647;
pos = new MapLocation(bot.x + 3, bot.y + 0);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open63 = true;
        cost63 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open63 = true;
    cost63 = 100 * pos.distanceSquaredTo(target);
}
boolean open64 = false;
int cost64 = 2147483647;
pos = new MapLocation(bot.x + 3, bot.y + 1);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open64 = true;
        cost64 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open64 = true;
    cost64 = 100 * pos.distanceSquaredTo(target);
}
boolean open65 = false;
int cost65 = 2147483647;
pos = new MapLocation(bot.x + 3, bot.y + 2);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open65 = true;
        cost65 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open65 = true;
    cost65 = 100 * pos.distanceSquaredTo(target);
}
boolean open66 = false;
int cost66 = 2147483647;
pos = new MapLocation(bot.x + 3, bot.y + 3);
if (rc.canSenseLocation(pos)) {
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {
        open66 = true;
        cost66 = 100 * (pos.distanceSquaredTo(target));
    }
} else if (rc.onTheMap(pos)) {
    open66 = true;
    cost66 = 100 * pos.distanceSquaredTo(target);
}

    int minCost = 2147483647;
Direction dir = null;
int newcost00 = 2147483647;
int newcost01 = 2147483647;
int newcost02 = 2147483647;
int newcost03 = 2147483647;
int newcost04 = 2147483647;
int newcost05 = 2147483647;
int newcost06 = 2147483647;
int newcost10 = 2147483647;
int newcost11 = 2147483647;
int newcost12 = 2147483647;
int newcost13 = 2147483647;
int newcost14 = 2147483647;
int newcost15 = 2147483647;
int newcost16 = 2147483647;
int newcost20 = 2147483647;
int newcost21 = 2147483647;
int newcost22 = 2147483647;
int newcost23 = 2147483647;
int newcost24 = 2147483647;
int newcost25 = 2147483647;
int newcost26 = 2147483647;
int newcost30 = 2147483647;
int newcost31 = 2147483647;
int newcost32 = 2147483647;
int newcost33 = 2147483647;
int newcost34 = 2147483647;
int newcost35 = 2147483647;
int newcost36 = 2147483647;
int newcost40 = 2147483647;
int newcost41 = 2147483647;
int newcost42 = 2147483647;
int newcost43 = 2147483647;
int newcost44 = 2147483647;
int newcost45 = 2147483647;
int newcost46 = 2147483647;
int newcost50 = 2147483647;
int newcost51 = 2147483647;
int newcost52 = 2147483647;
int newcost53 = 2147483647;
int newcost54 = 2147483647;
int newcost55 = 2147483647;
int newcost56 = 2147483647;
int newcost60 = 2147483647;
int newcost61 = 2147483647;
int newcost62 = 2147483647;
int newcost63 = 2147483647;
int newcost64 = 2147483647;
int newcost65 = 2147483647;
int newcost66 = 2147483647;
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
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
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
if (open05) {
    minCost = cost05;
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost05 = minCost;
}
if (open06) {
    minCost = cost06;
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
newcost06 = minCost;
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
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
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
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
newcost14 = minCost;
}
if (open15) {
    minCost = cost15;
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
newcost15 = minCost;
}
if (open16) {
    minCost = cost16;
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
newcost16 = minCost;
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
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
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
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
newcost24 = minCost;
}
if (open25) {
    minCost = cost25;
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
newcost25 = minCost;
}
if (open26) {
    minCost = cost26;
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
newcost26 = minCost;
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
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
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
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
newcost34 = minCost;
}
if (open35) {
    minCost = cost35;
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
newcost35 = minCost;
}
if (open36) {
    minCost = cost36;
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
newcost36 = minCost;
}
if (open40) {
    minCost = cost40;
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
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
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
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
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
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
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
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
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
newcost44 = minCost;
}
if (open45) {
    minCost = cost45;
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
newcost45 = minCost;
}
if (open46) {
    minCost = cost46;
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
newcost46 = minCost;
}
if (open50) {
    minCost = cost50;
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
newcost50 = minCost;
}
if (open51) {
    minCost = cost51;
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
newcost51 = minCost;
}
if (open52) {
    minCost = cost52;
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
newcost52 = minCost;
}
if (open53) {
    minCost = cost53;
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
newcost53 = minCost;
}
if (open54) {
    minCost = cost54;
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
newcost54 = minCost;
}
if (open55) {
    minCost = cost55;
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
newcost55 = minCost;
}
if (open56) {
    minCost = cost56;
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
newcost56 = minCost;
}
if (open60) {
    minCost = cost60;
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
newcost60 = minCost;
}
if (open61) {
    minCost = cost61;
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
newcost61 = minCost;
}
if (open62) {
    minCost = cost62;
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
newcost62 = minCost;
}
if (open63) {
    minCost = cost63;
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
newcost63 = minCost;
}
if (open64) {
    minCost = cost64;
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
newcost64 = minCost;
}
if (open65) {
    minCost = cost65;
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
newcost65 = minCost;
}
if (open66) {
    minCost = cost66;
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
newcost66 = minCost;
}
cost00 = newcost00;
cost01 = newcost01;
cost02 = newcost02;
cost03 = newcost03;
cost04 = newcost04;
cost05 = newcost05;
cost06 = newcost06;
cost10 = newcost10;
cost11 = newcost11;
cost12 = newcost12;
cost13 = newcost13;
cost14 = newcost14;
cost15 = newcost15;
cost16 = newcost16;
cost20 = newcost20;
cost21 = newcost21;
cost22 = newcost22;
cost23 = newcost23;
cost24 = newcost24;
cost25 = newcost25;
cost26 = newcost26;
cost30 = newcost30;
cost31 = newcost31;
cost32 = newcost32;
cost33 = newcost33;
cost34 = newcost34;
cost35 = newcost35;
cost36 = newcost36;
cost40 = newcost40;
cost41 = newcost41;
cost42 = newcost42;
cost43 = newcost43;
cost44 = newcost44;
cost45 = newcost45;
cost46 = newcost46;
cost50 = newcost50;
cost51 = newcost51;
cost52 = newcost52;
cost53 = newcost53;
cost54 = newcost54;
cost55 = newcost55;
cost56 = newcost56;
cost60 = newcost60;
cost61 = newcost61;
cost62 = newcost62;
cost63 = newcost63;
cost64 = newcost64;
cost65 = newcost65;
cost66 = newcost66;
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
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
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
if (open05) {
    minCost = cost05;
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost05 = minCost;
}
if (open06) {
    minCost = cost06;
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
newcost06 = minCost;
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
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
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
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
newcost14 = minCost;
}
if (open15) {
    minCost = cost15;
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
newcost15 = minCost;
}
if (open16) {
    minCost = cost16;
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
newcost16 = minCost;
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
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
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
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
newcost24 = minCost;
}
if (open25) {
    minCost = cost25;
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
newcost25 = minCost;
}
if (open26) {
    minCost = cost26;
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
newcost26 = minCost;
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
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
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
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
newcost34 = minCost;
}
if (open35) {
    minCost = cost35;
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
newcost35 = minCost;
}
if (open36) {
    minCost = cost36;
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
newcost36 = minCost;
}
if (open40) {
    minCost = cost40;
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
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
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
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
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
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
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
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
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
newcost44 = minCost;
}
if (open45) {
    minCost = cost45;
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
newcost45 = minCost;
}
if (open46) {
    minCost = cost46;
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
newcost46 = minCost;
}
if (open50) {
    minCost = cost50;
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
newcost50 = minCost;
}
if (open51) {
    minCost = cost51;
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
newcost51 = minCost;
}
if (open52) {
    minCost = cost52;
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
newcost52 = minCost;
}
if (open53) {
    minCost = cost53;
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
newcost53 = minCost;
}
if (open54) {
    minCost = cost54;
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
newcost54 = minCost;
}
if (open55) {
    minCost = cost55;
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
newcost55 = minCost;
}
if (open56) {
    minCost = cost56;
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
newcost56 = minCost;
}
if (open60) {
    minCost = cost60;
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
newcost60 = minCost;
}
if (open61) {
    minCost = cost61;
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
newcost61 = minCost;
}
if (open62) {
    minCost = cost62;
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
newcost62 = minCost;
}
if (open63) {
    minCost = cost63;
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
newcost63 = minCost;
}
if (open64) {
    minCost = cost64;
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
newcost64 = minCost;
}
if (open65) {
    minCost = cost65;
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
newcost65 = minCost;
}
if (open66) {
    minCost = cost66;
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
newcost66 = minCost;
}
cost00 = newcost00;
cost01 = newcost01;
cost02 = newcost02;
cost03 = newcost03;
cost04 = newcost04;
cost05 = newcost05;
cost06 = newcost06;
cost10 = newcost10;
cost11 = newcost11;
cost12 = newcost12;
cost13 = newcost13;
cost14 = newcost14;
cost15 = newcost15;
cost16 = newcost16;
cost20 = newcost20;
cost21 = newcost21;
cost22 = newcost22;
cost23 = newcost23;
cost24 = newcost24;
cost25 = newcost25;
cost26 = newcost26;
cost30 = newcost30;
cost31 = newcost31;
cost32 = newcost32;
cost33 = newcost33;
cost34 = newcost34;
cost35 = newcost35;
cost36 = newcost36;
cost40 = newcost40;
cost41 = newcost41;
cost42 = newcost42;
cost43 = newcost43;
cost44 = newcost44;
cost45 = newcost45;
cost46 = newcost46;
cost50 = newcost50;
cost51 = newcost51;
cost52 = newcost52;
cost53 = newcost53;
cost54 = newcost54;
cost55 = newcost55;
cost56 = newcost56;
cost60 = newcost60;
cost61 = newcost61;
cost62 = newcost62;
cost63 = newcost63;
cost64 = newcost64;
cost65 = newcost65;
cost66 = newcost66;
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
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
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
if (open05) {
    minCost = cost05;
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
newcost05 = minCost;
}
if (open06) {
    minCost = cost06;
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
newcost06 = minCost;
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
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
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
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
newcost14 = minCost;
}
if (open15) {
    minCost = cost15;
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open04) {
    minCost = Math.min(minCost, cost04 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
newcost15 = minCost;
}
if (open16) {
    minCost = cost16;
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open05) {
    minCost = Math.min(minCost, cost05 + 1);
}
if (open06) {
    minCost = Math.min(minCost, cost06 + 1);
}
newcost16 = minCost;
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
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
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
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
newcost24 = minCost;
}
if (open25) {
    minCost = cost25;
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open14) {
    minCost = Math.min(minCost, cost14 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
newcost25 = minCost;
}
if (open26) {
    minCost = cost26;
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open15) {
    minCost = Math.min(minCost, cost15 + 1);
}
if (open16) {
    minCost = Math.min(minCost, cost16 + 1);
}
newcost26 = minCost;
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
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
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
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
newcost34 = minCost;
}
if (open35) {
    minCost = cost35;
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open24) {
    minCost = Math.min(minCost, cost24 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
newcost35 = minCost;
}
if (open36) {
    minCost = cost36;
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open25) {
    minCost = Math.min(minCost, cost25 + 1);
}
if (open26) {
    minCost = Math.min(minCost, cost26 + 1);
}
newcost36 = minCost;
}
if (open40) {
    minCost = cost40;
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
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
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
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
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
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
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
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
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open33) {
    minCost = Math.min(minCost, cost33 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
newcost44 = minCost;
}
if (open45) {
    minCost = cost45;
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open34) {
    minCost = Math.min(minCost, cost34 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
newcost45 = minCost;
}
if (open46) {
    minCost = cost46;
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open35) {
    minCost = Math.min(minCost, cost35 + 1);
}
if (open36) {
    minCost = Math.min(minCost, cost36 + 1);
}
newcost46 = minCost;
}
if (open50) {
    minCost = cost50;
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
newcost50 = minCost;
}
if (open51) {
    minCost = cost51;
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open40) {
    minCost = Math.min(minCost, cost40 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
newcost51 = minCost;
}
if (open52) {
    minCost = cost52;
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open41) {
    minCost = Math.min(minCost, cost41 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
newcost52 = minCost;
}
if (open53) {
    minCost = cost53;
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open42) {
    minCost = Math.min(minCost, cost42 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
newcost53 = minCost;
}
if (open54) {
    minCost = cost54;
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open43) {
    minCost = Math.min(minCost, cost43 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
newcost54 = minCost;
}
if (open55) {
    minCost = cost55;
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open44) {
    minCost = Math.min(minCost, cost44 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
newcost55 = minCost;
}
if (open56) {
    minCost = cost56;
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open45) {
    minCost = Math.min(minCost, cost45 + 1);
}
if (open46) {
    minCost = Math.min(minCost, cost46 + 1);
}
newcost56 = minCost;
}
if (open60) {
    minCost = cost60;
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
newcost60 = minCost;
}
if (open61) {
    minCost = cost61;
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open60) {
    minCost = Math.min(minCost, cost60 + 1);
}
if (open50) {
    minCost = Math.min(minCost, cost50 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
newcost61 = minCost;
}
if (open62) {
    minCost = cost62;
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open61) {
    minCost = Math.min(minCost, cost61 + 1);
}
if (open51) {
    minCost = Math.min(minCost, cost51 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
newcost62 = minCost;
}
if (open63) {
    minCost = cost63;
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open62) {
    minCost = Math.min(minCost, cost62 + 1);
}
if (open52) {
    minCost = Math.min(minCost, cost52 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
newcost63 = minCost;
}
if (open64) {
    minCost = cost64;
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open63) {
    minCost = Math.min(minCost, cost63 + 1);
}
if (open53) {
    minCost = Math.min(minCost, cost53 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
newcost64 = minCost;
}
if (open65) {
    minCost = cost65;
if (open66) {
    minCost = Math.min(minCost, cost66 + 1);
}
if (open64) {
    minCost = Math.min(minCost, cost64 + 1);
}
if (open54) {
    minCost = Math.min(minCost, cost54 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
newcost65 = minCost;
}
if (open66) {
    minCost = cost66;
if (open65) {
    minCost = Math.min(minCost, cost65 + 1);
}
if (open55) {
    minCost = Math.min(minCost, cost55 + 1);
}
if (open56) {
    minCost = Math.min(minCost, cost56 + 1);
}
newcost66 = minCost;
}
cost00 = newcost00;
cost01 = newcost01;
cost02 = newcost02;
cost03 = newcost03;
cost04 = newcost04;
cost05 = newcost05;
cost06 = newcost06;
cost10 = newcost10;
cost11 = newcost11;
cost12 = newcost12;
cost13 = newcost13;
cost14 = newcost14;
cost15 = newcost15;
cost16 = newcost16;
cost20 = newcost20;
cost21 = newcost21;
cost22 = newcost22;
cost23 = newcost23;
cost24 = newcost24;
cost25 = newcost25;
cost26 = newcost26;
cost30 = newcost30;
cost31 = newcost31;
cost32 = newcost32;
cost33 = newcost33;
cost34 = newcost34;
cost35 = newcost35;
cost36 = newcost36;
cost40 = newcost40;
cost41 = newcost41;
cost42 = newcost42;
cost43 = newcost43;
cost44 = newcost44;
cost45 = newcost45;
cost46 = newcost46;
cost50 = newcost50;
cost51 = newcost51;
cost52 = newcost52;
cost53 = newcost53;
cost54 = newcost54;
cost55 = newcost55;
cost56 = newcost56;
cost60 = newcost60;
cost61 = newcost61;
cost62 = newcost62;
cost63 = newcost63;
cost64 = newcost64;
cost65 = newcost65;
cost66 = newcost66;

    Direction bestDir = Direction.CENTER;
int bestCost = 2147483647;
if (open34) {
    if (cost34 < bestCost) {
        bestCost = cost34;
        bestDir = Direction.NORTH;
    }
}
if (open44) {
    if (cost44 < bestCost) {
        bestCost = cost44;
        bestDir = Direction.NORTHEAST;
    }
}
if (open43) {
    if (cost43 < bestCost) {
        bestCost = cost43;
        bestDir = Direction.EAST;
    }
}
if (open42) {
    if (cost42 < bestCost) {
        bestCost = cost42;
        bestDir = Direction.SOUTHEAST;
    }
}
if (open32) {
    if (cost32 < bestCost) {
        bestCost = cost32;
        bestDir = Direction.SOUTH;
    }
}
if (open22) {
    if (cost22 < bestCost) {
        bestCost = cost22;
        bestDir = Direction.SOUTHWEST;
    }
}
if (open23) {
    if (cost23 < bestCost) {
        bestCost = cost23;
        bestDir = Direction.WEST;
    }
}
if (open24) {
    if (cost24 < bestCost) {
        bestCost = cost24;
        bestDir = Direction.NORTHWEST;
    }
}


    MapLocation next = rc.getLocation().add(bestDir);
    if (rc.canMove(bestDir)) {
        rc.move(bestDir);
        return true;
    } else if (rc.canFill(next)) {
        rc.fill(next);
        if (rc.canMove(bestDir)) {
            rc.move(bestDir);
            return true;
        }
    }
    
    return false;
}
}

