package ru.stepup.homework;

public class Point {

    private int x;
    int y;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{X:" + x + "; Y:" + y + "}";
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
