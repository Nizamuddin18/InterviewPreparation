package com.prep.interview.DynamicProgramming.LCS;

public class LongestCommonSubSequence {
	public int getLCSTabulation(String x , String y, int m , int n , int dp[][]){
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
}
