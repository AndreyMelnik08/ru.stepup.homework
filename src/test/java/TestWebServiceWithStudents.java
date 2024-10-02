import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class TestWebServiceWithStudents {

//java -jar RestApp.jar
//java -jar RestAppBroken.jar

    @Test
    public void addStudent() {
        int id = 1;
        int[] marks = new int[]{2, 4, 5};
        String name = "Andrey";
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + id + ", \"name\":\"" + name + "\", \"marks\":" + arrayToJson(marks) + "}").
                when().post("/student").then().
                statusCode(201);
    }

    @Test
    public void testGetStudent() {
        int id = 100;
        String name = "Fedor";
        int[] marks = new int[]{3, 3, 3};
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"id\":" + id + ", \"name\":\"" + name + "\", \"marks\":" + arrayToJson(marks) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().
                baseUri("http://localhost:8080/student/" + id).
                contentType(ContentType.JSON).
                when().get().then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", equalTo(100)).body("name", equalTo("Fedor")).body("marks", hasItems(3, 3, 3));
    }

    @Test
    public void testGetNonExistingStudent() {
        int nonExistingId = 999;
        RestAssured.given().
                baseUri("http://localhost:8080/student/" + nonExistingId).contentType(ContentType.JSON).
                when().get().then().
                statusCode(404);
    }

    @Test
    public void updateStudent() {
        int id = 10;
        String name = "Vasya";
        int[] marks = new int[]{2, 4, 2};
        int[] marksUpdate = new int[]{2, 2, 1, 2};
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + id + ", \"name\":\"" + name + "\", \"marks\":" + arrayToJson(marks) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + id + ", \"name\":\"" + name + "\", \"marks\":" + arrayToJson(marksUpdate) + "}")
                .when().post("/student").then().statusCode(201);
    }

    @Test
    public void addStudentWithNullId() {
        int id = 30;
        String name = "Hary";
        int[] marks = new int[]{};
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"id\":" + id + ", \"name\":\"" + name + "\", \"marks\":" + arrayToJson(marks) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().
                baseUri("http://localhost:8080/student/" + id).
                contentType(ContentType.JSON).
                when().get().then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", equalTo(id)).body("name", equalTo("Hary")).body("marks", hasItems());
    }

    @Test
    public void addStudentWithoutName() {
        int id = 20;
        int[] marks = new int[]{1, 1, 1};
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + id + ", \"name\", \"marks\":" + arrayToJson(marks) + "}").
                when().post("/student").then().
                statusCode(400);
    }

    @Test
    public void deleteStudent() {
        int id = 1;
        int[] marks = new int[]{2, 4, 5};
        String name = "Andrey";
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + id + ", \"name\":\"" + name + "\", \"marks\":" + arrayToJson(marks) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                when().delete("/student/" + 1).then().
                statusCode(200);

        RestAssured.given().
                baseUri("http://localhost:8080/student/" + id).
                contentType(ContentType.JSON).
                when().get().then().
                statusCode(404);
    }
    
    @Test
    public void deleteStudentWithNonExistingId() {
        int nonExistingId = 8888;
        RestAssured.given().contentType(ContentType.JSON).
                when().delete("/student/" + nonExistingId).then().
                statusCode(404);
    }

    @Test
    public void getTopSingleStudentWithHighestAverage() {
        int[] marks1 = new int[]{2, 3, 3};
        int[] marks2 = new int[]{4, 4, 4};
        int[] marks3 = new int[]{1, 4, 3};
        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + "null" + ", \"name\":\"" + "Alex" + "\", \"marks\":" + arrayToJson(marks1) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + "null" + ", \"name\":\"" + "Tom" + "\", \"marks\":" + arrayToJson(marks2) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                body("{\"Id\":" + "null" + ", \"name\":\"" + "Jack" + "\", \"marks\":" + arrayToJson(marks3) + "}").
                when().post("/student").then().
                statusCode(201);

        RestAssured.given().contentType(ContentType.JSON).
                given().when().get("/topStudent").then().
                statusCode(200).contentType(ContentType.JSON).
                body("name[0]", equalTo("Tom")).body("marks[0]", hasItems(4, 4, 4));
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

