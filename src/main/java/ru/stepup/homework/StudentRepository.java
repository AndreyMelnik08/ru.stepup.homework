package ru.stepup.homework;

public interface StudentRepository {
    int getRatingForGradeSum(int sum);

    long count();

    void delete(Student entity);

    void deleteAll(Iterable<Student> entities);

    Iterable<Student> findAll();

    Student save(Student entity);

    Iterable<Student> saveAll(Iterable<Student> entities);

    boolean checkGrade(int grade);
}
