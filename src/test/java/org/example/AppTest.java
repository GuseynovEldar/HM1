package org.example;
/*package org.apache.http;*/


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
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


/*   @Test
    public void resttest()
    {
        RequestSpecification reqSpec = given()
                .relaxedHTTPSValidation()
                .baseUri("https://rahulshettyacademy.com/maps/api/place/");

        reqSpec.when().get("/cookiesformonster");

        RestAssured
                .given()
                .when();

    }*/
/*   @Test
    public void yandextest()
    {
        RequestSpecification yaSpecRq = RestAssured.given();
        RequestSpecification
                .baseUri("http://ya.ru/")
                .when().get()
                .then().statusCode(301);




        *//*yaSpecRq.given().when();
        yaSpecRs.then().expect();*//*
    }*/
    @Test
    public void firstpart() {
        /*RequestSpecification firstpart1 = given()
                firstpart1.relaxedHTTPSValidation()
                firstpart1.baseUri("https://reqres.in");
                firstpart1.pathParam("2")
                firstpart1.when()
                        .get("/cookiesformonster")*/


        RestAssured

                .given().pathParam("user", "2")
                .baseUri("https://reqres.in/api")
                .log().all()
                .when().get("/users/{user}")
                .then().statusCode(200);
    }

    @Test
    public void secondpart() {
        RestAssured
                .given().baseUri("https://reqres.in/api/")
                .given().queryParam("page", "2")
                .when().get("users")
                .then().statusCode(SC_OK);

    }

    @Test
    public void trhird() {

        ResponseSpecification rs = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RequestSpecification rq = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api/users")
                .build();

        RestAssured

                .given().spec(rq)
                .queryParam("page", "2")
                .when().get()
                .then().spec(rs);

    }

    /*    @Test
    public void thirdpart()
    {
        RequestSpecification reqSpec = given()
                .relaxedHTTPSValidation()
                .given().baseUri("https://reqres.in/api/users");
        reqSpec.when()
                .get("/2");
        reqSpec.then().statusCode(200);
                *//*.then().statusCode(httpStatus.SC_OK);*//*

        RestAssured
                .given()
                .when()
                .log().all()
                .then();

    }*/

}




