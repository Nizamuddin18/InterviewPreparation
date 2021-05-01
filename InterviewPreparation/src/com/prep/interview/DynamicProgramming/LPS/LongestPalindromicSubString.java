package com.prep.interview.DynamicProgramming.LPS;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		LongestPalindromicSubString lpss = new LongestPalindromicSubString();
		String str = "frgekkegf";
		int count = lpss.getPlaindromicSubsString(str);
		System.out.println(count);

	}
	public static String reverse(String str){
		String ret = "";
		for(int  i = 0; i < str.length() ; i++){
			char ch = str.charAt(i);
			ret = ch + ret;
		}
		return ret;
	}
	public int getPlaindromicSubsString(String str1){
		String str2 = reverse(str1);
		int m = str1.length();
		int n = str2.length();
		int max = Integer.MIN_VALUE;
		int dp[][] = new int[m+1][n+1];
		for(int i = 1 ; i < dp.length ; i++){
			for(int j = 1 ; j < dp[0].length ; j++){
				
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}else{
					dp[i][j] = 0;
				}
				if(dp[i][j] > max)
					max = dp[i][j];
			}
		}
		return max;
	}

}
