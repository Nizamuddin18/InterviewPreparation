package com.prep.interview.BackTracking;
import java.util.*;
public class PalindromicPermutations {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = "aaaabbccc";
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(fmap.containsKey(ch)){
				int oldfreq = fmap.get(ch);
				int newfreq = oldfreq + 1;
				fmap.put(ch, newfreq);
			}else{
				fmap.put(ch, 1);
			}
		}
		//check no. of odd frequency character
		Character odd = null;
		int odds = 0;
		int len = 0;
		//loop for all characters in key set
		for(char ch : fmap.keySet()){ // check for all the characters in Hash Keys
			int freq = fmap.get(ch); // get the frequency of character
			if(freq % 2 == 1){ // if frequency is odd
				odd = ch;  // add to Character
				odds++;
			}
			fmap.put(ch, freq / 2); // half the frequency for that character
			len = len + (freq/2); // half the length
		}
		if(odds > 1){
			System.out.println(-1);
			return;
		}
			
		generatepw(1 , len , fmap , odd , "");

	}
	
	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		//================Base Case starts===================
		if(cs > ts){
			//Reverse the answer
			String rev = "";
			for(int  i = asf.length() - 1; i >= 0 ; i--){
				rev = rev + asf.charAt(i);
			}
			
			String res = asf;
			// if any odd frequency character is found
			if(oddc != null){
				res = res + oddc;			// append it to reverse string

			}
			res = res + rev; //append the answer and the reversed string
			System.out.println(res);
			return;
		}
		//================Base Case ends===================
		
		//we will loop through based on the no. of different charcter key set found
		for(char ch : fmap.keySet()){
			int freq = fmap.get(ch); // get the frequency for that character
			if(freq > 0){
				fmap.put(ch, freq - 1); // reduce the frequency by 1
				generatepw(cs+1 , ts , fmap , oddc , asf + ch); // call the function 
				//Backtracking , put the frequency to original freq
				fmap.put(ch, freq); 
			}	
		}
		

	}

}


