package com.prep.interview.LinkedList;

import java.util.Scanner;

public class LinkedListDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("======== Linked List Operations ========");
		LinkedListCustom l = new LinkedListCustom();
		System.out.println("1.Display LinkedList");
		System.out.println("2.Add First to LinkedList");
		System.out.println("3.Add Last to LinkedList");
		System.out.println("4.Size of LinkedList");
		System.out.println("5.Rotate LinkedList");
		System.out.println("7.Reverse LinkedList");
		System.out.println("8.Add At Specific Position to LinkedList");
		System.out.println("9.Kth Element from End");
		System.out.println("10.Middle of LinkedList");
		System.out.println("11.Merge Sort Of LinkedList");
		System.out.println("12.Remove duplicates from a sorted linked list");
		System.out.println("13.Linked List To Stack");
		System.out.println("14.Fold LinkedList");
		System.out.println("15.Segregate Odd evn Linked List");
		System.out.println("16.Remove First from LinkedList");
		System.out.println("17.Remove Last from LinkedList");
		System.out.println("18.Remove At from LinkedList");
		while(true){
			System.out.println("Enter Choice : ");
			int choice = sc.nextInt();
			switch(choice){
			case 1 :
				l.printList();
				break;
				
			case 2 :
				System.out.println("Enter Value To be Added :");
				int dataFirst = sc.nextInt();
				l.addFirst(dataFirst);
				break;
				
			case 3 :
				System.out.println("Enter Value To be Added :");
				int dataLast = sc.nextInt();
				l.addLast(dataLast);
				break;
				
			case 4 :
				int size = l.getSize();
				System.out.println("Size :" + size);
				break;
			
			case 5 : 
				System.out.println("Enter K value :");
				int k = sc.nextInt();
				l.rotateLinkedList(k);
				break;
				
			case 6 :
				System.out.println("Loop detection :");
				boolean isCycle = l.cycleDetection();
				if(isCycle)
					System.out.println("true");
				else
					System.out.println("false");
				break;
				
			case 7 :
				System.out.println("Original Linked List :");
				l.printList();
				l.reverseLinkedList();
				System.out.println("Reversed Linked List :");
				l.printList();
				break;
				
			case 8 :
				System.out.println("Enter index : ");
				int index = sc.nextInt();
				System.out.println("Enter value to be added");
				int dataAtPos = sc.nextInt();
				l.addAtIndex(index, dataAtPos);
				break;
				
			case 9 :
				int element = l.kthFromLast(2);
				System.out.println("Kth Element from Last is : " + element);
				break;
			
			case 10 :
				int mid = l.getMid();
				System.out.println("Element at Middle of LinkedList : " + mid);
				break;
			
			case 11 :
				size = l.getSize();
				int startIndex = 0;
				int endIndex = size - 1;
				Node li = l.getAt(startIndex);
				Node ri = l.getAt(endIndex);
				l.mergeSort(li, ri);
				break;
			case 12 :
				System.out.println("Input Linked List : ");
				l.removeDuplicate();
				System.out.println("After Removal of Duplicates : ");
				l.printList();
				break;
			case 13 : 
				System.out.println("Linked List To Stack");
				boolean flag = true;
				while(flag){
					System.out.println("1.PUSH\n2.POP\n3.TOP\n4.PRINT\n-1. Exit Stack...");
					System.out.println("Enter Choice");
					int choiceSt = sc.nextInt();
					switch(choiceSt){
					case 1: 
						System.out.println("Enter Data : ");
						int data = sc.nextInt();
						l.addFirst(data);
						break;
					case 2 : 
						l.removeFirst();
						break;
					case 3 : 
						l.checkTop();
						break;
					case 4 : 
						l.printList();
						break;
					default : 
						flag = false;
					}
				}
			case 14 : 
				l.foldLinkedList();
				break;
			case 15 : 
				l.oddEvenSegregate();
				l.printList();
				break;
			case 16 : 
				l.removeFirst();
				l.printList();
				break;
			case 17 : 
				l.removeLast();
				l.printList();
				break;
			case 18 : 
				System.out.println("Enter Position to be Removed : ");
				int pos = sc.nextInt();
				l.removeAt(pos);
				l.printList();
				break;
			default :
				System.out.println("Quit...");
				System.exit(0);
			}
		}
	}
}
