package com.prep.interview.DynamicProgramming.UnboundedKnapsack;

public class MaxNoOfWaysCoinChange {
	public int getMaxNoOfWays(int[] coin, int sum, int length) {
		int t[][] = new int[length + 1][sum + 1];
		for (int i = 0; i <= length; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0)
					t[i][j] = 1;
			}
		}

		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coin[i - 1] <= j) {
					t[i][j] = t[i - 1][j] + t[i][j - coin[i - 1]];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[length][sum];
	}
}
