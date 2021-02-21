package com.prep.interview.DynamicProgramming.Foundation;

public class ShortestCommonSuperSequence {
	int getCommonSuperSequence(String a, String b, int m, int n){
		LongestCommonSubsequence longestcommonsubsequence = new LongestCommonSubsequence();
		int lcs = longestcommonsubsequence.getLCS(a, b, m, n);
		int ret_num = (m + n) - lcs;
		return ret_num;
	}
}
