package com.prep.interview.HashmapHeaps;

import java.util.HashMap;

public class LongestSubArrayWith0Sum {

	public static void main(String[] args) {
		int arr[] = {2,8,-3,-5,2,-4,6,1,2,1,-3,4}; //{1,-1,3,2,-2,-8,1,7,10,23}
		int ret_val = getLongestSubArray(arr);
		System.out.println("Longest SubArray with Zero Sum :" + ret_val);
	}

	private static int getLongestSubArray(int[] arr) {
		int maxlen = 0;
		int sum = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0 ; i < arr.length ; i++){
			sum += arr[i];
			if(sum ==0)
				maxlen = i+1;
			else{
				if(map.containsKey(sum) == false){
					map.put(sum, i);
				}else{
					maxlen = Math.max(i - map.get(sum), maxlen);
				}
			}
		}
		return maxlen;
	}

}
