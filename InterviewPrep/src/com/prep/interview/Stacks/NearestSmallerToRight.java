package com.prep.interview.Stacks;

import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class NearestSmallerToRight {

	private static void findNearestElementToRight(int[] arr, int size) {
		Stack<Integer> st = new Stack<Integer>();
		Vector<Integer> v = new Vector<Integer>();
		for(int i =arr.length - 1; i>=0;i--){
			if(st.isEmpty())
				v.add(-1);
			else if(st.size() > 0 && arr[st.peek()] < arr[i])
				v.add(st.peek());
			else if(st.size() > 0 && arr[st.peek()] > arr[i]){
				while(st.size() > 0 && arr[st.peek()]> arr[i])
					st.pop();
				if(st.isEmpty())
					v.add(-1);
				else
					v.add(st.peek());
			}
			st.push(i);
		}
		Collections.reverse(v);
		System.out.println("Output : " + v);
	}
	public static void main(String[] args) {
		int arr[] = {1,8,6,2,5,4,8,3,7};
		int size = arr.length;
		System.out.println(":::::Nearest Smaller To Right:::::");
		System.out.print("Input : ");
		for(int i =0 ; i< arr.length ; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		findNearestElementToRight(arr , size);	
	}

	

}
