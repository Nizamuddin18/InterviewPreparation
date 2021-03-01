/**
 * 
 */
package com.prep.interview.DynamicProgramming.Foundation;
/*
	You are given an array arr[] of size n with duplicate elements, 
	write a program to remove all duplicates from the array, 
	and return the size of the new array.
	
	Input: arr[] = [-1,0,1,1,2,9,9]
	Output: 5
	Explanation: The new array will be [-1,0,1,2,9] i.e. having length 5.
*/

public class RemoveDuplicates {

	public static void main(String[] args) {
		int arr[] = {-1,0,1,1,2,9,9};
		System.out.print("Input : ");
		for(int i = 0; i< arr.length ; i++)
			System.out.print(arr[i] + " ");
		int res = removeDuplicates(arr);
		System.out.println();
		System.out.print("Output : ");
		for(int i =0 ;i < res;i++)
			System.out.print(arr[i]+" ");
	}

	private static int removeDuplicates(int[] arr) {
		int i = 0;
		for(int j = 1; j< arr.length ; j++){
			if(arr[i] != arr[j]){
				i++;
				arr[i] = arr[j];
			}
				
		}
		return (i+1);
	}

}
