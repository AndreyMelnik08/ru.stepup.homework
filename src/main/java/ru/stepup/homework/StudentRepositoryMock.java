package ru.stepup.homework;

public class StudentRepositoryMock implements StudentRepository {

    @Override
    public int getRatingForGradeSum(int sum) {
        return 10;
    }

    public long count() {
        return 0;
    }

    public void delete(Student entity) {
    }

    public void deleteAll(Iterable<Student> entities) {
    }

    public Iterable<Student> findAll() {
        return null;
    }

    public Student save(Student entity) {
        return null;
    }

    public Iterable<Student> saveAll(Iterable<Student> entities) {
        return null;
    }

    @Override
    public boolean checkGrade(int grade) {
        return grade >= 1 && grade <= 5;
    }

}
