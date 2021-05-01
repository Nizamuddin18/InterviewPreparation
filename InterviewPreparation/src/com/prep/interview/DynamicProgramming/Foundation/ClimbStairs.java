package com.prep.interview.DynamicProgramming.Foundation;
import java.util.*;
public class ClimbStairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 4;
		int cache[] = new int[n+1];
		int totalCountRec = climbStairs(n , cache);
		System.out.println("Total No of Ways through Recursion: " + totalCountRec);
		int totalCountTab = climbStairsTab(n);
		System.out.println("Total No of Ways through Tabulation: " + totalCountTab);
	}
	
	public static int climbStairs(int n , int cache[]){
		if(n == 0) return 1;
		if(n < 0) return 0;
		if(cache[n] != 0) return cache[n];
		int n1 = climbStairs(n-1, cache);
		int n2 = climbStairs(n-2, cache);
		int n3 = climbStairs(n-3, cache);
		int tc = n1+n2+n3;
		cache[n] = tc;
		return cache[n];
	}
	
	public static int climbStairsTab(int n){
		int dp[] = new int[n+1];
		dp[0] = 1;
		for(int i = 1 ; i < dp.length ; i++){
			if(i==1){
				dp[i] = dp[i-1];
			}else if(i==2){
				dp[i] = dp[i-1] + dp[i-2];
			}else{
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
		}
		return dp[n];
	}
}
