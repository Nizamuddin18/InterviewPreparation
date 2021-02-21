package com.prep.interview.DynamicProgramming.KnapSack;

public class SubsetSum {
	static boolean t[][];
	public boolean getSubSet(int arr[] , int length , int sum){
		t = new boolean[length +1][sum +1];
		for(int i = 0 ; i<=length ; i++)
			t[i][0] = true;
		for(int i = 1; i<= length ; i++){
			for(int j = 1 ; j<=sum ; j++){
				if(arr[i-1] <= j)
					t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[length][sum];
	}
}
