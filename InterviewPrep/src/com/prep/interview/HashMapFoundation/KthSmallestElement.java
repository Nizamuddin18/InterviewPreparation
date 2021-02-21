package com.prep.interview.HashMapFoundation;
import java.util.Collections;
import java.util.PriorityQueue;
public class KthSmallestElement {

	public static void main(String[] args) {
		int arr[] = {-1,10,8,9,12,-8,11};
		int size = arr.length;
		int k = 3;
		System.out.println("::::: Kth Smallest Element :::::");
		int kthSmallestElement = findKthSamllestElement(arr, size , k);
		System.out.print("Input  : ");
		for(Integer i : arr)
			System.out.print(i + " ");
		System.out.println();
		System.out.println("Output :" + kthSmallestElement);

	}

	private static int findKthSamllestElement(int[] arr, int size, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k+1,Collections.reverseOrder());
		for(int i = 0 ; i < arr.length ; i++){
			pq.add(arr[i]);
			if(pq.size() > k)
				pq.remove();
		}
		return pq.peek();
	}

}
