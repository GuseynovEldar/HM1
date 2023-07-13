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
import org.junit.Ignore;
import org.junit.Test;
import org.example.Pojo;
import org.example.Support;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.oneOf;


import lombok.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;




/*import org.apache.Http;*/


/**
 * Unit test for simple App.
 */


public class AppTest {


   /* @BeforeClass
    public static void beforeClass() throws Exception {
        RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), // отображать в консоли request
                new ResponseLoggingFilter(LogDetail.BODY));
    }*/


    /**
     * Rigorous Test :-)
     */


    @Test
    @DisplayName("RestAssured DZ 1 zadanie 1")
    public void firstpart() {
        given().pathParam("user", "2")
                .baseUri("https://reqres.in/api")
                .when().get("/users/{user}")
                .then().statusCode(200);
        System.out.println("Запуск теста dz 1 zadanie 1");
    }

    @Test
    @DisplayName("RestAssured DZ 1 zadanie 2")
    public void secondpart() {
        given().baseUri("https://reqres.in/api/")
                .given().queryParam("page", "2")
                .when().get("users")
                .then().statusCode(SC_OK);
        System.out.println("Запуск теста dz 1 zadanie 2");

    }

    @Test
    @DisplayName("RestAssured DZ 1 zadanie 3")
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
        System.out.println("Запуск теста dz 1 zadanie 3");

    }

    @Test
    @DisplayName("RestAssured DZ 1 zadanie 4")
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

        System.out.println("Запуск теста dz 1 zadanie 4");

    }


    @Data
    @Builder
    static class User {
        private String name;
        private String job;
    }


    @Test
    @DisplayName("RestAssured DZ 1 zadanie 5")
    public void fifth() {
        User user = User.builder().name("morpheus")
                .job("leader").build();

        given()
                .baseUri("https://reqres.in/api/users")
                .contentType(ContentType.JSON)
                .body(user)
                //.log().all()
                .post();
        //.then().assertThat().cookie("Content-Length", "84");

        System.out.println("Запуск теста dz 1 zadanie 5");
    }


    @Test
    @DisplayName("RestAssured DZ 2 zadanie 1")
    public void dz8_1() {
        User user = User.builder().name("morpheus")
                .job("leader").build();

        given()
                .baseUri("https://reqres.in/api/users")
                .contentType(ContentType.JSON)
                .body(user)
               // .log().all()
                .post()
                .then()
                //.assertThat().header("Accept", "*/*") - ругается, решил проверять другую куку
                .assertThat().header("Content-Length", "84")
                .assertThat().contentType(ContentType.JSON);

        System.out.println("Запуск теста dz 2 zadanie 1");
    }

    @Test
    @DisplayName("RestAssured DZ 2 zadanie 2")
    public void dz8_2() {
        given().baseUri("https://reqres.in/api/")
                .given().queryParam("page", "2")
                .when().get("users")
                .then()
                //.log().all()
                .assertThat().statusLine(containsString("HTTP/1.1"))
                .body("support.url", response -> equalTo("https://reqres.in/#support-heading"))
                .body("support.text", response -> equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

        System.out.println("Запуск теста dz 2 zadanie 2");
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




    @Test
    @DisplayName("RestAssured DZ 2 zadanie 3 плохая версия")
    @Ignore("По какой-то причине не отключает")
    public void dz8_3() {
        Codebeautify namana = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().body().as(Codebeautify.class);
        //System.out.println(namana.SupportObject.text);
        //(namana.SupportObject.text).equals(supText)
        Assert.assertEquals(namana.SupportObject.text, supText);

        System.out.println("Запуск теста dz 2 zadanie 3 плохая версия");
    }



    @Test
    @DisplayName("RestAssured DZ 2 zadanie 4 1-ая часть")
    public void dz8_4_1() {
        Response response = RestAssured.get("http://ya.ru");
        long timeRS = response.time();
        // System.out.println(timeRS + " время респонса от яндекса в миллисекундах");

        System.out.println("Запуск теста dz 2 zadanie 4 1-ая часть");
    }

    @Test
    @DisplayName("RestAssured DZ 2 zadanie 4 2-ая часть")
    public void dz8_4_2() {
        given().baseUri("http://ya.ru")
                .given()
                .when().get("http://ya.ru")
                .then().time(lessThan(900L));
        System.out.println("Запуск теста dz 2 zadanie 4 2-ая часть");
    }

    String supText = "To keep ReqRes free, contributions towards server costs are appreciated!";
    @Test
    @DisplayName("RestAssured DZ 2 zadanie 3 исправленная версия")
    //@JsonIgnoreProperties(ignoreUnknown = true)
    public void dz8_part_3_pojo()
    {
        Pojo ones = given()
                .relaxedHTTPSValidation()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .extract().body().as(Pojo.class);
        //System.out.println(ones.support);
        Assert.assertEquals("сравнение с supText",ones.getSupport().getText(), supText);

        System.out.println("Запуск теста dz 2 zadanie 3 исправленная версия");

    }

}




