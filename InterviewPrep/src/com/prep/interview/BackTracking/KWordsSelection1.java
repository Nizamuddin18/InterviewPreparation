package com.prep.interview.BackTracking;
import java.util.*;

public class KWordsSelection1 {

	public static void main(String[] args) {
		String str = "abcabc";
		int  k =2;
		HashSet<Character> set = new HashSet<>();
		String unique = "";
		for(char ch : str.toCharArray()){
			if(!set.contains(ch)){
				set.add(ch);
				unique = unique + ch;
			}
		}
		
		kwordsSelection(0 , unique , set , ""  ,k , 0);
	}

	private static void kwordsSelection(int ci, String unique, HashSet<Character> set, String asf, int ts , int selSoFar) {
		if(ci == unique.length()){
			if(selSoFar == ts){
				System.out.println(asf + " ");
			}
			return;
		}
		char ch = unique.charAt(ci);
		kwordsSelection(ci+1 , unique , set , asf + ch, ts , selSoFar+1);
		kwordsSelection(ci+1 , unique , set , asf + "_ ",ts ,  selSoFar);
	}

}
