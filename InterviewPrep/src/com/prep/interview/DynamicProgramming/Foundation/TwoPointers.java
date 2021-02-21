/**
 * 
 */
package com.tcs.Practice;

/*
 *Given a sorted array A (sorted in ascending order), having N integers,
find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X

*/
public class TwoPointers {
	public static void main(String[] args) {
		int x = 70;
		int a[] = {10,20,35,50,75,80};
		boolean isTwoPointers = findTwoPointers(a,x);
		System.out.println(isTwoPointers);
		
	}

	private static boolean findTwoPointers(int[] a, int x) {
		boolean status = false;
		int i = 0;
		int j = a.length -1;
		
		while(i < j){
			if(a[i] + a[j] == x){
				status = true;
				break;
			}
				
			else if(a[i] + a[j] < x)
				i++;
			else if(a[i] + a[j] > x)
				j--;
			
		}
		return status;
	}

}
