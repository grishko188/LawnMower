package com.grishko188.lawnmower.engine.models;

public class Lawn {

    private int width;
    private int height;

    public Lawn(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean inBounds(Point point) {
        return point.getX() >= 0 &&
                point.getX() <= width &&
                point.getY() >= 0 &&
                point.getY() <= height;
    }
}
