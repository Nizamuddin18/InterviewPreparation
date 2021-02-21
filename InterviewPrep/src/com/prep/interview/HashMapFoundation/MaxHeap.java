package com.prep.interview.HashMapFoundation;

public class MaxHeap {
	
	private static void max_Heapify(int[] arr, int i, int length) {
		int left = 2*i + 1;
		int right = 2*i + 2;
		int largest = i;
		int temp;
		if(left < length && arr[left] > arr[largest]){
			largest = left;
		}
		if(right < length && arr[right] > arr[largest])
			largest = right;
		if(largest != i){
			temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			max_Heapify(arr, largest , length);
		}
		
	}
	private static void buildMaxHeap(int[] arr, int length) {
		int startIndex = (length/2) - 1;
		for(int i = startIndex; i >= 0; i--){
			max_Heapify(arr, i, length);
		}
		
	}
	
	static void printHeap(int arr[], int n) 
    { 
        System.out.println("Array representation of Heap is:"); 
  
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
  
	public static void main(String[] args) {
		int arr[] = {4,10,3,5,1};
		int length = arr.length;
		System.out.print("Before BuildHeap====");
		printHeap(arr, length);
		System.out.print("After BuildHeap====");
		buildMaxHeap(arr, length);
		printHeap(arr, length);
	}

	

}
