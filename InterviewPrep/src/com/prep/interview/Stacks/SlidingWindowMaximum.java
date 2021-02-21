package com.prep.interview.Stacks;

import java.util.Stack;
class PairStack{
	int index;
	int data;
	PairStack(int index , int data){
		this.index = index;
		this.data = data;
	}
}
public class SlidingWindowMaximum {
	public static int[] bruteForce(int arr[] , int k){
		int len = arr.length-k+1;
		int res[] = new int[len];
		for(int i = 0 ; i < len; i++){
			int max = Integer.MIN_VALUE;
			for(int j = i ; j < i+k ; j++){
				if(arr[j] > max)
					max = arr[j];
			}
			res[i] = max;
		}
		return res;
	}
	
	public static void method1(int arr[] , int k){
		int len = arr.length - k + 1;
		int res[] = new int[len];
		int ngr[] = new int[arr.length];
		Stack<PairStack> stack = new Stack<>();
		for(int i = arr.length - 1 ; i >= 0 ; i--){
			if(stack.isEmpty()){
				ngr[i] = arr.length;
			}else if(!stack.isEmpty() && stack.peek().data > arr[i]){
				ngr[i] = stack.peek().index;
			}else if(!stack.isEmpty() && stack.peek().data <= arr[i]){
				while(!stack.isEmpty() && stack.peek().data <= arr[i])
					stack.pop();
				if(stack.isEmpty())
					ngr[i] = arr.length;
				else
					ngr[i] = stack.peek().index;
			}
			PairStack pair = new PairStack(i , arr[i]);
			stack.push(pair);
		}
		/*System.out.print("Nearest Greater Element To Right Method2: ");
		for(int i = 0 ; i < nge.length ; i++)
			System.out.print(nge[i] + " ");
		System.out.println();*/
		int j = 0;
		for(int i = 0 ; i < len ; i++){
			if(j < i){
				j = i;
			}
			while(ngr[j] < i+k){
				 j = ngr[j];
			}
			res[i] = j;
		}
		
		System.out.print("Output:");
		for(int i = 0 ; i < len ; i++){
			System.out.print(arr[res[i]] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,1,4,5,2,3,6};
		int k = 3;
		int res[];
		System.out.println("-----Sliding Window Maximum(LeetCode 239)-----");
		System.out.print("Input :");
		for(int i = 0 ; i < arr.length ; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		//res = bruteForce(arr , k);
		method1(arr,k);
	}
}
