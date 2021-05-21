package com.prep.interview.Foundation.SearchingSorting;

import java.util.Arrays;

public class QuickSelect {
	// quick select main logic where kth smallest no is returned
	public static int quickSelect(int[] arr, int lo, int hi, int k) {
		if(k < 0) return -1;
		int pivot = arr[hi];
		int pi = partition(arr, pivot, lo, hi);
		int ans;
		if (pi == k) {
			// Partition Index is equal to Kth Element
			ans = pivot;
		} else if (pi > k) {
			// k lesser than partition Index , then we check left side of
			// Partitioned Array
			ans = quickSelect(arr, lo, pi - 1, k);
		} else {
			// k is greater than partition Index , then we check right side of
			// Partitioned Array
			ans = quickSelect(arr, pi + 1, hi, k);
		}
		return ans;
	}

	// used to partition based on pivot element
	public static int partition(int[] arr, int pivot, int lo, int hi) {
		int i = lo, j = lo;
		while (i <= hi) {
			if (arr[i] <= pivot) {
				swap(arr, i, j);
				i++;
				j++;
			} else {
				i++;
			}
		}
		// System.out.println("pivot index -> " + (j - 1));
		return (j - 1);
	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//display
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = {17, 89, 14, 8, 13, 36, 25, 71, 30 };
		int k = 4;
		System.out.print("Input Array  : ");
		print(arr);
		int ans = quickSelect(arr, 0, arr.length - 1, k - 1);
		System.out.print("Output Array : ");
		print(arr);
		String appendix = checkAppendix(k);
		System.out.println(k + appendix + " smallest element is : " + ans);
	}

	private static String checkAppendix(int k) {
		if(k == 1) return "st";
		if(k == 2) return "nd";
		if(k == 3) return "rd";
		if(k <= 0 || k > 3) return "th";
		return "";
	}
}
