package com.prep.interview.DynamicProgramming.LCS;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int arr[] = {10,22,9,33,21,50,41,60,80,3};	
		int count = getLongestIncreasingSubsequence(arr);
		System.out.println("LONGEST INCREASING SUBSEQUENCE : " + count);
	}

	public static int getLongestIncreasingSubsequence(int arr[]){
		int n = arr.length;
		int dpMax = Integer.MIN_VALUE;
		int dp[] = new int[n];
		for(int i = 0 ; i < dp.length ; i++){
			int max = 0;
			for(int j = 0 ; j < i ; j++){
				if(arr[j] < arr[i]){
					if(max < dp[j]){
						max = dp[j];
					}
				}
			}
			dp[i] = max + 1;
			if(dpMax < dp[i]){
				dpMax = dp[i];
			}
		}
		return dpMax;
	}
}
