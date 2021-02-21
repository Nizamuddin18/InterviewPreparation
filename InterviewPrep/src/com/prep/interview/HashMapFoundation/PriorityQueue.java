package com.prep.interview.HashMapFoundation;
import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {
	ArrayList<Integer> data;
	
	public PriorityQueue() {
		data = new ArrayList<Integer>();
	}
	
	private void add(int val){
		data.add(val);
		upHeapify(data.size() - 1);
	}

	private void upHeapify(int i) {
		if(i==0)
			return;
		int pi = (i-1)/2;
		if(data.get(i) < data.get(pi)){
			swap(i , pi);
			upHeapify(pi);
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		data.set(i, jth);
		data.set(j, ith);
	}
	
	private int remove(){
		if(this.size() == 0){
			System.out.println("Underflow");
			return -1;
		}
		swap(0, data.size() -1);
		int val = data.size() - 1;
		downHeapify(0);
		return val;
			
	}
	
	private void downHeapify(int pi) {
		int min = pi;
		int li = 2*pi + 1;
		int ri = 2*pi + 2;
		if(li < data.size() && data.get(li) < data.get(min))
			min = li;
		if(ri < data.size() && data.get(ri) < data.get(min))
			min = ri;
		
		if(min != pi){
			swap(pi, min);
			downHeapify(min);
		}	
	}

	private int size(){
		return (data.size());
	}
	
	private void display(){
		System.out.println("List : " + data);
	}
	
	private void peek(){
		System.out.println("Peek value : " + data.get(0));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue pq = new PriorityQueue();
		int choice;
		int val;
		while(true){
			System.out.println("1.Add");
			System.out.println("2.Remove");
			System.out.println("3.Peek");
			System.out.println("4.Display");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter value to be added:");
				val = sc.nextInt();
				pq.add(val);
				break;
			case 2:
				System.out.println("The value Removed :" + pq.remove());
				break;
			case 3: 
				pq.peek();
				break;
			case 4:
				pq.display();
				break;
			default:
				System.exit(0);
			}
		}
	}

}
