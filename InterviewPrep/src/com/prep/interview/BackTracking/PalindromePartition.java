package com.prep.interview.BackTracking;

public class PalindromePartition {

	public static void main(String[] args) {
		String str = "abaaba";
		palindromePartition(str , "");
		

	}
	public static void palindromePartition(String ques , String asf){
		//================Base Case starts===================
		if(ques.length() == 0){
			System.out.println(asf + " ");
			return;
		}
		//================Base Case ends===================

		for(int  i = 0; i< ques.length(); i++){
			String qLeft = ques.substring(0,i+1);
			if(isPalindrome(qLeft)){
				String qRight = ques.substring(i+1);
				palindromePartition(qRight , asf + "(" + qLeft + ")");
			}
		}
	}
	
	public static boolean isPalindrome(String str){
		int li = 0;
		int ri = str.length() - 1;
		while(li < ri){
			if(str.charAt(li)!=str.charAt(ri)){
				return false;
			}
			li++;
			ri--;
		}
		return true;
	}

}
