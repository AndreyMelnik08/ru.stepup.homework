package ru.сourses.main;

import ru.stepup.homework.Cat;
import ru.stepup.homework.Dog;

import java.lang.reflect.Field;
import java.util.*;

public class MainApp {

    public static void main(String[] args) throws IllegalAccessException {
        Cat cat;
        Dog dog;
        cat = new Cat("Pushok", 3, new ArrayList<>(Arrays.asList("Sharik", "Ryan Gosling", "Cristiano Ronaldo")));
        dog = new Dog("Sharik", 5, new ArrayList<>(Arrays.asList("Pushok", "Kim Kardashian", "Justin Bieber")));
        System.out.println("До обнуления: " + cat);
        nullifyFields(cat);
        System.out.println("После обнуления: " + cat);
        System.out.println("До обнуления: " + dog);
        nullifyFields(dog);
        System.out.println("После обнуления: " + dog);
    }

    public static void nullifyFields(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType().isPrimitive()) {
                if (field.getType() == int.class) {
                    field.setInt(obj, 0);
                }
            } else {
                field.set(obj, null);
            }
        }
    }
}
