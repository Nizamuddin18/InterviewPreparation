package com.prep.interview.BackTracking;

public class Combinations1 {

	public static void main(String[] args) {
		int boxes = 3;
		int items = 2;
		combinationsBoxesOnLevelOrder(1 , boxes , items , 0 , "");

	}

	private static void combinationsBoxesOnLevelOrder(int cb, int totboxes, int totitems, int selSoFar, String asf) {
		if(cb > totboxes){
			if(selSoFar == totitems){
				System.out.println(asf);
			}
			return;
		}
		combinationsBoxesOnLevelOrder(cb+1 , totboxes , totitems , selSoFar+1 , asf + "i");
		combinationsBoxesOnLevelOrder(cb+1 , totboxes , totitems , selSoFar , asf + "-");
	}

}
