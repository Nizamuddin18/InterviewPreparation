package com.prep.interview.DynamicProgramming.Foundation;

public class SubsetSumMemoize {
	static boolean t[][];
	public static boolean subsetSum(int A[], int n, int sum){
		boolean ret_val = false;
		if(sum == 0){	
			return true;
		}
		if(sum!=0 && n==0){
			return false;
		}
		if(A[n-1] <= sum)
			ret_val =  (subsetSum(A,n-1,sum-A[n-1]) ||
					subsetSum(A, n-1, sum));
		else if(A[n-1] > sum)
			ret_val =  subsetSum(A, n-1, sum);
		
		return ret_val;

	}
}
