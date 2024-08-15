package ru.сourses.main;

import ru.сourses.geometry.Point;

public class MainApp {

    public static void main(String[] args) throws CloneNotSupportedException {

        Point point1 = new Point(3, 4);
        Point point2 = point1.clone();
        System.out.println(point1.equals(point2));

    }
}