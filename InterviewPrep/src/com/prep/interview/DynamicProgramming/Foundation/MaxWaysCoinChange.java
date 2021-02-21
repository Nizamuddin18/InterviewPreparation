package com.tcs.Practice;

public class MaxWaysCoinChange {
	static int t[][];
	private static int getMaxNoOfWays(int[] coin, int sum, int length) {
		t = new int[length + 1][sum +1];	
		for(int  i =0 ; i<= length ; i++){
			for(int j = 0 ; j <= sum ; j++){
				if(j == 0)
					t[i][j] = 1; 	
			}
		}
		
		for(int  i = 1 ; i<= length ; i++){
			for(int j = 1 ; j <= sum ; j++){
				if(coin[i-1] <= j){
					t[i][j] = t[i-1][j] +
							  t[i][j-coin[i-1]];
				}else{
					t[i][j] = t[i-1][j];	
				}
			}
		}
		return t[length][sum];
	}
	public static void main(String[] args) {
		int coin[] = {1,2,3};
		int sum = 5;
		int length = coin.length;
		int maxWays = getMaxNoOfWays( coin , sum , length);
		System.out.println("Maximum No of Ways : " + maxWays);

	}


}
