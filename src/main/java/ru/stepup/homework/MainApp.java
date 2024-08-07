package ru.stepup.homework;

public class MainApp {

    public static void main(String[] args) {

        Measurable polyline = new PolyLine(new Point(5, 5), new Point(0, 10), new Point(15, 15));
        Measurable closedPolyline = new ClosedPolyLine(new Point(3, 3), new Point(7, 1), new Point(2, 2));

        System.out.println("Длина обычной ломаной линии: " + polyline.getLength());
        System.out.println("Длина Замкнутой ломаной линии: " + closedPolyline.getLength());

    }
}