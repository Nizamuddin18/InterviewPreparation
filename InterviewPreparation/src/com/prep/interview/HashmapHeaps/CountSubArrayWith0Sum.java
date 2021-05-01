package com.prep.interview.HashmapHeaps;

import java.util.HashMap;

public class CountSubArrayWith0Sum {

	public static void main(String[] args) {
		int arr[] ={1,-1,3,2,-2,-8,1,7,10,23}; //{1,-1,3,2,-2,-8,1,7,10,23},{2,8,-3,-5,2,-4,6,1,2,1,-3,4}
		int ret_val = countOf0Sum(arr);
		System.out.println("Count of SubArray with Zero Sum : " + ret_val);

	}

	private static int countOf0Sum(int[] arr) {
		int sum =0;
		int count = 0;
		HashMap<Integer , Integer> map = new HashMap<>();
		for(int i = 0 ; i< arr.length ; i++){
			sum += arr[i];
			if(sum == 0)
				count += 1;
			else{
				if(map.containsKey(sum) == false){
					map.put(sum, 1);
				}else{
					count = count + map.get(sum);
					map.put(sum, map.get(sum) + 1);
				}
			}
		}
		return count;
	}

}
