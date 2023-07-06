package org.example;
/*package org.apache.http;*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;


import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;




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


        given().spec(rq).pathParam("us", "23")
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
        //.then().assertThat().cookie("Content-Length", "84");
    }


    @Test
    public void dz8_1() {
        User user = User.builder().name("morpheus")
                .job("leader").build();

        given()
                .baseUri("https://reqres.in/api/users")
                .contentType(ContentType.JSON)
                .body(user)
                .log().all()
                .post()
                .then()
                //.assertThat().header("Accept", "*/*") - ругается, решил проверять другую куку
                .assertThat().header("Content-Length", "84")
                .assertThat().contentType(ContentType.JSON);
    }

    @Test
    public void dz8_2() {
        given().baseUri("https://reqres.in/api/")
                .given().queryParam("page", "2")
                .when().get("users")
                .then()
                //.log().all()
                .assertThat().statusLine(containsString("HTTP/1.1"))
                .body("support.url", response -> equalTo("https://reqres.in/#support-heading"))
                .body("support.text", response -> equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    //иначе ругается =) говорит, что не всё определил
    public static class Codebeautify {
        private float page;
        private float per_page;
        private float total;
        private float total_pages;
        ArrayList<Object> data = new ArrayList<Object>();
        Support SupportObject;


        // Getter Methods

        public float getPage() {
            return page;
        }

        public float getPer_page() {
            return per_page;
        }

        public float getTotal() {
            return total;
        }

        public float getTotal_pages() {
            return total_pages;
        }

        public Support getSupport() {
            return SupportObject;
        }

        // Setter Methods

        public void setPage(float page) {
            this.page = page;
        }

        public void setPer_page(float per_page) {
            this.per_page = per_page;
        }

        public void setTotal(float total) {
            this.total = total;
        }

        public void setTotal_pages(float total_pages) {
            this.total_pages = total_pages;
        }

        public void setSupport(Support supportObject) {
            this.SupportObject = supportObject;
        }
    }

    public static class Support {
        private String url;
        private String text;


        // Getter Methods

        public String getUrl() {
            return url;
        }

        public String getText() {
            return text;
        }

        // Setter Methods

        public void setUrl(String url) {
            this.url = url;
        }

        public void setText(String text) {
            this.text = text;
        }
    }


    String supText = "To keep ReqRes free, contributions towards server costs are appreciated!";

    @Test
    public void dz8_3() {
        Codebeautify namana = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().body().as(Codebeautify.class);
        //System.out.println(namana.SupportObject.text);
        //(namana.SupportObject.text).equals(supText)
        Assert.assertEquals(namana.SupportObject.text, supText);


    }

    @Test
    public void dz8_4_1() {
        Response response = RestAssured.get("http://ya.ru");
        long timeRS = response.time();
        System.out.println(timeRS + " время респонса от яндекса в миллисекундах");
    }

    @Test
    public void dz8_4_2() {
        given().baseUri("http://ya.ru")
                .given()
                .when().get("http://ya.ru")
                .then().time(lessThan(600L));

    }
}




