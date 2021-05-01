package com.prep.interview.DynamicProgramming.LPS;

public class LongestPalindromicSubsequence {
	
	public int getPalindromicSubSequence(String str1){
		String str2 = reverse(str1);
		int m = str1.length();
		int n = str2.length();
		int dp[][] = new int[m+1][n+1];
		
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	
	public static String reverse(String str){
		String ret = "";
		for(int i = 0 ; i < str.length() ; i++){
			char ch = str.charAt(i);
			ret = ch + ret;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String str1 = "ccbbgd";
		int count = lps.getPalindromicSubSequence(str1);
		System.out.println("LONGEST PALINDROMIC SUBSEQUENCE : " + count);
	}
	

}
