package org.example;


import java.util.Scanner;

public class App
{
    /*public boolean test (Dog dog1, Dog dog2) {
        boolean eq;
        return eq;
    }*/


    public static void main( String[] args )
    {
        Dog dog1 = new Dog();
        Owner owner1 = new Owner();
        dog1.nickname = "Belka";
        dog1.age = 5;
        owner1.FIO = "Kostya";
        owner1.Adress = "Spb";
        dog1.owner = owner1;


        Dog dog2 = new Dog();
        Owner owner2 = new Owner();
        dog2.nickname = "Belka";
        dog2.age = 5;
        owner2.FIO = "Kostya";
        owner2.Adress = "Spb";
        dog2.owner = owner2;



        //System.out.println( dog1.age==dog2.age);
        //(dog1.age).equals(dog2.age);





/*        String a = new String("Привет");
        String b = new String("Привет");
        System.out.println(a == b);
        System.out.println(a.equals(b));*/







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
