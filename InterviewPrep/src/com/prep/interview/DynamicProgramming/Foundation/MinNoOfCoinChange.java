package com.tcs.Practice;

public class MinNoOfCoinChange {
	static int t[][];
	private static int getMinNoOfWays(int[] coin, int length, int sum) {
		t = new int[length + 1][sum +1];	
		int max = 9999;
		for(int i = 0; i <= sum ; i++)
			t[0][i] = max;
		for(int  i = 1 ; i<= length ; i++){
			for(int j = 1 ; j <= sum ; j++){
				if(coin[i-1] <= j){
					t[i][j] = Math.min(t[i-1][j], 
							t[i][j-coin[i-1]] + 1);
				}else{
					t[i][j] = t[i-1][j];	
				}
			}
		}
		return t[length][sum];
	}
	public static void main(String[] args) {
		int coin[] = {1, 2, 7};
		int length = coin.length;
		int sum = 25;
		int minNo = getMinNoOfWays(coin , length , sum);
		System.out.println("The Minimum No of Coin Change Possible : " + minNo);

	}

	

}
