package com.prep.interview.Stacks;

import java.util.Stack;
import java.util.Vector;

public class NearestSmallerToLeft {
	private static void findNearestElementToLeft(int[] arr, int size) {
		Stack<Integer> st = new Stack<Integer>();
		Vector<Integer> v = new Vector<Integer>();
		for(int  i = 0; i<arr.length;i++){
			if(st.isEmpty())
				v.add(-1);
			else if(st.size() > 0 && st.peek() < arr[i])
				v.add(st.peek());
			else if(st.size() > 0 && st.peek() > arr[i]){
				while(st.size() > 0 && st.peek() > arr[i])
					st.pop();
				if(st.isEmpty())
					v.add(-1);
				else
					v.add(st.peek());
			}
			st.push(arr[i]);
		}
		System.out.println("Output : " + v);
	}

	public static void main(String[] args) {
		int arr[] = {1, 6, 4, 10, 2, 5};
		int size = arr.length;
		System.out.println(":::::Nearest Smaller To Left:::::");
		System.out.print("Input : ");
		for(int i =0 ; i< arr.length ; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		findNearestElementToLeft(arr , size);
	}
}
