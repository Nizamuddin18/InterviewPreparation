package com.prep.interview.leetcode;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {

	public static void main(String[] args) {
	long start = System.nanoTime();
	int arr [] = {3,2,1,5,6,4};
	int length = arr.length;
	int k = 3;
	PriorityQueue <Integer> minHeap = new PriorityQueue<Integer>();
	for(int i = 0 ; i< length ; i++){
		if(i >=k){
			minHeap.remove();
		}
		minHeap.add(arr[i]);
	}
	System.out.println("kth Largest Element : " + minHeap.poll());
	long end = System.nanoTime();
	NumberFormat formatter = new DecimalFormat("#0.00000");
	System.out.println("Execution time is " + formatter.format((end - start) / 100000000d) + " seconds");	
	start = System.nanoTime();
	int arr1 [] = {3,2,1,5,6,4};
	Arrays.sort(arr1);
	System.out.println("kth Largest Element : " + arr1[arr1.length - k]);
	end = System.nanoTime();
	formatter = new DecimalFormat("#0.00000");
	System.out.print("Execution time is " + formatter.format((end - start) / 100000000d) + " seconds");	
	
	}

}
