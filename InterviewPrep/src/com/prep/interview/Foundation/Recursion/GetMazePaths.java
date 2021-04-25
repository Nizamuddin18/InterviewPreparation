package com.prep.interview.Foundation.Recursion;

import java.util.*;

public class GetMazePaths {
	private static ArrayList<String> getMazePaths(int drow, int dcol, int srow, int scol) {
		if (srow == drow && scol == dcol) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> paths = new ArrayList<>();

		if (scol < dcol) {
			ArrayList<String> hpath = getMazePaths(drow, dcol, srow, scol + 1);
			for (String hp : hpath)
				paths.add("h" + hp);
		}
		if (srow < drow) {
			ArrayList<String> vpath = getMazePaths(drow, dcol, srow + 1, scol);
			for (String vp : vpath)
				paths.add("v" + vp);
		}
		return paths;
	}

	private static ArrayList<String> getMazePathsJumps(int drow, int dcol, int srow, int scol) {
		if (srow == drow && scol == dcol) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> paths = new ArrayList<>();
		// Horizontal jumps
		for (int jump = 1; scol + jump <= dcol; jump++) {

			ArrayList<String> hpath = getMazePathsJumps(drow, dcol, srow, scol + jump);
			for (String hp : hpath)
				paths.add("h" + jump + hp);

		}

		// vertical jumps
		for (int jump = 1; srow + jump <= drow; jump++) {

			ArrayList<String> vpath = getMazePathsJumps(drow, dcol, srow + jump, scol);
			for (String vp : vpath)
				paths.add("v" + jump + vp);

		}

		// diagonal jumps
		for (int jump = 1; scol + jump <= dcol && srow + jump <= drow; jump++) {

			ArrayList<String> dpath = getMazePathsJumps(drow, dcol, srow + jump, scol + jump);
			for (String dp : dpath)
				paths.add("d" + jump + dp);

		}
		return paths;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		/*
		 * System.out.println("Enter source row : "); 
		 * int sr = scn.nextInt();
		 * System.out.println("Enter source col : "); 
		 * int sc = scn.nextInt();*/

		System.out.println("Enter dest row : ");
		int dr = scn.nextInt();
		System.out.println("Enter dest col : ");
		int dc = scn.nextInt();
		System.out.println(getMazePathsJumps(dr-1, dc-1, 0, 0));
	}

}
