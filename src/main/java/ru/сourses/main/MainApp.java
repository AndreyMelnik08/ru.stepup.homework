package ru.сourses.main;

import ru.сourses.geometry.Line;
import ru.сourses.geometry.Point;

public class MainApp {

    public static void main(String[] args) throws CloneNotSupportedException {

        Line line1 = new Line(new Point(5,6), new Point(8,9));
        Line line2 = line1.clone();
        System.out.println(line1.equals(line2));

    }
}