package com.prep.interview.BackTracking;

import java.util.HashMap;

public class PermutationsWords2 {

	public static void main(String[] args) {
		String str = "abcd";
		System.out.println("Input String : " + str);
		Character spots[] = new Character[str.length()];
		HashMap<Character, Integer> fmap = new HashMap<>();
		    for(char ch: str.toCharArray()){
		        fmap.put(ch, -1);
		    }
		generateWords(0, str, spots , fmap);
	}

	private static void generateWords(int ci, String str, Character[] spots , HashMap<Character, Integer> map) {
		if(ci == str.length()){
			for(int  i = 0 ; i< spots.length;i++){
				System.out.print(spots[i]);
			}
			System.out.println();
			return;
		}
		char ch = str.charAt(ci);
		int lo = map.get(ch); // get the last occurence of that character
		for(int i = lo+1 ; i < spots.length; i++){
			if(spots[i] == null){
				spots[i] = ch;
				map.put(ch, i);
				generateWords(ci+1 , str , spots , map);
				map.put(ch, -1);
				spots[i] = null;
			}
			
		}
		
	}

}
