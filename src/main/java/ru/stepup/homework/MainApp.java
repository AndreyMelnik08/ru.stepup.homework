package ru.stepup.homework;

public class MainApp {

    public static void main(String[] args) {

        Employee alex = new Employee("Alex", new Department("IT", Position.MANAGER));
        Employee tom = new Employee("Tom", new Department("IT", Position.SPECIALIST, alex));

        System.out.println(alex);
        System.out.println(tom);

    }
}