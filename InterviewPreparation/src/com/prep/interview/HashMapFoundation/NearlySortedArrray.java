package com.prep.interview.HashMapFoundation;

import java.util.PriorityQueue;

public class NearlySortedArrray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {6,5,3,2,8,10,9};
		int size = arr.length;
		int k = 3;
		System.out.print("Input : ");
		for(int i = 0; i< arr.length; i++)
			System.out.print(arr[i]+" ");
		int res_arr[] = kSortedArray(arr, size , k);
		System.out.println();
		System.out.print("Output : ");
		for(int i = 0; i< res_arr.length; i++)
			System.out.print(res_arr[i]+" ");
	}

	private static int[] kSortedArray(int[] arr, int size, int k) {
		int pos = 0;
		int val;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i< size ; i++){
			pq.add(arr[i]);
			if(i >= k){
				val = pq.remove();
				arr[pos++] = val;
			}
		}
		while(pq.size() > 0){
			val = pq.remove();
			arr[pos++] = val;
		}
		return arr;
	}

}
