package com.prep.interview.Stacks;

import java.util.Stack;

public class LargestAreaHistogram {
	private static int[] getNearestSmallerToLeft(int[] arr) {
		// {1,8,6,2,5,4,8,3,7}
		int ret_arr[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty())
				ret_arr[i] = -1;
			else if (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				ret_arr[i] = st.peek();
			} else if (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				while (!st.isEmpty() && arr[st.peek()] >= arr[i])
					st.pop();
				if (st.isEmpty())
					ret_arr[i] = -1;
				else
					ret_arr[i] = st.peek();
			}
			st.push(i);
		}
		return ret_arr;
	}

	private static int[] getNearestSmallerToRight(int[] arr) {
		int ret_arr[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.isEmpty())
				ret_arr[i] = arr.length;
			else if (st.size() > 0 && arr[st.peek()] < arr[i])
				ret_arr[i] = st.peek();
			else if (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				while (st.size() > 0 && arr[st.peek()] >= arr[i])
					st.pop();
				if (st.isEmpty())
					ret_arr[i] = arr.length;
				else
					ret_arr[i] = st.peek();
			}
			st.push(i);
		}
		return ret_arr;
	}

	private static int[] nsr(int arr[]) {
		Stack<Integer> st = new Stack<>();
		int res[] = new int[arr.length];
		st.push(0);
		for (int i = 1; i < arr.length; i++) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				res[st.peek()] = arr[i]; // Mark
				st.pop();
			}
			st.push(i);
		}
		while (!st.isEmpty()) {
			res[st.peek()] = -1;
			st.pop();
		}
		System.out.print("NSR2 : ");
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		return res;
	}

	private static int[] nsl(int arr[]) {
		Stack<Integer> st = new Stack<>();
		int res[] = new int[arr.length];
		st.push(arr.length - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				res[st.peek()] = arr[i]; // Mark
				st.pop();
			}
			st.push(i);
		}
		while (!st.isEmpty()) {
			res[st.peek()] = -1;
			st.pop();
		}
		System.out.print("NSL : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
		return res;
	}

	private static int[] checkLargestArea(int[] arr, int[] nsr, int[] nsl) {
		int ret_arr[] = new int[arr.length];
		for (int i = 0; i < ret_arr.length; i++) {
			ret_arr[i] = (nsr[i] - nsl[i]) - 1;
		}
		for (int i = 0; i < ret_arr.length; i++) {
			ret_arr[i] = ret_arr[i] * arr[i];
		}
		return ret_arr;
	}

	private static int checkMaxFromArea(int[] res_arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < res_arr.length; i++) {
			if (res_arr[i] > max)
				max = res_arr[i];
		}
		return max;
	}
	private static void display(int arr[]){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
		System.out.print("INPUT ARRAY : ");
		display(arr);
		int nsr1[] = getNearestSmallerToRight(arr); // getNearestSmallerToRight(arr);
		System.out.println("Nearest Smaller to Right : ");
		display(nsr1);
		int nsl1[] = getNearestSmallerToLeft(arr); //getNearestSmallerToLeft(arr); 
		System.out.println("Nearest Smaller to Left : ");
		display(nsl1);
		int res_arr[] = checkLargestArea(arr, nsr1, nsl1);
		int max = checkMaxFromArea(res_arr); 
		System.out.println("Max Area Histogram : " + max);
	}

}
