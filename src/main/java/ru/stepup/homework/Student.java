package ru.stepup.homework;

import java.util.Arrays;

public class Student {
    private String name;
    private int[] grades;

    public Student(String name, int[] grades) throws IllegalArgumentException {
        for (int grade : grades) {
            if (grade < 2 || grade > 5) {
                throw new IllegalArgumentException("Все оценки должны быть в диапазоне от 2 до 5");
            }
        }
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void addGrade(int grade) {
        if (grade >= 2 && grade <= 5) {
            int[] newGrades = new int[grades.length + 1];
            for (int i = 0; i < grades.length; i++) {
                newGrades[i] = grades[i];
            }
            newGrades[grades.length] = grade;
            grades = newGrades;
        } else {
            System.out.println("Все оценки должны быть в диапазоне от 2 до 5");
        }
    }

    @Override
    public String toString() {
        return name + ", оценки: " + Arrays.toString(grades);
    }
}
