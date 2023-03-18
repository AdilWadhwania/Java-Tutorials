package com.java.array;

public class ArrayPractice
{
    public static void main(String[] args)
    {
        //declaration of array
        int [] arr=new int[3];// 0 0 0
        //int arr1 []=new int[3];

        // assigning the values in array
        arr[0]=2;
        arr[1]=3;
        arr[2]=5;

        // printing the value
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }

        // update the value in array
        System.out.println("=========================");
        arr[2]=15;
        System.out.println(arr[2]);
    }
}
