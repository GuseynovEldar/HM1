package org.example;


import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

/*public class AnnotationsJUnit {
    private class  FirstNestedClass{
    @Test
    @Tag("DZ1")
    @DisplayName("RestAssured DZ 1 zadanie 2")
    void secondpart() {
        System.out.println("Запуск теста dz 1 zadanie 2");

    }
    }
}*/

public class AnnotationsJUnit {
    @Test
    public void test1() {
        System.out.println("This is Jupiter test1!");
    }

    @Test
    public void test2() {
        System.out.println("This is Jupiter test2!");
    }

    @Nested
    @DisplayName("Nested non parametrized")
    class NonParamsTest {
        @Test
        void testNested() {
            System.out.println("This is Nested test!");
        }
    }
}





/*    @Nested
    public static class FirstNestedClass {
        @Test
        public void test1() {
            System.out.println("FirstNestedClass.test()");
        }
    }

    @Nested
    public class SecondNestedClass {
        @Test
        public void test2() {
            System.out.println("SecondNestedClass.test()");
        }
    }*/

