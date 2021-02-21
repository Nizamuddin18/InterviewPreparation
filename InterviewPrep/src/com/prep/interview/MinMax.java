package com.prep.interview;

public class MinMax {

	public static void main(String[] args) {
		int arr[] = {9,10,8,7,-5,-8,6,11};
		int min,max;
		min = findMin(arr);
		System.out.println("MIN ELEMENT IS: "+min);
		max = findMax(arr);
		System.out.println("MAX ELEMENT IS: "+max);
		System.out.println("MIN ELEMENT INDEX:"+findIndex(min,arr));
		System.out.println("MIN ELEMENT INDEX:"+findIndex(max,arr));
	}

	private static int findIndex(int var,int[] arr) {
		boolean flag = false;
		int i;
		for(i=0;i<arr.length;i++){
			if(arr[i]==var){
				flag = true;
				break;
			}
				
		}
		if(flag)
			return(i+1);
		else
			return -1;
	}

	private static int findMax(int[] arr) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}

	private static int findMin(int[] arr) {
		int min = arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<min)
				min = arr[i];
		}
		return min;
	}

}
