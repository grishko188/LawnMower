package com.grishko188.lawnmower.engine.errors;

import com.grishko188.lawnmower.engine.models.utils.Direction;

public class UnsupportedDirectionException extends RuntimeException {

    public UnsupportedDirectionException(Direction direction) {
        super("Direction: {" + direction + "} not supported");
    }
}
