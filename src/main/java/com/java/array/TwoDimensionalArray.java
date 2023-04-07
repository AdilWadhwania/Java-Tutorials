package com.java.array;

public class TwoDimensionalArray
{
    public static void main(String[] args)
    {
        //Declaring a 2D array
        int[][] twoDArray=new int[3][3];

        //Assigning values in 2D array
        twoDArray[0][0]=5;//first column of first row
        twoDArray[1][2]=10;//third column of second row
        twoDArray[2][1]=15;//second column of third row

        //iterating through 2D array
        for (int i = 0; i < twoDArray.length; i++)
        {
            for (int j = 0; j < twoDArray[i].length; j++)
            {
                System.out.print(twoDArray[i][j]+"   ");
            }
            System.out.println();
        }

        //Updating a value in 2D array

        //updated the value of second column of second row from 15 to 45
        twoDArray[2][1]=45;
        System.out.println(twoDArray[2][1]);//printing the updated value
    }
}
