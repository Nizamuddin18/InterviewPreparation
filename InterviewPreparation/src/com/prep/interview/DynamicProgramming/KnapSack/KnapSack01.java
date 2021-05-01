package com.prep.interview.DynamicProgramming.KnapSack;

public class KnapSack01 {
	static int t[][];
	public int getKnapSack(int wt[] , int val[] , int length, int wc){
		t = new int[length+1][wc+1];	
		for(int i=1;i<length+1;i++){
			for(int j=1;j<wc+1;j++){
				if(wt[i-1]<=j)  // if the selected weight is less than the Current Weight of Knapsack(j)
				{
					t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]],   //check among them whether to include the weight or not
							t[i-1][j]);
				}
				else	
					t[i][j]  = t[i-1][j];
			}
		}
		return t[length][wc];
	}
}
