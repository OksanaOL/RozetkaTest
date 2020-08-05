package org.example;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class JsonplaceholderTest {

    public final int userId = 1;

    @Test
    public void userTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        Response response = RestAssured.given()
                .when()
                .get("/users/" + userId);

        Assert.assertEquals("response code should be 200", 200, response.statusCode());
        User responseUser = new Gson().fromJson(response.asString(), User.class);
        System.out.println(responseUser.getWebsite());
    }

}
