package com.prep.interview.DynamicProgramming.Foundation;

public class CoinChangeMinimumCoins {
	private static int getMinNoOfWays(int[] coins, int length, int sum) {
		int dp[][] = new int[length + 1][sum +1];	
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= sum ; i++)
			dp[0][i] = min;
		for(int  i = 1 ; i<= length ; i++){
			for(int j = 1 ; j <= sum ; j++){
				if(coins[i-1] <= j){
					//min of including the current coin value or excluding the current coin value
					dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1 , 
								dp[i-1][j]);
				}else{
					dp[i][j] = dp[i-1][j];	
				}
			}
		}
		return dp[length][sum];
	}
	
	public static void main(String[] args) {
		int coin[] = {2,3,5,6};
		int length = coin.length;
		int sum = 7;
		int minNo = getMinNoOfWays(coin , length , sum);
		System.out.println("The Minimum No of Coins required : " + minNo);
	}
}
