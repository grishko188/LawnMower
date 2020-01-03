package com.grishko188.lawnmower.engine.models.utils;

public class CommandsProcessor {

    public static Direction rotate(Direction origin, Command command) {
        switch (command) {
            case ROTATE_LEFT:
                return rotateLeft(origin);
            case ROTATE_RIGHT:
                return rotateRight(origin);
            default:
                throw new IllegalArgumentException("Unknown command for rotation: " + command);
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
                throw new IllegalArgumentException("Unknown direction: " + origin);
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
                throw new IllegalArgumentException("Unknown direction: " + origin);
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
                throw new IllegalArgumentException("Unknown direction: " + origin);
        }
    }
}
