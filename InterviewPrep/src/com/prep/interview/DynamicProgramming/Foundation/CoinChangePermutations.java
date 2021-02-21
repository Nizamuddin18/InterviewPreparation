package com.prep.interview.DynamicProgramming.Foundation;

public class CoinChangePermutations {

	public static void main(String[] args) {
		int coins[] = {2,3,5,6};
		int sum = 10;
		int dp[] = new int[sum+1];
		dp[0] = 1;
		for(int amt = 1 ; amt < dp.length ; amt++){
			for(int j = 0 ; j < coins.length ; j++){
				if(coins[j] <= amt){
					dp[amt] = dp[amt] + dp[amt-coins[j]];
				}
			}
		}
		System.out.println("COIN CHANGE PERMUTATIONS : " + dp[sum]);
	}
}
