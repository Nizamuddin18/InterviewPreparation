package com.prep.interview.Foundation.Recursion;

public class TowerOfHanoi {
	private static void printTowerOfHanoi(int n, char src, char dest, char helper) {
		if(n == 0) return;
		printTowerOfHanoi(n-1 , src , helper , dest);
		System.out.println("Move disc " + n + " from " + src + " to " + dest);
		printTowerOfHanoi(n-1 , helper , dest , src);
	}
	
	public static void main(String[] args) {
		int n = 3;
		printTowerOfHanoi(n , 'A' , 'B' , 'C');
	}
}
