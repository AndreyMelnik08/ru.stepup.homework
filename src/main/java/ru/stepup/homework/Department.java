package ru.stepup.homework;

public class Department {

    private String name;
    private Position position;
    private Employee manager;

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Employee getManager() {
        return manager;
    }

    public Department(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Department(String name, Position position, Employee manager) {
        this.name = name;
        this.position = position;
        if (name.equals(manager.getDepartment().getName())) {
            this.manager = manager;
        } else {
            System.out.println("Руководитель является начальником другого отдела");
        }
    }
}

