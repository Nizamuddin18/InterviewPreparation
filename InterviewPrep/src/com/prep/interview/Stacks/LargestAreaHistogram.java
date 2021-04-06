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
			else if (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				ret_arr[i] = st.peek();
			} else if (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				while (arr[st.peek()] >= arr[i])
					st.pop();
				if (st.isEmpty())
					ret_arr[i] = -1;
				else
					ret_arr[i] = st.peek();
			}
			st.push(i);
		}
		for(int i = 0 ; i < ret_arr.length ; i++){
			System.out.print(ret_arr[i] + " ");
		}
		System.out.println();
		return ret_arr;
	}

	private static int[] getNearestSmallerToRight(int[] arr) {
		// {1,8,6,2,5,4,8,3,7}
		int n = (int) Math.pow(5, 2);
		int ret_arr[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (st.isEmpty())
				ret_arr[i] = -1;
			else if (st.size() > 0 && arr[st.peek()] <= arr[i])
				ret_arr[i] = st.peek();
			else if (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				while (st.size() > 0 && arr[st.peek()] > arr[i])
					st.pop();
				if (st.isEmpty())
					ret_arr[i] = -1;
				else
					ret_arr[i] = st.peek();
			}
			st.push(i);
		}
		for(int i = 0 ; i < ret_arr.length ; i++){
			System.out.print(ret_arr[i] + " ");
		}
		System.out.println();
		return ret_arr;
	}

	private static int[] checkLargestArea(int[] arr, int[] nsr, int[] nsl) {
		int ret_arr[] = new int[arr.length];
		for(int i = 0 ; i < ret_arr.length ; i++){
			ret_arr[i] = (nsr[i] - nsl[i]) - 1;
		}
		for(int i = 0; i < ret_arr.length; i++) {
			ret_arr[i] = ret_arr[i] * arr[i];
		}
		for(int i = 0 ; i < ret_arr.length ; i++){
			System.out.print(ret_arr[i] + " ");
		}
		System.out.println();
		return ret_arr;
	}

	public static void main(String[] args) {
		int arr[] = {6,2,5,4,5,1,6};
		for(int i = 0 ; i < arr.length ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int nsl[] = getNearestSmallerToLeft(arr);
		int nsr[] = getNearestSmallerToRight(arr);
		int res_arr[] = checkLargestArea(arr, nsr, nsl);
		/*
		 * int max = checkMaxFromArea(res_arr);
		 * System.out.println("Max Area Histogram : " + max);
		 */
	}

	private static int checkMaxFromArea(int[] res_arr) {
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < res_arr.length; i++) {
			if (res_arr[i] > max)
				max = res_arr[i];
		}
		return max;
	}

}
