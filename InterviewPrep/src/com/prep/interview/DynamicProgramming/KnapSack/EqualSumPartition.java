package com.prep.interview.DynamicProgramming.KnapSack;

public class EqualSumPartition {
	public boolean isSumEven(int sum){
		if(sum%2==0)
			return true;
		else
			return false;
	}
	
	public boolean getEqualSumPartition(int wt[] , int length , int sum){
		SubsetSum s = new SubsetSum();
		boolean ret_val = s.getSubSet(wt, length, sum);
		return ret_val;
	}
	
}
