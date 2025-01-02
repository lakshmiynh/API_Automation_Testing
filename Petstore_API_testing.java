package API_Automation;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Petstore_API_testing{
    @Test
    public void user_Post_Createuser() {
        String requestBody = "{\n" +
                "  \"id\": 2,\n" +
                "  \"username\": \"smith02\",\n" +
                "  \"firstName\": \"smith\",\n" +
                "  \"lastName\": \"reo\",\n" +
                "  \"email\": \"smith@gmail.com\",\n" +
                "  \"password\": \"smith123\",\n" +
                "  \"phone\": \"6362368704\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        // Send POST request
        Response response = given()
                                .header("Content-Type", "application/json")
                                .body(requestBody)
                                .when()
                                .post("https://petstore.swagger.io/v2/user");
                        System.out.println("Response Body: " + response.asString());
        response.then()
                .statusCode(200)
                .log().all();
    }
@Test
    public void user_Get_User()
    {
        Response response = given()
                                .header("Content-Type","\n" + "application/json")
                                .when()
                                .get("https://petstore.swagger.io/v2/user/smith02");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void user_Get_login()
    {
        Response response = given()
                                .header("Postman-Token","\n" + "<calculated when request is sent>\n")
                                .when()
                                .get("https://petstore.swagger.io/v2/user/login?username=jhon01&password=jhon123");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();

    }
@Test
    public void user_Put_Update()
    {
        String requestBody = "{\n" +
                "  \"id\": 2,\n" +
                "  \"username\": \"smith02\",\n" +
                "  \"firstName\": \"smith\",\n" +
                "  \"lastName\": \"reo\",\n" +
                "  \"email\": \"smith@gmail.com\",\n" +
                "  \"password\": \"smith123\",\n" +
                "  \"phone\": \"6362368704\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        Response response = given()
                .header("Content-Type","\n" + "application/json")
                .body(requestBody)
                .when()
                .put("https://petstore.swagger.io/v2/user/smith02");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void user_Get_Userlout()
    {
        Response response = given()
                .header("Postman-Token","\n" + "<calculated when request is sent>\n")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        System.out.println("Response Body: " + response.asString());
        response.then()
                .statusCode(200)
                .log().all();
    }
@Test
    public void user_Delete()
    {
        Response response = given()
                .header("Postman-Token","\n" + "<calculated when request is sent>\n")
                .when()
                .delete(" https://petstore.swagger.io/v2/user/smith02?02=smith");
        System.out.println("Response Body: " + response.asString());
        // response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }

    //API Automation Testing For Store collection
    @Test
    public void store_Post_Createstore() {
        String requestBody = "{\n" +
                "  \"id\": \"2\",\n" +
                "  \"petId\": \"02\",\n" +
                "  \"quantity\": \"3\",\n" +
                "  \"shipDate\": \"2024-12-22T13:21:31.965Z\",\n" +
                "  \"status\": \"Bengalore\",\n" +
                "  \"complete\": \"true\"\n" +
                "}";

        // Send POST request
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void store_Get_order()
    {
        Response response = given()
                .header("Postman-Token","\n" + "<calculated when request is sent>\n")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/02");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();

    }
    @Test
    public void store_Get_petstatus()
    {
        Response response = given()
                .header("Postman-Token","\n" + "<calculated when request is sent>\n")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void store_Delete_order()
    {
        Response response = given()
                .header("Postman-Token","\n" + "<calculated when request is sent>\n")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/01");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
    //API Automation testing for Pet
    @Test
    public void pet_Post_newstpre()
    {
        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"puppy\"\n" +
                "  },\n" +
                "  \"name\": \"dogies\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.rd.com%2Flist%2Fadorable-puppy-pictures%2F&psig=AOvVaw1vuPwsoXn_AkAiNUl-XuMD&ust=1734961972190000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCIjUxJPDu4oDFQAAAAAdAAAAABAE\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"puppy\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void pet_Getstatus()
    {
        Response response = given()
                .header("Postman-Token","\n" + "<calculated when request is sent>\n")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void pet_Put_update()
    {
        String requestBody = "{\n" +
                "  \"id\": 1,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"chitty\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"chitty\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
    @Test
    public void pet_Deletepet()
    {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/1?pet=1");
        response.prettyPrint();
        response.then()
                .statusCode(200)
                .log().all();
    }
}
