import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TestWebServiceAllStudentWithHighestAverage {
    @Test
    public void getTopAllStudentWithHighestAverage() {
        int[] marks1 = new int[]{2, 4, 5};
        int[] marks2 = new int[]{5, 5, 5};
        int[] marks3 = new int[]{5, 5, 5};
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + "null" + ", \"name\":\"" + "Sasha" + "\", \"marks\":" + arrayToJson(marks1) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + "null" + ", \"name\":\"" + "Roma" + "\", \"marks\":" + arrayToJson(marks2) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + "null" + ", \"name\":\"" + "Dima" + "\", \"marks\":" + arrayToJson(marks3) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                given().when().get("/topStudent").then().
                statusCode(200).contentType(ContentType.JSON).
                body("name[0]", equalTo("Roma")).body("marks[0]", hasItems(5, 5, 5)).
                body("name[1]", equalTo("Dima")).body("marks[1]", hasItems(5, 5, 5));
    }

    private String arrayToJson(int[] array) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            json.append(array[i]);
            if (i < array.length - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

}
