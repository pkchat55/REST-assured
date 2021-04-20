package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PutPatchDeleteExample {

    @Test
    public void testPost(){
        JSONObject request=new JSONObject();
        request.put("name","Pravin");
        request.put("job","Teacher");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";
        given().header("Content-Type","application/json")
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/2")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void testDelete(){
        JSONObject request=new JSONObject();
        request.put("name","Pravin");
        request.put("job","Teacher");
        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";
                when()
                .delete("/users/2")
                .then()
                .statusCode(204)
                .log()
                .all();
    }
}
