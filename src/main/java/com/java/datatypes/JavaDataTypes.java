package com.java.datatypes;

public class JavaDataTypes 
{

	public static void main(String[] args) 
	{
		//Primitive Datatype
		System.out.println("######## Primitive Datatype ########\n");

		//Boolean datatype (true or false)
		System.out.println("******** Boolean data type ********");
		boolean value=false;
		System.out.println(value);


		/*int datatype
		* 32-bit signed integer
		* range :- -2,147,483,648 to 2,147,483,647
		* */
		System.out.println("******** int data type ********");
		int number=-2147483648;
		System.out.println(number);

		/*long datatype
		* 64-bit signed integer
		* range :- -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
		* suffix is "L"
		* */
		System.out.println("******** long data type ********");
		long longNumber=-2147483649L;
		System.out.println(longNumber);

		/*float data type
		* 32-bit decimal number
		* range :- 3.4 x 10^-38 to 3.4 x 10³⁸
		* suffix is "f"
		* */
		System.out.println("******** float data type ********");
		float floatNumber=25.6345f;
		System.out.println(floatNumber);

		/*double data type
		* 64-bit decimal number
		* range :- 4.9 x 10^-324 to 1.8 x 10³⁰⁸
		* */
		System.out.println("******** double data type ********");
		double doubleNumber=8500369.256345;
		System.out.println(doubleNumber);

		/*Character data type
		 * You can store single characters
		 * */
		System.out.println("******** Character data type ********");
		char Character='A';
		System.out.println(Character);

		/*Reference  Data types
		* In reference datatype the reference to the value is stored not the original value
		* */
		System.out.println("######## Reference Datatype ########\n");

		/*
		* String is sequence of characters
		* There are two ways to create String variable
		* */
		System.out.println("******** String ********");
		String str="Ramesh";
		System.out.println(str);

		String newStr=new String("Suresh");
		System.out.println(newStr);

		/*
		* Arrays are collection of similar data types
		* */
		System.out.println("******** Array ********");
		int [] array=new int[3];
		// index starts with 0, 0,1,2
		array[0]=5;
		array[1]=18;
		array[2]=50;

		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
		System.out.println();
		int [] arrays={10,25,65,56,80};
		for (int i = 0; i < arrays.length; i++)
		{
			System.out.println(arrays[i]);
		}
	}
}
