package com.prep.interview.DynamicProgramming.Foundation;
import java.util.*;

public class MinimumCostPath {

	private static void printMazePaths(int arr[][] , int srow , int scol , int drow , int dcolumn , String psf , int count , int min){
		if(srow == drow && scol == dcolumn){
			if((count + arr[drow][dcolumn]) < min)
				min = (count + arr[drow][dcolumn]);
			System.out.print(psf + arr[drow][dcolumn] + " and Count - > " + (count + arr[drow][dcolumn]));
			System.out.println();
			return;
		}
		if(scol < dcolumn)
			printMazePaths(arr , srow , scol+1 , drow , dcolumn , psf+Integer.toString(arr[srow][scol]) , count + arr[srow][scol] , min);
		if (srow < drow)
			printMazePaths(arr , srow+1 , scol, drow , dcolumn , psf+Integer.toString(arr[srow][scol]) , count + arr[srow][scol] , min);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[][] = {{1,2,3},{4,8,2},{1,5,3}};
		int srow = 0; 
		int scol = 0;
		int drow = 3;
		int dcolumn = 2;
		//printMazePaths(arr , srow , scol , drow , dcolumn , "" , 0 , Integer.MAX_VALUE);
		//display(arr);
		getMinimumCost(arr , drow, dcolumn);

	}

	
	private static void display(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;

		for(int i = 0 ; i < m ; i++){
			for(int j = 0 ; j < n ; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void getMinimumCost(int[][] arr, int drow, int dcolumn) {
		// TODO Auto-generated method stub
		int m = arr.length;
		int n = arr[0].length;
		int dp[][] = new int[m][n];
		for(int i = dp.length - 1 ; i >= 0 ; i--){
			for(int j = dp[0].length-1 ; j >= 0 ; j--){
				if(i == dp.length-1 && j == dp[0].length-1){
					dp[i][j] = arr[i][j];
				}else if(i == dp.length-1){
					dp[i][j] = dp[i][j+1] + arr[i][j];
				}else if(j == dp[0].length-1){
					dp[i][j] = dp[i+1][j] + arr[i][j];
				}else{
					dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + arr[i][j];
				}
			}
		}
		display(dp);
		System.out.println("Minimum Path Cost : "+dp[0][0]);
	}

}
