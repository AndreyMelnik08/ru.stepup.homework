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
        int dx = end.x - start.x;
        int dy = end.y - start.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}