package ru.stepup.homework;

public class MainApp {

    public static void main(String[] args) {
        Point p1 = new Point(1, 5);
        Point p2 = new Point(2, 8);
        Point p3 = new Point(5, 3);
        Point p4 = new Point(8, 9);
        PolyLine polyLine = new PolyLine(p1, p2, p3, p4);
        Line line1 = new Line(p1, p2);
        Line line2 = new Line(p2, p3);
        Line line3 = new Line(p3, p4);

        linesInfo(polyLine, line1, line2, line3);
        p2.setX(12);
        p2.setY(8);
        linesInfo(polyLine, line1, line2, line3);

    }

    static void linesInfo(PolyLine polyLine, Line line1, Line line2, Line line3) {
        polyLine.getLines();
        System.out.println("Длинна ломанной линии: " + polyLine.getLength());
        double length = line1.getLength() + line2.getLength() + line3.getLength();
        System.out.println("Длинна массива линий: " + length);
        System.out.println(polyLine.getLength() == length);
    }

}
