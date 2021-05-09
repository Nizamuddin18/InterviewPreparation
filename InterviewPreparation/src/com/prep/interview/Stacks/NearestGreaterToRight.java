package com.prep.interview.Stacks;
import java.util.*;
public class NearestGreaterToRight {
	private static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int[] getNearestToRight(int arr[]){
		int res[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for(int i = arr.length-1 ; i >=0 ; i--){
			if(st.isEmpty()){
				res[i] = -1;
			}else if(!st.isEmpty() && st.peek() > arr[i]){
				res[i] = st.peek();
			}else if(!st.isEmpty() && st.peek() <= arr[i]){
				while(!st.isEmpty() && st.peek() <= arr[i]){
					st.pop();
				}
				if(st.isEmpty()){
					res[i] = -1;
				}else{
					res[i] = st.peek();
				}
			}
			st.push(arr[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,3,0,0,1,2,4};
		System.out.println("Input Array : ");
		display(arr);
		int res[] = getNearestToRight(arr);
		System.out.println("Nearest Greater Element To Right : ");
		display(res);
	}
}
