package org.example;
/*package org.apache.http;*/


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

import lombok.*;




/*import org.apache.Http;*/


/**
 * Unit test for simple App.
 */


public class AppTest {



    @BeforeClass
    public static void beforeClass() throws Exception {
       RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), // отображать в консоли request
                 new ResponseLoggingFilter(LogDetail.BODY));
   }


    /**
     * Rigorous Test :-)
     */

    @Test
    public void firstpart() {
        given().pathParam("user", "2")
                .baseUri("https://reqres.in/api")
                .when().get("/users/{user}")
                .then().statusCode(200);
    }

    @Test
    public void secondpart() {
        given().baseUri("https://reqres.in/api/")
                .given().queryParam("page", "2")
                .when().get("users")
                .then().statusCode(SC_OK);

    }

    @Test
    public void third() {

        ResponseSpecification rs = new ResponseSpecBuilder()
                .expectStatusCode(SC_OK)
                .build();

        RequestSpecification rq = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/users")
                .build();

        given().spec(rq)
                .queryParam("page", "2")
                .when().get()
                .then().spec(rs);

    }

    @Test
    public void fourth() {

        RequestSpecification rq = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/unknown")
                .build();

        ResponseSpecification rs = new ResponseSpecBuilder()
                .expectStatusCode(SC_NOT_FOUND)
                .build();


        given().spec(rq).pathParam("us","23")
                .when()
                .get("{us}")
                .then().spec(rs);

    }


    @Data
    @Builder
    static class User {
        private String name;
        private String job;
    }






    @Test
    public void five() {
        User user = User.builder().name("morpheus")
                .job("leader").build();

        given()
                .baseUri("https://reqres.in/api/users")
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .post();
                //.then().statusCode(SC_CREATED);
    }








}




