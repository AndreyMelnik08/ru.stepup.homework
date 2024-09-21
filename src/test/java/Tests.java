import org.testng.annotations.Test;
import ru.stepup.homework.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Tests {
    @Test
    public void testAddGrade() {
        Student student = new Student("Vasya");
        student.addGrade(4);
        student.addGrade(5);
        List grades = student.getGrades();
        assertEquals(2, grades.size());
        assertTrue(grades.contains(4));
        assertTrue(grades.contains(5));
    }

    @Test
    public void testAddInvalidGrade() {
        Student student = new Student("Vasya");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(6);
        });
        assertEquals("6 is wrong grade", exception.getMessage());
    }

    @Test
    public void testGetGradesImmutable() {
        Student student = new Student("Vasya");
        student.addGrade(4);
        List grades = student.getGrades(); // Проверка, что список оценок нельзя изменить
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            grades.add(5);
        });
        assertEquals("UnsupportedOperationException", exception.getClass().getSimpleName());
    }

    @Test
    public void testEqualsAndHashCode() {
        Student student1 = new Student("Vasya");
        student1.addGrade(3);
        Student student2 = new Student("Vasya");
        student2.addGrade(3);
        assertEquals(student1, student2);
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    public void testToString() {
        Student student = new Student("Vasya");
        student.addGrade(4);
        student.addGrade(5);
        String expected = "Student{name=Vasya, marks=[4, 5]}";
        assertEquals(expected, student.toString());
    }
}
