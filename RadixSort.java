/*
	RadixSort.java
	Author: Aileen L. Cai
	Data Structures and Algorithms
	Practice Assignment 05
	February 27, 2020
*/

import java.io.*;
import java.util.*;

public class RadixSort
{
	public static int maxValue(int arr[], int n)  //used to discover what the max # of digits in a value from array
	{
		int max = arr[0];
		for (int q = 1; q < n; q++)
			if (arr[q] > max)
				max = arr[q];
		return max;
	}
	public static void countSort(int [] arr, int n, int j)
	{
		int finalArray [] = new int [n]; //creating a final array that will hold all these values 
		int index;
		int count[] = new int[10]; //creating a count array that will keep track of the # of instances of values 0-9 

		Arrays.fill(count, 0); //initial value at every index is 0

		for (index = 0; index < n; index++)
			count[(arr[index]/j)%10]++;   //loops through array to count how many instances of 0-9 there are in the right most digit in the original array

		for (index = 1; index < 10; index++)
			count[index] += count[index-1];  //moving count[i] to where it's actual position is in finalArray

		for (index = n-1; index >=0; index--)
		{
			finalArray[count[(arr[index]/j)%10] - 1] = arr[index];   //sorting the values into the final array
			count[(arr[index]/j)%10]--;   //decrementing the values in counting array as the final array is getting sorted
		}

		for(index = 0; index < n; index++)    //copying the final array into the original array
			arr[index] = finalArray[index];  //numnbers are sorted 
	}

	public static void radixSort(int arr[], int n)
	{
		int max = maxValue(arr, n); //calculating what the max digits are in a given value in the array 

		for (int j = 1; max/j > 0; j*=10)  //running countSort from right digit to left digit to sort every value in array
			countSort(arr, n, j);
	}


}
