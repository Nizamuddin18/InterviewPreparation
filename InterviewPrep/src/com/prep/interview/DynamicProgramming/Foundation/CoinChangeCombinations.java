package com.prep.interview.DynamicProgramming.Foundation;

public class CoinChangeCombinations {

	public static void main(String[] args) {
		int coins[] = {3,5,10};
		int sum = 20;
		int dp[] = new int[sum+1];
		dp[0] = 1;
		for(int i = 0 ; i < coins.length; i++){
			for(int j = coins[i] ; j < dp.length ; j++){
				if(coins[i] <= j){
					dp[j] = dp[j] + dp[j-coins[i]];
				}
			}
		}
		System.out.print("COIN CHANGE COMBINATIONS : " + dp[sum]);
	}

}
