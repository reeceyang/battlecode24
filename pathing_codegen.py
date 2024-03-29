# variable names
COST = 'cost'
OPEN = 'open'

SIZE = 7  # size of the grid
DMIN = -3
DMAX = 3
HOME = 3  # center of the grid

MAX_V = 2147483647

DIRS = ["Direction.NORTH",
        "Direction.NORTHEAST",
        "Direction.EAST",
        "Direction.SOUTHEAST",
        "Direction.SOUTH",
        "Direction.SOUTHWEST",
        "Direction.WEST",
        "Direction.NORTHWEST",
        ]

DIR_TO_D = {"Direction.NORTH": (0, 1),
            "Direction.NORTHEAST": (1, 1),
            "Direction.EAST": (1, 0),
            "Direction.SOUTHEAST": (1, -1),
            "Direction.SOUTH": (0, -1),
            "Direction.SOUTHWEST": (-1, -1),
            "Direction.WEST": (-1, 0),
            "Direction.NORTHWEST": (-1, 1),
            }

OPPOSITE = {
    "Direction.NORTH": "Direction.SOUTH",
    "Direction.NORTHEAST": "Direction.SOUTHWEST",
    "Direction.EAST": "Direction.WEST",
    "Direction.SOUTHEAST": "Direction.NORTHWEST",
    "Direction.SOUTH": "Direction.NORTH",
    "Direction.SOUTHWEST": "Direction.NORTHEAST",
    "Direction.WEST": "Direction.EAST",
    "Direction.NORTHWEST": "Direction.SOUTHEAST",
}

NUM_DIR = len(DIRS)


def def_vars():
    s = """MapLocation bot = rc.getLocation();
MapLocation pos;
Direction currentDir;
int wellCost;
"""
    for dx in range(DMIN, DMAX + 1):
        for dy in range(DMIN, DMAX + 1):
            array_x = HOME + dx
            array_y = HOME + dy
            s += f"""boolean {OPEN}{array_x}{array_y} = false;
int {COST}{array_x}{array_y} = {MAX_V};
pos = new MapLocation(bot.x + {dx}, bot.y + {dy});
"""
            # pre-compute whether pos is the bot's current location
            if dx == 0 and dy == 0:
                s += f"""{OPEN}{array_x}{array_y} = true;
{COST}{array_x}{array_y} = 100 * (pos.distanceSquaredTo(target));
"""
            else:
                s += f"""if (rc.canSenseLocation(pos)) {{
    if ((rc.sensePassability(pos) || rc.senseMapInfo(pos).isWater()) && !rc.isLocationOccupied(pos)) {{
        {OPEN}{array_x}{array_y} = true;
        {COST}{array_x}{array_y} = 100 * (pos.distanceSquaredTo(target));
    }}
}} else if (rc.onTheMap(pos)) {{
    {OPEN}{array_x}{array_y} = true;
    {COST}{array_x}{array_y} = 100 * pos.distanceSquaredTo(target);
}}
"""
    return s


def relax_graph(iterations):
    # reuse these variables
    s = f'int minCost = {MAX_V};\nDirection dir = null;\n'
    for x in range(SIZE):
        for y in range(SIZE):
            s += f'int new{COST}{x}{y} = {MAX_V};\n'
    for _ in range(iterations):
        for x in range(SIZE):
            for y in range(SIZE):
                s += f"""if ({OPEN}{x}{y}) {{
    minCost = {COST}{x}{y};
"""
                for dir in DIRS:
                    dx, dy = DIR_TO_D[dir]
                    neigh_x = x + dx
                    neigh_y = y + dy
                    if 0 <= neigh_x < SIZE and 0 <= neigh_y < SIZE:
                        # don't go into an inaccessible square
                        s += f"""if ({OPEN}{neigh_x}{neigh_y}) {{
    minCost = Math.min(minCost, {COST}{neigh_x}{neigh_y} + 1);
}}
"""
                s += f'new{COST}{x}{y} = minCost;\n}}\n'

        # swap the costs with the new costs at the end of the iteration
        for x in range(SIZE):
            for y in range(SIZE):
                s += f'{COST}{x}{y} = new{COST}{x}{y};\n'
        # don't need to swap costs the last iteration - just use new costs for calculating best direction
        # if _ != iterations - 1:
        #     for x in range(SIZE):
        #         for y in range(SIZE):
        #             s += f'{COST}{x}{y} = new{COST}{x}{y};\n'
    return s


def choose_best_dir():
    s = f"""Direction bestDir = Direction.CENTER;
int bestCost = {MAX_V};
"""
    for dir in DIRS:
        dx, dy = DIR_TO_D[dir]
        neigh_x = HOME + dx
        neigh_y = HOME + dy
        s += f"""if ({OPEN}{neigh_x}{neigh_y}) {{
    if ({COST}{neigh_x}{neigh_y} < bestCost) {{
        bestCost = {COST}{neigh_x}{neigh_y};
        bestDir = {dir};
    }}
}}
"""
    return s


def make_method(package):
    return f"""package {package};

import battlecode.common.*;

public class BellmanFord {{
public static boolean doBellmanFord(RobotController rc, MapLocation target) throws GameActionException {{
    {def_vars()}
    {relax_graph(3)}
    {choose_best_dir()}

    MapLocation next = rc.getLocation().add(bestDir);
    if (rc.canMove(bestDir)) {{
        rc.move(bestDir);
        return true;
    }} else if (rc.canFill(next)) {{
        rc.fill(next);
        if (rc.canMove(bestDir)) {{
            rc.move(bestDir);
            return true;
        }}
    }}
    
    return false;
}}
}}
"""


print(make_method('v4'))
