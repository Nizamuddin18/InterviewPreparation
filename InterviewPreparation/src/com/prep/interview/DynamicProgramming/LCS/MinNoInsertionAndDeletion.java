package com.prep.interview.DynamicProgramming.LCS;

public class MinNoInsertionAndDeletion {

	public static void main(String[] args) {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		String str1 = "heap";
		String str2 = "pea";
		int m = str1.length();
		int n = str2.length();
		int dp[][] = new int[m+1][n+1];
		int count = lcs.getLCSTabulation(str1, str2, m, n, dp);
		int insertion = Math.abs(m - count);
		int deletion = Math.abs(n - count);
		System.out.println("MIN NO OF INSERTION : " + insertion);
		System.out.println("MIN NO OF DELETION : " + deletion);

	}

}
