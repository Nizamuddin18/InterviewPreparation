package com.prep.interview.HashMapFoundation;

import java.util.Collection;
import java.util.PriorityQueue;

import java.util.Collections;

public class KSmallestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1,23,12,9,30,2,50};
		int size = arr.length;
		int k = 3;
		findKSmallestElements(arr, size , k);

	}

	private static void findKSmallestElements(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1, Collections.reverseOrder());
		for(int i = 0 ;i < size ; i++){
			if(i < k){
				pq.add(arr[i]);
			}else{
				if(arr[i] < pq.peek()){
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}
		System.out.println("K Smallest Elements :" + pq);
	}

}
