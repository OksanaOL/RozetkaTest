package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


public class AppTest {
    private final String expectedTimeZone = "(\"Europe/Kiev\")";


    @Test
    public void timeZoneTest() {
        RestAssured.baseURI = "http://worldtimeapi.org/api/";
        Response response = RestAssured.given()
                .when()
                .get("/timezone");

        Assert.assertEquals("response code should be 200", 200, response.statusCode());
        Assert.assertTrue("Response time should be lees than 200ms", response.time() < 2000);
        Assert.assertTrue(response.asString().contains("Kiev"));
    }
}
