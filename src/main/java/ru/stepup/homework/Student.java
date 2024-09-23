package ru.stepup.homework;

import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ToString
@EqualsAndHashCode

public class Student {
    private String name;
    private List grades = new ArrayList<>();
    StudentRepositoryMock studentRepositoryMock;

    public Student(String name, StudentRepositoryMock studentRepositoryMock) {
        this.name = name;
        this.studentRepositoryMock = studentRepositoryMock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List getGrades() {
        return Collections.unmodifiableList(grades);
    }

    @SneakyThrows
    public void addGrade(int grade) {
        if (!studentRepositoryMock.checkGrade(grade)) {
            throw new IllegalArgumentException(grade + " is wrong grade");
        }
        grades.add(grade);
    }

    @SneakyThrows
    public int raiting() {
        return studentRepositoryMock.getRatingForGradeSum(grades.stream().mapToInt(x -> (int) x).sum());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.grades);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.grades, other.grades);
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", marks=" + grades + '}';
    }
}