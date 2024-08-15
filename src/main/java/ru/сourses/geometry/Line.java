package ru.сourses.geometry;

import java.util.Objects;

public class Line implements Measurable {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return "Точка начала линии: " + start + ". Точка окончания: " + end;
    }

    @Override
    public double getLength() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Point clonedStart = new Point(this.start.getX(), this.start.getY());
        Point clonedEnd = new Point(this.end.getX(), this.end.getY());
        return new Line(clonedStart, clonedEnd);
    }
}
