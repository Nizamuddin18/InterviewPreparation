package com.prep.interview.HashMapFoundation;

import java.util.PriorityQueue;

public class KthLargest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {-1,10,8,9,12,-8,11};
		int size = arr.length;
		int k = 3;
		System.out.println("::::: Kth Largest Element :::::");
		int kthLargestElement = findKthLargestElement(arr, size , k);
		System.out.print("Input : ");
		for(Integer i : arr)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Output :" + kthLargestElement);
	}

	private static int findKthLargestElement(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1);
		for(int i = 0;i<arr.length;i++){
			pq.add(arr[i]);
			if(pq.size() > k){
				pq.remove();
			}
		}
		return pq.peek();
	}

}
