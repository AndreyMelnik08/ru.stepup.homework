package ru.stepup.homework;

public class Sauce {
    private String name;
    private Sharpness sharpness;


    public Sauce(String name, Sharpness sharpness) {
        this.name = name;
        this.sharpness = sharpness;
    }

    public String getName() {
        return name;
    }

    public Sharpness getSharpness() {
        return sharpness;
    }

    @Override
    public String toString() {
        return "Соус " + name + ": " + sharpness;
    }
}
