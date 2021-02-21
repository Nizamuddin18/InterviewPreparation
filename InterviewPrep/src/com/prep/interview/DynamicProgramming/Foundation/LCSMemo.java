package com.tcs.Practice;
public class LCSMemo {
	static int t[][];
	private int getLCSMemo(String x, String y, int m, int n) {
		t = new int[m+1][n+1];
		for(int i=1; i<= m; i++){
			for(int j =1; j<=n; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					t[i][j] = 1+ t[i-1][j-1];
				}
				else{
					t[i][j] = Math.max(t[i][j-1], 
							t[i-1][j]);
				}
			}
		}
		return t[m][n];
	}
	private int getLCSubstringMemo(String x, String y, int m, int n) {
		t = new int[m+1][n+1];
		for(int i=1; i<= m; i++){
			for(int j =1; j<=n; j++){
				if(x.charAt(i-1) == y.charAt(j-1)){
					t[i][j] = 1+ t[i-1][j-1];
				}
				else{
					t[i][j] = 0;
				}
			}
		}
		int max = checkMax(t, m, n);
		return max;
	}
	private static int checkMax(int[][] t2, int m, int n) {
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i<=m; i++){	
			for(int j=1; j<=n; j++){
				if(t2[i][j] > max)	
					max = t[i][j];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		LCSMemo lcsmemo = new LCSMemo();
		String x = "abcde";
		String y = "abfcd";
		int m = x.length();
		int n = y.length();
		int ret_ans = lcsmemo.getLCSMemo(x, y , m, n);
		int ret_ans_ss = lcsmemo.getLCSubstringMemo(x, y , m, n);
		System.out.println("Length of Longest common subsequence: "+ret_ans);
		System.out.println("Length of Longest common Substring: "+ret_ans_ss);
	}

}
