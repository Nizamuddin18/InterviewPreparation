package com.tcs.Practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;


class Pair implements Comparable<Pair>{
	int val;
	int index;
	public Pair(int val, int index) {
		super();
		this.val = val;
		this.index = index;
	}
	public Pair(){
		
	}
	
	
	@Override
	public String toString() {
		return "[index=" + index + "]";
	}
	@Override
	public int compareTo(Pair p) {
		if(this.val > p.val)
			return 1;
		else if(this.val < p.val)
			return -1;
		else
			return 0;
	}

}

public class KClosestElements {

	public static void main(String[] args) {
		int arr[] = {5,6,7,8,9,10};
		int size = arr.length;
		int k = 3;
		int x = 7;
		kClosestElements(arr, size , k , x);
	}

	private static void kClosestElements(int[] arr, int size, int k , int x) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k+1 , Collections.reverseOrder());
		for(int i = 0 ; i< size ; i++){
			pq.add(new Pair(Math.abs(x-arr[i]), arr[i]));
			if(pq.size() > k)
				pq.poll();
		}
		while(!pq.isEmpty()){
			System.out.println(pq.poll()+" ");
		}
		
	}

}
