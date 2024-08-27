package ru.сourses.main;

import ru.stepup.homework.Sauce;
import ru.stepup.homework.Sharpness;
import ru.сourses.geometry.Line;
import ru.сourses.geometry.Point;
import ru.сourses.geometry.PolyLine;

public class MainApp {

    public static void main(String[] args) throws CloneNotSupportedException {

        Sauce sauce = new Sauce("Chili", Sharpness.VERY_SPICY);
        System.out.println(sauce);

    }
}