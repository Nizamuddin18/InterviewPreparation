package com.prep.interview.DynamicProgramming.CatalanNumber;
import java.util.*;
public class CountValidParenthesis {

	public static void main (String[] args) {
			Scanner sc = new Scanner(System.in);
			long dp[];
			System.out.println("Enter n :");
		    int n = sc.nextInt();
		    dp = new long[n+1];
		    dp[0] = 1;
		    dp[1] = 1;
		    for(int i = 2 ; i < dp.length ; i++){
		        int inside = i-1;
		        int outside = 0;
		        while(inside >= 0){
		            dp[i] += dp[inside] * dp[outside];
		            inside--;
		            outside++;
		        }
		    }
		    System.out.println(dp[n]);
		
	}
}
