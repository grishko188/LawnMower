package com.grishko188.lawnmower.engine.models;

import com.grishko188.lawnmower.engine.errors.InvalidDirectionException;
import com.sun.istack.internal.NotNull;

public enum Direction {
    NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

    @NotNull
    private String key;

    Direction(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    public static Direction valueOfKey(String key) {
        for (Direction direction : values()) {
            if (direction.key.equalsIgnoreCase(key))
                return direction;
        }
        throw new InvalidDirectionException(key);
    }
}
