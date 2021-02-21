package com.prep.interview.Stacks;
import java.util.*;
public class NearestGreaterToRight {

	public static void main(String[] args) {
		int arr[] = {1,3,0,0,1,2,4};
		Stack<Integer> st = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = arr.length-1 ; i >=0 ; i--){
			if(st.isEmpty()){
				list.add(-1);
			}else if(!st.isEmpty() && st.peek() > arr[i]){
				list.add(st.peek());
			}else if(!st.isEmpty() && st.peek() <= arr[i]){
				while(!st.isEmpty() && st.peek() <= arr[i]){
					st.pop();
				}
				if(st.isEmpty()){
					list.add(-1);
				}else{
					list.add(st.peek());
				}
			}
			st.push(arr[i]);
		}
		Collections.reverse(list);
		System.out.println("List : " + list);
	}

}
