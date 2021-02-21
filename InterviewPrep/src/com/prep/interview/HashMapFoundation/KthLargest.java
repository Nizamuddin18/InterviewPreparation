package com.tcs.Practice.Heap;

import java.util.PriorityQueue;

public class KthLargest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {-1,10,8,9,12,-8,11};
		int size = arr.length;
		int k = 3;
		int kthLargestElement = findKthLargestElement(arr, size , k);
		System.out.println("Kth Largest Element :" + kthLargestElement);
	}

	private static int findKthLargestElement(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0;i<arr.length;i++){
			pq.add(arr[i]);
			if(i >= k){
				pq.remove();
			}
		}
		return pq.peek();
	}

}
