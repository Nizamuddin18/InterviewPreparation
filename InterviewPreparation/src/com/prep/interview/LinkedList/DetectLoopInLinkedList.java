package com.prep.interview.LinkedList;
import java.util.*;
class NodeList{
	int data;
	NodeList next;
	NodeList(int data){
		this.data = data;
	}
	NodeList(){
		
	}
}
public class DetectLoopInLinkedList {
	static NodeList head;
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			DetectLoopInLinkedList list = new DetectLoopInLinkedList();
			System.out.println("1.Detect Loop in LinkedList\n2.Detect and REmove Loop in Linked List");
			System.out.println("Enter Choice : ");
			int choice = sc.nextInt();
	        list.head = new NodeList(50);
	        list.head.next = new NodeList(20);
	        list.head.next.next = new NodeList(15);
	        list.head.next.next.next = new NodeList(4);
	        list.head.next.next.next.next = new NodeList(10);
	 
	        // Creating a loop for testing
	        head.next.next.next.next.next = head.next.next;
	        if(choice == 1){
	        	NodeList loopingNode = list.detectLoop(head);
		        System.out.println("Loop starts in Linked List from Node : " + loopingNode.data);
	        }else if(choice == 2){
	            list.detectAndRemoveLoop(head);
		        System.out.println("Linked List after removing loop : ");
		        list.printList(head);
	        }else{
	        	
	        }
	        
	    
	}
	private void printList(NodeList temp) {
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp= temp.next;
		}
	}
	private NodeList detectLoop(NodeList head){
		NodeList slow = head;
		NodeList fast = head;
		boolean flag = false;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				flag = true;
				break;
			}	
		}
		if(flag){
			slow = head;
			while(slow.next!=fast.next){
				slow = slow.next;
				fast = fast.next;
			}
			//System.out.println("Looping Node : " + fast.data);
		}
		return fast;
	}
	private void detectAndRemoveLoop(NodeList head) {
		NodeList slow = head;
		NodeList fast = head;
		boolean flag = false;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				flag = true;
				break;
			}	
		}
		if(flag){
			slow = head;
			while(slow.next!=fast.next){
				slow = slow.next;
				fast = fast.next;
			}
			fast.next = null;
		}
	}

}
