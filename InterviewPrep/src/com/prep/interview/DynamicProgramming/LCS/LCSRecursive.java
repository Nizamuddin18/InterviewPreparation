package com.prep.interview.DynamicProgramming.LCS;
import java.util.*;
public class LCSRecursive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LCSRecursive lcs = new LCSRecursive();
		LCSMemoize lcsmemo = new LCSMemoize();
		LongestCommonSubSequence lcstab = new LongestCommonSubSequence();
		String x = "abcdgh";
		String y = "abedfhr";
		int m = x.length();
		int n = y.length();
		int dp[][] = new int[m+1][n+1];
		System.out.println("1. LCS Recursive ");
		System.out.println("2. LCS Memoize ");
		System.out.println("3. LCS Tabulation ");
		int choice = sc.nextInt();
		switch(choice){
		case 1 : 
			int count = lcs.getLCS(x , y , m , n);
			System.out.println("Longest Common Subsequence Recursive : " + count);
			break;
		case 2 : 
			for(int i = 0 ; i < dp.length ; i++){
				for(int j = 0 ; j < dp[0].length ; j++){
					dp[i][j] = -1;
				}
			}
			int memo = lcsmemo.getLCSMemoize(x, y, m, n, dp);
			System.out.println("Longest Common Subsequence Memoize : " + memo);
			break;
		case 3 :
			int tabulation = lcstab.getLCSTabulation(x, y, m, n, dp);
			System.out.println("Longest Common Subsequence Tabulation : " + tabulation);
			break;
		case 4 :
			break;
		default : 
			System.exit(0);
		}
	}
	
	public int getLCS(String x ,String y,int m , int n){
		if(m == 0 || n == 0)
			return 0;
		if(x.charAt(m-1) == y.charAt(n-1)){
			return 1+getLCS(x , y , m-1 , n-1);
		}else{
			return (Math.max(getLCS(x , y , m-1 , n), 
					getLCS(x , y , m , n-1)));
		}
	}
}
