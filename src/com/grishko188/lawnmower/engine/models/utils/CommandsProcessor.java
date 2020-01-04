package com.grishko188.lawnmower.engine.models.utils;

import com.grishko188.lawnmower.engine.errors.UnsupportedCommandException;
import com.grishko188.lawnmower.engine.errors.UnsupportedDirectionException;
import com.sun.istack.internal.NotNull;

public class CommandsProcessor {

    public static Direction rotate(@NotNull Direction origin, @NotNull Command command) {
        switch (command) {
            case ROTATE_LEFT:
                return rotateLeft(origin);
            case ROTATE_RIGHT:
                return rotateRight(origin);
            default:
                throw new UnsupportedCommandException(command);
        }
    }

    public static Point move(Point origin, Direction direction) {
        switch (direction) {
            case NORTH:
                return Point.of(origin.getX(), origin.getY() + 1);
            case WEST:
                return Point.of(origin.getX() - 1, origin.getY());
            case SOUTH:
                return Point.of(origin.getX(), origin.getY() - 1);
            case EAST:
                return Point.of(origin.getX() + 1, origin.getY());
            default:
                throw new UnsupportedDirectionException(direction);
        }
    }

    private static Direction rotateLeft(Direction origin) {
        switch (origin) {
            case NORTH:
                return Direction.WEST;
            case WEST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.EAST;
            case EAST:
                return Direction.NORTH;
            default:
                throw new UnsupportedDirectionException(origin);
        }
    }

    private static Direction rotateRight(Direction origin) {
        switch (origin) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            default:
                throw new UnsupportedDirectionException(origin);
        }
    }
}
