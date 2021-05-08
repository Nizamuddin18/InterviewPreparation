package com.prep.interview.DynamicProgramming.Foundation;

public class Knapsack01Memoize {
	static int t[][];

	private static int knapSackMemo(int[] wt, int[] val, int Wc, int n) {
		if (n == 0 || Wc == 0)
			return 0;
		if (t[n][Wc] != -1)
			return t[n][Wc];
		if (wt[n - 1] <= Wc) {
			t[n][Wc] = Math.max(val[n - 1] + knapSackMemo(wt, val, Wc - wt[n - 1], n - 1),
					knapSackMemo(wt, val, Wc, n - 1));
			return t[n][Wc];
		} else {
			t[n][Wc] = knapSackMemo(wt, val, Wc, n - 1);
			return t[n][Wc];
		}
	}

	public static void main(String[] args) {
		int wt[] = { 1, 3, 4, 5 };
		int val[] = { 1, 4, 5, 7 };
		int Wc = 7;
		int n = wt.length;
		t = new int[n + 1][Wc + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < Wc + 1; j++) {
				t[i][j] = -1;
			}
		}
		int maxProfit = knapSackMemo(wt, val, Wc, n);
		System.out.println("Max Profit=" + maxProfit);

	}

}
