import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.isEmptyOrNullString;

public class TestWebServiceWithoutStudents {
    @Test
    public void getTopStudentWithoutAddedStudents() {
        RestAssured.given().contentType(ContentType.JSON)
                .when().get("/topStudent").then().statusCode(200).body(isEmptyOrNullString());
    }

    @Test
    public void getTopStudentWithEmptyMarks() {
        int id = 50;
        String name = "Anna";
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + id + ", \"name\":\"" + name + "\", \"marks\":}").
                when().get("/topStudent").then().statusCode(200).body(isEmptyOrNullString());
    }
}
