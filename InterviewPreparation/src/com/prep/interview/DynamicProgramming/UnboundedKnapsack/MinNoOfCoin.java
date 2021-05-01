package com.prep.interview.DynamicProgramming.UnboundedKnapsack;

public class MinNoOfCoin {
	static int t[][];
	public int getMinimumNoPossible(int coin[] , int length , int sum){
		t = new int[length + 1][sum +1];	
		int max = Integer.MAX_VALUE;
		for(int i = 0; i <= sum ; i++)
			t[0][i] = max-1;
		for(int  i = 1 ; i<= length ; i++){
			for(int j = 1 ; j <= sum ; j++){
				if(coin[i-1] <= j){
					t[i][j] = Math.min(t[i-1][j], 
							t[i][j-coin[i-1]] + 1);
				}else{
					t[i][j] = t[i-1][j];	
				}
			}
		}
		return t[length][sum];
	}
}
