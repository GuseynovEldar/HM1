package org.example;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.RepeatedTest.LONG_DISPLAY_NAME;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnnotationsJUnit {



    @Order(1)
    @Test
    @DisplayName("TimeOUT TEST")
    @Timeout(value = 7000, unit = TimeUnit.MILLISECONDS)
    public void timeouttest() {
        Response response = RestAssured.get("http://ya.ru");
        long timeRS = response.time();
        System.out.println(timeRS + " время респонса от яндекса в миллисекундах");

    }

    @Order(2)
    @Test
    @DisplayName("Assume True")
    void assumetruetest (){
        Assumptions.assumeTrue(2==2);
        System.out.println("Assume True TEST");
    }

    @Order(3)
    @Test
    @DisplayName("Assume False")
    void assumefalsetest (){
        Assumptions.assumeFalse(2==1);
        System.out.println("Assume False TEST");
    }

    @Order(4)
    @Test
    void assumуthattest() {
        assumingThat("1".equals("2"),
                () -> {
                    assertEquals(2, 1+1);
                    System.out.println("Проходит предположение в AssumeThat");
                });

        assertEquals(42, 6*7);

    }


    @Order(5)
    @DisplayName("Repeated TEST")
    @RepeatedTest(value = 5, name = LONG_DISPLAY_NAME)
    void repeatedtest() {
        Response response = RestAssured.get("http://vk.com");
        long timeRS = response.time();
        System.out.println(timeRS + " время респонса от vk в миллисекундах. ПОВТОР");
    }

    @Nested
    @DisplayName("Nested 1 2")
    class Nested_first {
        @Test
        public void test1() {
            System.out.println("Test 1 result");
        }

        @Test
        public void test2() {
            System.out.println("Test 2 result");
        }
    }


    @Nested
    @DisplayName("Nested 3 4")
    class Nested_second {

        @Test
        void test3() {
            System.out.println("Test 3 result");
        }

        @Disabled
        @Test
        void test4() {
            System.out.println("Test 4 result");
        }
    }


}


