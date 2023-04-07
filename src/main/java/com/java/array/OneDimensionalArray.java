package com.java.array;

/**
 * In this class we will see about one-dimensional
 * array in java, how to declare, assign values,
 * print the values and update the value in one dimensional array
 */
public class OneDimensionalArray
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
