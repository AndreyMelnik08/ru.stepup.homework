package ru.stepup.homework;

public class MainApp {

    public static void main(String[] args) {

        Line line1 = new Line(new Point(1, 3), new Point(5, 8));
        Line line2 = new Line(new Point(10, 11), new Point(15, 19));
        Line line3 = new Line(line1.end, line2.start);
        System.out.println(line3);
        line3.start = new Point(2, 4);
        line3.end = new Point(6, 9);
        System.out.println(line3);
        double totalLength = line1.getLength() + line2.getLength() + line3.getLength();
        System.out.println("Суммарная длина всех линий: " + totalLength);
    }

}
