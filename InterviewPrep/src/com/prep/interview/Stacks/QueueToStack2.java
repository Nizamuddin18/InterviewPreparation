package com.prep.interview.Stacks;

import java.util.ArrayDeque;
import java.util.Queue;
/*Implement Queue to Stack Adapter Push efficient*/
public class QueueToStack2 {
	Queue<Integer> mainQ;
	Queue<Integer> helperQ;
	public QueueToStack2(){
		mainQ = new ArrayDeque<>();
		helperQ = new ArrayDeque<>();
	}
	public int getSize(){
		return mainQ.size();
	}
	
	public int pop(){
		int topVal;
		if(mainQ.size() == 0){
			System.out.println("Stack Underflow");
			return -1;
		}else{
			while(mainQ.size() > 1){
				helperQ.add(mainQ.remove());
			}
			topVal = mainQ.remove();
			while(helperQ.size() > 0){
				mainQ.add(helperQ.remove());
			}
		}
		return topVal;
	}
	public int top(){
		int topVal;
		if(mainQ.size() == 0){
			System.out.println("Stack Underflow");
			return -1;
		}else{
			while(mainQ.size() > 1){
				helperQ.add(mainQ.remove());
			}
			topVal = mainQ.remove();
			helperQ.add(topVal);
			while(helperQ.size() > 0){
				mainQ.add(helperQ.remove());
			}
		}
		return topVal;
	}
	public void push(int val){
		mainQ.add(val);
	}

	public static void main(String[] args) {
		QueueToStack2 stack = new QueueToStack2();
		stack.push(10);
		stack.push(20);
		stack.push(5);
		stack.push(8);
		stack.push(2);
		stack.push(4);
		stack.push(11);
		System.out.println("Top : " + stack.top());
		System.out.println("Pop : " + stack.pop());
		System.out.println("Stack : " + stack.mainQ);
		System.out.println("Top : " + stack.top());
	}

}
