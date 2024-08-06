package ru.stepup.homework;

public class Employee {

    private String name;
    private Department department;

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        if (department.getPosition().equals(Position.MANAGER)) {
            return name + ". Начальник отдела: " + department.getName();
        }
        return name + " работает в отделе " + department.getName() + ". Начальник " + department.getManager().getName();
    }
}

