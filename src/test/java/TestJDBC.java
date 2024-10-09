import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.sql.*;

import static org.testng.AssertJUnit.assertEquals;
import static ru.office.Service.createDB;

public class TestJDBC {
    private static final String DB_URL = "jdbc:h2:C:\\Users\\Компутер\\IdeaProjects\\Office";

    @BeforeEach
    public void setUp() {
        createDB();
    }

    @Test
    public void testUpdateEmployeeDepartment() {
        try (Connection con = DriverManager.getConnection(DB_URL);
             Statement stm = con.createStatement()) {
            ResultSet resultSet = stm.executeQuery("SELECT ID FROM Employee WHERE NAME = 'Ann'");
            if (resultSet.next()) {
                int employeeId = resultSet.getInt("ID");
                stm.executeUpdate("UPDATE Employee SET DepartmentID = 3 WHERE ID = " + employeeId);
            }
            resultSet = stm.executeQuery("SELECT DepartmentID FROM Employee WHERE NAME = 'Ann'");
            if (resultSet.next()) {
                int departmentId = resultSet.getInt("DepartmentID");
                assertEquals(3, departmentId);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testCorrectEmployeeNames() {
        int correctedCount = 0;
        try (Connection con = DriverManager.getConnection(DB_URL); Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT ID, NAME FROM Employee");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");

                if (Character.isLowerCase(name.charAt(0))) {
                    String correctedName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
                    stm.executeUpdate("UPDATE Employee SET NAME = '" + correctedName + "' WHERE ID = " + id);
                    correctedCount++;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        assertEquals(0, correctedCount);
        System.out.println("Количество исправленных имён: " + correctedCount);
    }

    @Test
    public void testCountEmployeesInITDepartment() {
        int count = 0;
        try (Connection con = DriverManager.getConnection(DB_URL); Statement stm = con.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) AS Count FROM Employee WHERE DepartmentID = 2");
            if (rs.next()) {
                count = rs.getInt("Count");
                assertEquals(2, rs.getInt("Count"));
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Количество сотрудников в IT-отделе: " + count);
        }
    }
}
