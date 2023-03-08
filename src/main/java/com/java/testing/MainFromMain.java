package com.java.testing;

import java.util.Arrays;

/* Calling main method of a class from another method and watching what will happen in this scenario
* It is recommended to write a main method and do not call another main method because it can cause confusion
* */
public class MainFromMain
{

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Called the first main method");
        String[] s=new String[5];
        SecondMain.main(s);
    }
}
class SecondMain
{

    public static void main(String... args)
    {

        System.out.println("Called the second main method");
        for (String arg : args)
        {
            System.out.println(arg);
        }
    }
}
