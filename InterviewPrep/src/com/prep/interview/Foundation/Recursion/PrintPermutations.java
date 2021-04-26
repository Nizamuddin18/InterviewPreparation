package com.prep.interview.Foundation.Recursion;
import java.util.*;
public class PrintPermutations {
	private static void printPermutations(String ques, String ansf) {
		if(ques.length() == 0){
			System.out.println(ansf);
			return;
		}
		for(int i = 0 ; i < ques.length() ; i++){
			char ch = ques.charAt(i);
			String firstPart = ques.substring(0,i);
			String lastPart = ques.substring(i+1);
			String roq = firstPart + lastPart;
			printPermutations(roq ,  ansf + ch);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String : ");
		String ques = sc.nextLine();
		printPermutations(ques , "");
	}

	

}
