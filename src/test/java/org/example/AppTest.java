package org.example;



import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        ResponseSpecification responseSpecification = expect()
                .statusCode(200);

        given()
                .when()
                .get("https://ya.ru")
                .then()
                .spec(responseSpecification);

    }

}