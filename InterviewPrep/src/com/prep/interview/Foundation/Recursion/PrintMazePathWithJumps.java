package com.prep.interview.Foundation.Recursion;
import java.util.*;
public class PrintMazePathWithJumps {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        for(int jump = 1 ; jump + sc <= dc ; jump++)
            printMazePaths(sr , sc + jump , dr , dc , psf + "h" + jump);
            
        for(int jump = 1 ; jump + sr <= dr ; jump++)
            printMazePaths(sr + jump , sc , dr , dc , psf + "v" + jump);
            
        for(int jump = 1 ; jump + sr <= dr && jump + sc <= dc ; jump++)
            printMazePaths(sr + jump , sc + jump , dr , dc , psf + "d" + jump);
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		printMazePaths(0, 0, n - 1, m - 1, "");
	}

}
