package ru.stepup.homework;

public class Square {
    private int x;
    private int y;
    private int sideLength;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSideLength(int sideLength) throws IllegalArgumentException {
        if (sideLength < 0) {
            throw new IllegalArgumentException("Сторона не может быть отрицательным числом");
        }
        this.sideLength = sideLength;
    }

    public Square(int x, int y, int sideLength) throws IllegalArgumentException {
        if (sideLength < 0) {
            throw new IllegalArgumentException("Сторона не может быть отрицательным числом");
        }
        this.x = x;
        this.y = y;
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат в точке (" + x + ", " + y + ") со стороной: " + sideLength;
    }
}