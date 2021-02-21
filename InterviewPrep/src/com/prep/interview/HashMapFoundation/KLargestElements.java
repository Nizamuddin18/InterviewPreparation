package com.tcs.Practice.Heap;

import java.util.PriorityQueue;

public class KLargestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1,23,12,9,30,2,50};
		int size = arr.length;
		int k = 3;
		findKLargestElements(arr, size , k);
	}

	private static void findKLargestElements(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0;i<size;i++){	
			if(i < k){
				pq.add(arr[i]);
			}else{
				if(arr[i] > pq.peek()){
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		System.out.println("K largest Elements : " + pq);
	}

}
