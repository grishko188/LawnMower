package com.grishko188.lawnmower.engine.errors;

public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String value) {
        super("Invalid Command string value: {" + value + "}");
    }
}
