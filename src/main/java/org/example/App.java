package org.example;


import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Dog dog1 = new Dog();
        dog1.nickname = "Belka";
        dog1.age = 5;
        dog1.owner = "Kostya";



        Dog dog2 = new Dog();
        dog2.nickname = "Strelka";
        dog2.age = 7;
        dog2.owner = "Dyadya";



        //System.out.println( dog1==dog2);
        //System.out.println(dog1.equals(dog2));

        String a = new String("Привет");
        String b = new String("Привет");
        System.out.println(a == b);
        System.out.println(a.equals(b));







        // коммент
/*
        System.out.println( "Hello\n\tWorld!" );

        многосторочный комметарий


        int agei = 555555;
        System.out.println("Возраст " + agei);
        byte ageb = 125;
        short ages = 1000;
        long agel = 999999;

        float numfloat = 4.34f;
        double numdouble = 5.45454d;

        char ch = 'c';
        String user_name = "Eldar";
        System.out.println(user_name);

        boolean ishappy = false;


        //получение данных от пользователя

        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedite text");
        String t1 = scan.nextLine();
        System.out.println("Привет " + t1);

        int t2 = scan.nextInt();

       // Мат действия
        float x1 = 10, x2 = 6;
        float x3 = 10 / 6;

        x3 += x3;
        x3++;
*/

    }
}
