package com.prep.interview.BackTracking;
/*Permutation using BOXES on LEVEL ORDER
 * Boxes = An Array of No. of Boxes in which unidentical i.e distinct items can be placed
 */
public class Permutations2 {

	public static void main(String[] args) {
		int nboxes = 3;
		int ritems = 2;
		permutationsBoxesOnLevelOrder(1 , nboxes , new boolean[ritems] , 0 , ritems , "");

	}

	private static void permutationsBoxesOnLevelOrder(int curbox , int totalbox , boolean [] items , int selsf , int totalitems , String asf){
		if(curbox > totalbox){
			if(selsf == totalitems){
				System.out.println(asf + " ");
			}
			return;
		}
		for(int i = 0 ; i< totalitems ; i++){
			if(items[i] == false){
				items[i] = true;
				permutationsBoxesOnLevelOrder(curbox + 1 , totalbox , items , selsf +1 , totalitems , asf + (i+1));
				items[i] = false;
				
			}
		}
		permutationsBoxesOnLevelOrder(curbox + 1 , totalbox , items , selsf , totalitems , asf + "0");

	}
}
