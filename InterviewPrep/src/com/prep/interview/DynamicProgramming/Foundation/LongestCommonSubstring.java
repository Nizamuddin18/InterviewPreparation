package com.prep.interview.DynamicProgramming.Foundation;

public class LongestCommonSubstring {
	static int t[][];
	int getLowestCommonSubString(String a, String b, int m, int n){
		t = new int [m+1][n+1];
		int max;
		for(int i=1 ; i<=m ; i++){
			for( int j =1 ; j<= n ; j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					t[i][j] = 1+ t[i-1][j-1];
				}
				else{
					t[i][j]  = 0;
				}
			}
		}
		max = getMax(t, m , n);
		return max;
	}
	
	private static int getMax(int[][] t2, int m, int n) {
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i<= m ; i++){
			for(int j =0 ; j<=n ; j++){
				max= Math.max(max, t[i][j]);
			}
		}
		return max;
	}
}
