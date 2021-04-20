package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class GetAndPostExample {

    @Test
    public void testGet(){
      baseURI="https://reqres.in/api";
      given().get("/users?page=2").then().statusCode(200).
              body("data[4].first_name",equalTo("George"))
              .body("data.first_name",hasItems("George","Rachel"));
    }

    @Test
    public void testPost(){
        JSONObject request=new JSONObject();
        request.put("email","eve.holt@reqres.in");
        request.put("password","Teacher");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";
        given().header("Content-Type","application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("/register")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
