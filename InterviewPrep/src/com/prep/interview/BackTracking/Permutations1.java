package com.prep.interview.BackTracking;
import java.util.*;
/*Permutation using ITEMS on LEVEL ORDER
 * Boxes = An Array of No. of Boxes in which unidentical i.e distinct items can be placed
 */
public class Permutations1 {

	public static void main(String[] args) {
		int nboxes = 3;
		int ritems = 2;
		permutations(1 ,new int[nboxes] ,ritems); // boxes[] = {0,0,0,0} this array is used to show that at which place items to be placed

	}
	
	private static void permutations(int curItem , int [] boxes , int totItem){
		if(curItem > totItem){
			for(int  i = 0 ; i< boxes.length ; i++){
				System.out.print(boxes[i]);
			}
			System.out.println();
			return;
		}
		for(int  i = 0 ; i< boxes.length ; i++){
			if(boxes[i] == 0){
				boxes[i] = curItem;
				permutations(curItem + 1 , boxes ,totItem);
				//BackTracking
				boxes[i] = 0;
			}
			
		}
	}

}
