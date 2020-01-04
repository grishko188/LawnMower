package com.grishko188.lawnmower.engine.models;

import com.sun.istack.internal.NotNull;

public class Mower {
    @NotNull
    private Point position;
    @NotNull
    private Direction direction;

    public Mower(@NotNull Point initialPosition, @NotNull Direction initialDirection) {
        this.position = initialPosition;
        this.direction = initialDirection;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Point getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getState() {
        return position.toString() + " " + direction.toString();
    }
}
