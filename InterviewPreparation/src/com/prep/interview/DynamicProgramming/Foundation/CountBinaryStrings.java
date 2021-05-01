package com.prep.interview.DynamicProgramming.Foundation;

public class CountBinaryStrings {

	public static void main(String[] args) {
		int n = 6; // binary String of length n
		int inc = 1;
		int exc = 1;
		for(int i = 2 ; i <= n ; i++){
			int ninc = exc;
			int nexc = inc + exc;
			
			inc = ninc;
			exc = nexc;
		}
		System.out.println("BINARY STRINGS WITH NO CONSECUTIVE O's OF LENGTH " + n + " IS "+ (inc + exc));
	}

}
