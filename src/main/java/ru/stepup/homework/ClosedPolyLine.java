package ru.stepup.homework;

public class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(Point... points) {
        super(points);
    }

    @Override
    public double getLength() {
        double length = super.getLength();
        Line line = new Line(getPoints()[getPoints().length - 1], getPoints()[0]);
        length += line.getLength();
        return length;
    }
}
