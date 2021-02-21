package com.tcs.Practice;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	int arr[] = {1,2,3,4,0};
	int len = arr.length;
	ArrayList<Integer> res_list= leadersInArray(arr , len);
	Collections.reverse(res_list);
	System.out.println("List :" + res_list);
	}

	private static ArrayList<Integer> leadersInArray(int[] arr, int len) {
		int i = len-1;
		int max_from_right = Integer.MIN_VALUE;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(i >= 0){
			if(arr[i] >= max_from_right){
				max_from_right = arr[i];
				list.add(max_from_right);
			}	
			i--;
		}
		return list;
	}

}
