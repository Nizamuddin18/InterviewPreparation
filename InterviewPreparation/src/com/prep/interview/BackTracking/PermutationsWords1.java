package com.prep.interview.BackTracking;
import java.util.*;
public class PermutationsWords1 {

	public static void main(String[] args) {
		String str = "aabb";
		System.out.println("Input String : " + str);
		 HashMap<Character, Integer> fmap = new HashMap<>();
		    for(char ch: str.toCharArray()){
		      if(fmap.containsKey(ch)){
		        fmap.put(ch, fmap.get(ch) + 1);
		      } else {
		        fmap.put(ch, 1);
		      }
		    }
			System.out.println("Output Permutations : ");
		    generateWords(1, str.length(), fmap, "");

	}
	
	private static void generateWords(int cs , int ts , HashMap<Character , Integer>map , String asf){
		if(cs > ts){
			System.out.println(asf + " ");
			return;
		}
		
		for(char ch : map.keySet()){
			int freq = map.get(ch);
			if(freq > 0){
				map.put(ch, freq-1);
				generateWords(cs+1 , ts , map , asf + ch);
				//Backtrack
				map.put(ch, freq);
			}		
		}
	}

}
