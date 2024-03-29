package com.grishko188.lawnmower.engine.errors;

import com.grishko188.lawnmower.engine.models.Command;

public class UnsupportedCommandException extends RuntimeException {

    public UnsupportedCommandException(Command command) {
        super("Command: {" + command + "} not supported");
    }
}
