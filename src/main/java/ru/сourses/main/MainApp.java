package ru.сourses.main;

import ru.сourses.geometry.Line;
import ru.сourses.geometry.Point;
import ru.сourses.geometry.PolyLine;

public class MainApp {

    public static void main(String[] args) throws CloneNotSupportedException {

        Point point1 = new Point(1,2);
        Point point2 = new Point(4,4);
        Point point3 = new Point(10,5);
        Point point4 = new Point(1,2);
        Point point5 = new Point(4,4);
        Point point6 = new Point(10,5);

        PolyLine polyLine1 = new PolyLine(point1, point2, point3);
        PolyLine polyLine2 = new PolyLine(point4, point5, point6);
        System.out.println(polyLine1.equals(polyLine2));

    }
}