package com.prep.interview.DynamicProgramming.Foundation;
import java.util.*;
public class MaximumSumNonAdjacent {

	public static void main(String[] args) {
/*		int arr[] = {5,10,10,100,5,6};
		int inc = arr[0];
		int exc = 0;
		for(int i = 1; i < arr.length ; i++){
			int newinc = exc + arr[i];
			int newexc = Math.max(inc, exc);
			inc = newinc;
			exc = newexc;
		}
		System.out.println(Math.max(inc, exc));*/
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        int arr[] = {5,10,10,100,5,6};
        int oldinc = arr[0];
        int oldexc = 0;
        System.out.println("Include :" + oldinc + " and Exclude : " + oldexc);
       for(int i = 1 ; i < arr.length ; i++){
           int newinc = oldexc + arr[i];
           int newexc = Math.max(oldinc , oldexc);
           oldexc = newexc;
           oldinc = newinc;
           System.out.println("Include :" + oldinc + " and Exclude : " + oldexc);
       }
       System.out.println(Math.max(oldexc , oldinc));
	}
}
