package com.grishko188.lawnmower.engine.models.utils;

public class Point {
    private int x;
    private int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }
}
