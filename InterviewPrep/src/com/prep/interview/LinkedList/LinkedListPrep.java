package com.prep.interview.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node{
	int data;
	Node next;
	
	public Node(int data){
		this.data = data;
	}
	
	public Node(){
		
	}
	
}
public class LinkedListPrep {
	Node head;
	Node tail;
	int size;
	
	public int getSize(){
		return size;
	}
	
	public Node createNode(int val){
		Node temp = new Node();
		temp.data = val;
		temp.next = null;
		return temp;
	}
	
	public void addLast(int val){
		Node temp = createNode(val);
		if(size == 0){
			head = temp;
			tail = temp;
		}else{
			tail.next = temp;
			tail = temp;
		}
		size++;
	}
	
	public void addFirst(int val){
		Node temp = createNode(val);
		if(size == 0){
			head = temp;
			tail = temp;
		}
		else{
			temp.next = head;
			head = temp;
		}
		size++;
	}
	
	public void removeFirst(){
		if(size == 0){
			System.out.println("Underflow!");
			return;
		}else{
			Node temp = head;
			System.out.println("Node deleted : " + temp.data);
			temp = temp.next;
			head = temp;
			size--;
		}
	}
	public void printList(){
		Node temp = head;
		System.out.print("[ ");
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.print("]");
		System.out.println();

	}
	
	public void rotateLinkedList(int k){
		Node ptr = null;
		Node nextPtr = head;
		int i = 0;
		while(i < k){
			ptr = nextPtr;
			nextPtr = nextPtr.next;
			i++;
		}
		while(nextPtr.next != null){
			nextPtr = nextPtr.next;
		}
		nextPtr.next = head;
		head = ptr.next;
		ptr.next = null;
	}
	
	public boolean cycleDetection(){
		Node slow = head;
		Node fast = head;
		while(slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;	
			if(slow == fast)
				return true;
		}
		return false;
		
	}
	
	public void reverseLinkedList(){
		Node prev = null;
		Node cur = head;
		Node temp = cur;
		while(temp!=null){
			temp = temp.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		head = prev;
	}
	
	public void addAtIndex(int index , int val){
		Node temp = head;
		Node node = createNode(val);
		for(int i = 0; i< index - 1; i++){
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
	}
	
	public int kthFromLast(int k){
		Node fast = head;
		Node slow = head;
		for(int  i = 0; i< k; i++){
			 fast = fast.next;
		}
		while(fast!=tail){
			fast = fast.next;
			slow = slow.next;
		}
		return slow.data;
	}
	
	public int getMid(){
		Node fast = head;
		Node slow = head;
		while(fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow.data;
	}
	
	private Node getMiddleNode(Node start , Node end){
		Node fast = start;
		Node slow = start;
		while(fast!=end && fast.next!=end){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	public LinkedListPrep mergeSort(Node start , Node end){
		if(start == end){
			LinkedListPrep baseResult = new LinkedListPrep();
			baseResult.addLast(start.data);
			return baseResult;
		}
		
		Node mid = getMiddleNode(start , end);
		LinkedListPrep fsh = mergeSort(start , mid);
		LinkedListPrep ssh = mergeSort(mid.next , end);
		LinkedListPrep sortedList = mergeAndSortLists(fsh , ssh);
		return sortedList;
	}

	private LinkedListPrep mergeAndSortLists(LinkedListPrep fsh, LinkedListPrep ssh) {
		Node one = fsh.head;
		Node two = ssh.head;
		LinkedListPrep list = new LinkedListPrep();
		while(one!=null && two!=null){
			if(one.data < two.data){
				list.addLast(one.data);
				one = one.next;
			}else{
				list.addLast(two.data);
				two = two.next;
			}
		}
		while(one!=null){
			list.addLast(one.data);
			one = one.next;
		}
		while(two!=null){
			list.addLast(two.data);
			two = two.next;
		}		
		return list;
	}
	
	public Node getAt(int index){
		if(size == 0){
			System.out.println("Underflow");
			return null;
		}
		if(index < 0 || index > size){
			System.out.println("Invalid Index");
			return null;
		}else{
			Node temp = head;
			for(int  i = 0;i < index ; i++)
				temp = temp.next;
			return temp;	
		}
	}
	
	public void removeDuplicate(){
		Node cur = head;
		while(cur!=null && cur.next!=null){
			Node temp = cur;
			while(temp.next.data == temp.data)
				temp = temp.next;
			cur.next = temp.next;
			cur = cur.next;
		}
	}
	public void checkTop(){
		if(size == 0){
			System.out.println("Stack Underflow!");
			return;
		}else
		{
			Node temp = head;
			System.out.println("Top Value : " + temp.data);
		}
	}
	
}
