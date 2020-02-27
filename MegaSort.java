/* 
	MegaSort.java
	Author: Aileen L. Cai
	Data Structures and Algorithms
	Practice Assignment 05
	February 27, 2020 
*/


import java.io.*;
import java.util.*;

public class MegaSort extends RadixSort
{
	public static void main (String [] args) throws Exception
	{
		Scanner numberFile = new Scanner(new File("1m-ints.txt")); //opening the text file 

		int [] num = new int [1000000];  //creating a new array that can hold all values in text file
		int i = 0;						 //we know that the file holds 1000000 values, so array of that size is created 
		while(numberFile.hasNextInt())
		{
			num[i++] = numberFile.nextInt();  //copying each value in file to the array
		}

		int n = 1000000; //already know that there are 1,000,000 values in the file
		radixSort(num, n); //sorting algorithm

		FileWriter output = new FileWriter("finalOutput.txt");  //creating a new text file 
		
		for (int q = 0; q < num.length; q++)  //writing the sorted array into the text file
			output.write(num[q] + "\n");
		
		output.close();  //complete writing
	}
}

