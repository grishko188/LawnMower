package com.grishko188.lawnmower.engine.models;

import com.grishko188.lawnmower.engine.errors.InvalidCommandException;
import com.sun.istack.internal.NotNull;

public enum Command {
    FORWARD("F"), ROTATE_RIGHT("R"), ROTATE_LEFT("L");

    @NotNull
    private String key;

    Command(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    public static Command valueOfKey(String key) {
        for (Command command : values()) {
            if (command.key.equalsIgnoreCase(key))
                return command;
        }
        throw new InvalidCommandException(key);
    }
}