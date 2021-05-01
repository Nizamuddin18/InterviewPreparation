package com.prep.interview.DynamicProgramming.KnapSack;

public class CountSubsetSum {
	static int t[][];
	public int getCountOfSubset(int wt[] , int length , int sum){
		t = new int[length +1][sum+1];
		for(int i = 0; i<= length ; i++)
			t[i][0] = 1;
		
		for(int i=1;i<=length ; i++){
			for(int j=1; j<=sum; j++)
			{
				if(wt[i-1] <= j){
					t[i][j] = t[i-1][j] + t[i-1][j-wt[i-1]];
					}
				else
					t[i][j] = t[i-1][j];
			}
		}	
		return t[length][sum];
	}

}
