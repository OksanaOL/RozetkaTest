

package org.example;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;


public class AppTest {


    @Test
    public void timeZoneTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        Response response = RestAssured.given()
                .when()
                .get("/users");

        Type listType = new TypeToken<List<Users>>() {
        }.getType();
        List<Users> receivedUsers = new Gson().fromJson(response.asString(), listType);

    }
}