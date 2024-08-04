package ru.stepup.homework;


public class PolyLine {

    private Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }

    public void getLines() {
        for (int i = 0; i < points.length; i++) {
            System.out.print("Точка " + (i + 1) + ": " + points[i] + ", ");
        }
        System.out.println();
    }

    public double getLength() {
        double length = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Line line = new Line(points[i], points[i + 1]);
            length += line.getLength();
        }
        return length;
    }

}