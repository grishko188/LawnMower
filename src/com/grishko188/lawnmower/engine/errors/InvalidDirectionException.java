package com.grishko188.lawnmower.engine.errors;

public class InvalidDirectionException extends RuntimeException {

    public InvalidDirectionException(String value) {
        super("Invalid Direction string value: {" + value + "}");
    }
}
