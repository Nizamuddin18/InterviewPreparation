package com.prep.interview.Foundation.Pattern;

public class Pattern16 {
	private static void printPatternUsingStarSpace(int n) {
		int nsp = (3*n+1)/2;
		int nst = 1;
		int count;
		for(int i = 0 ; i < n ; i++){
			count = 1;
			for(int st = 0 ; st < nst ; st++){
				System.out.print(count++ + "\t");
			}
			for(int sp = 0 ; sp < nsp ; sp++){
				System.out.print("\t");
			}
			if(i == n-1){
				for(int st = 0 ; st < nst-1 ; st++){
					System.out.print(count++ + "\t");
				}	
			}else{
				for(int st = 0 ; st < nst ; st++){
					System.out.print(count++ + "\t");
				}
			}
			
			nsp = nsp - 2;
			nst++;
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = 7;
		printPatternUsingStarSpace(n);
	}

}
