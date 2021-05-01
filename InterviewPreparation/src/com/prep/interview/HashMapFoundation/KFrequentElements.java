package com.prep.interview.HashMapFoundation;

import java.util.HashMap;
import java.util.PriorityQueue;
class PairofFrequentElements implements Comparable<PairofFrequentElements>{
	int key;
	int frequency;
	public PairofFrequentElements(int key , int frequency){
		this.key = key;
		this.frequency = frequency;
	}
	public PairofFrequentElements(){
		
	}

	@Override
	public String toString() {
		return "[" + key + "]";
	}
	@Override
	public int compareTo(PairofFrequentElements p) {
		if(this.frequency > p.frequency)
			return 1;
		else if(this.frequency < p.frequency)
			return -1;
		else
			return 0;
	}
}
public class KFrequentElements {

	private static void findKFrequentElements(int[] arr, int k, int length) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int  i = 0;i<length ; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
			}else{
				map.put(arr[i], 1);
			}	
		}
		PriorityQueue<PairofFrequentElements> pq = new PriorityQueue<PairofFrequentElements>();
		int j = 0;
		for(Integer i : map.keySet()){
			pq.add(new PairofFrequentElements(i , map.get(i)));
			j++;
			if(j > k)
				pq.remove();
		}
		
		System.out.println("Top " + k + " Frequent Elements : " + pq);
	}
	public static void main(String[] args) {
		int arr[] = {1,1,1,3,2,4,4};
		int k = 2;
		System.out.println(":::::Kth Frequent Elements:::::");
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		findKFrequentElements(arr,k,arr.length);
	}
}
