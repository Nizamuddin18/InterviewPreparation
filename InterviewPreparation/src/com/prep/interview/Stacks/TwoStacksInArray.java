package com.prep.interview.Stacks;

public class TwoStacksInArray {
	int data[];
	int tos1,tos2;
	public TwoStacksInArray(int n){
		data = new int[n];
		tos1 = -1;
		tos2 = data.length;
	}
	public int top1(){
		return data[tos1];
	}
	public int top2(){
		return data[tos2];
	}
	public int size2(){
		return data.length - tos2;
	}
	public int size1(){
		return tos1+1;
	}
	public void push1(int val){
		if(tos1 == tos2-1){
			System.out.println("Stack1 Overflow");
			return;
		}else{
			data[++tos1] = val;
		}
	}
	public void push2(int val){
		if(tos2 == tos1 + 1){
			System.out.println("Stack2 Overflow");
			return;
		}else{
			data[--tos2] = val;
		}
	}
	public int pop1(){
		int retVal;
		if(tos1 == -1){
			System.out.println("Stack1 UnderFlow");
			return -1;
		}else{
			retVal = data[tos1--];	
		}
		return retVal;
	}
	public int pop2(){
		int retVal;
		if(tos2 == data.length){
			System.out.println("Stack2 UnderFlow");
			return -1;
		}else{
			retVal = data[tos2++];	
		}
		return retVal;
	}
	public static void main(String[] args) {
		int n = 5;
		TwoStacksInArray stack = new TwoStacksInArray(n);
		System.out.println("push1 10");
		stack.push1(10);
		System.out.println("push1 20");
		stack.push1(20);
		System.out.println("push2 30");
		stack.push2(30);
		System.out.println("push2 40");
		stack.push2(40);
		System.out.println("push2 50");
		stack.push2(50);
		System.out.println("push1 60");
		stack.push1(60);
		System.out.println("top1 :"+stack.top1());
		System.out.println("pop1 :"+stack.pop1());
		System.out.println("top1 :"+stack.top1());
		System.out.println("pop1 :"+stack.pop1());
		System.out.println("top2 :"+stack.top2());
		System.out.println("pop2 :"+stack.pop2());
		/*for(int i = 0 ; i < stack.data.length ; i++){
			System.out.print(stack.data[i] + " ");
		}*/
	}

}
