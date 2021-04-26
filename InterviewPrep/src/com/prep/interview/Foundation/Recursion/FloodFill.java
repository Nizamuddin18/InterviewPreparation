package com.prep.interview.Foundation.Recursion;
import java.util.*;
public class FloodFill {
	static int rdir[] = {-1,0,1,0};
	static int cdir[] = {0,-1,0,1};
	static char dir[] = {'t' , 'l' , 'd' , 'r'};
	private static void floodfill(int board[][] , int row , int col , String asf){
		if(row == board.length-1 && col == board[0].length-1){
			System.out.println(asf);
			return;
		}
		board[row][col] = 1;
		for(int i = 0 ; i < rdir.length ; i++){
			int rr = row + rdir[i];
			int cc = col + cdir[i];
			char ch = dir[i];
			if(rr >= 0 && rr < board.length && cc >= 0 && cc < board[0].length && board[rr][cc] != 1){
				floodfill(board , rr , cc , asf + ch);
			}
		}
		board[row][col] = 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int board[][] = {
						{0,1,0,0,0,0},
						{0,1,0,1,1,0},
						{0,1,0,1,1,0},
						{0,0,0,0,0,0},
						{1,1,0,1,1,0},
						{1,1,0,0,0,0}
						};
		floodfill(board , 0 , 0 , "");
	}

}
