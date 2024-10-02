import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.mockito.Mockito;
import org.testng.annotations.Test;
import ru.stepup.homework.Student;
import ru.stepup.homework.StudentRepositoryMock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class StudentTest {

    @Test
    public void testAddGrade() throws IOException { // Создаем моки
        CloseableHttpClient httpClientMock = Mockito.mock(CloseableHttpClient.class);
        CloseableHttpResponse httpResponseMock = Mockito.mock(CloseableHttpResponse.class);
        HttpEntity entityMock = Mockito.mock(HttpEntity.class);
        Mockito.when(httpClientMock.execute(Mockito.any())).thenReturn(httpResponseMock);
        Mockito.when(httpResponseMock.getEntity()).thenReturn(entityMock);
        InputStream istr = new ByteArrayInputStream("true".getBytes());
        Mockito.when(entityMock.getContent()).thenReturn(istr);
        StudentRepositoryMock studentRepositoryMock = new StudentRepositoryMock();
        Student student = new Student("Vasya", studentRepositoryMock);
        student.addGrade(4);
        student.addGrade(5);
        List grades = student.getGrades();
        assertEquals(2, grades.size());
        assertTrue(grades.contains(4));
        assertTrue(grades.contains(5));
    }

    @Test
    public void testAddInvalidGrade() throws IOException {
        CloseableHttpClient httpClientMock = Mockito.mock(CloseableHttpClient.class);
        CloseableHttpResponse httpResponseMock = Mockito.mock(CloseableHttpResponse.class);
        HttpEntity entityMock = Mockito.mock(HttpEntity.class);
        Mockito.when(httpClientMock.execute(Mockito.any())).thenReturn(httpResponseMock);
        Mockito.when(httpResponseMock.getEntity()).thenReturn(entityMock);
        InputStream istr = new ByteArrayInputStream("false".getBytes());
        Mockito.when(entityMock.getContent()).thenReturn(istr);
        StudentRepositoryMock studentRepositoryMock = new StudentRepositoryMock();
        Student student = new Student("Vasya", studentRepositoryMock);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            student.addGrade(6);
        });
        assertEquals("6 is wrong grade", exception.getMessage());
    }
}

