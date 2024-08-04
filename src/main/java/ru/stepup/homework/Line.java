package ru.stepup.homework;

public class Line {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "Точка начала линии: " + start + ". Точка окончания: " + end;
    }

    public double getLength() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}
