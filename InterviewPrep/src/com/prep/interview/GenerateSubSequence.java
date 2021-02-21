package com.prep.interview;
import java.util.*;
public class GenerateSubSequence {

	public static void main(String[] args) {
		String str = "abc";
		solve(str , "");
	}
	private static void solve(String ques , String asf){
		if(ques.length() == 0){
			System.out.println("(" + asf + ")");			
			return;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);
		solve(ros , asf + ch);
		solve(ros , asf + "");
		 
	}

}
