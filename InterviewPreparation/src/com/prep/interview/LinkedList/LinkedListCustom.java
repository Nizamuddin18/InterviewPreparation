package com.prep.interview.LinkedList;

class Node{
	int data;
	Node next;
	public Node(int data){this.data = data;} // Parameterized Constructor
	public Node(){} //Default Constructor
	@Override
	public String toString() {
		return "Node[" + data + "]";
	}
	
}
public class LinkedListCustom{
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
	
	public int getFirst(){
		int retVal = 0;
		if(this.size == 0){
			System.out.println("List is empty");
			retVal = -1;
		}else{
			retVal = this.head.data;
		}
		return retVal;
	}
	
	public Node getAt(int index){
		if(size == 0){
			System.out.println("List is empty");
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
	
	public int getAtValue(int index){
		if(size == 0){
			System.out.println("List is empty");
			return -1;
		}
		if(index < 0 || index > size){
			System.out.println("Invalid arguments");
			return -1;
		}else{
			Node temp = head;
			for(int  i = 0;i < index ; i++)
				temp = temp.next;
			return temp.data;	
		}
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
	
	public int removeFirst(){
		Node temp = head;
		int val = 0;
		if(size == 0){
			System.out.println("List is empty");
			return -1;
		}else{
			val = temp.data;
			temp = temp.next;
			head = temp;
			size--;
		}
		return val;
	}
	
	public int removeLast(){
		if(size == 0){
			System.out.println("List is empty");
			return -1;
		}else if(size == 1){
			return handleRemoveWhenSize1();
		}else{
			Node nm1 = getNthNode(this.size - 2);
            int val = this.tail.data;
            nm1.next = null;
            this.tail = nm1;
            this.size--;
            return val;
		}
	}
	
	public int removeAt(int indx) {
        if(indx < 0 || indx >= this.size) {
            return -1;
        } else if(indx == 0) {
            return removeFirst();
        } else if(indx == this.size - 1) {
            return removeLast();
        } else {
            Node nm1 = getNthNode(indx - 1);
            int val = nm1.next.data;
            nm1.next = nm1.next.next;
            this.size--;
            return val;
        }
    }
	
	private int handleRemoveWhenSize1() {
        int val = this.head.data;
        this.head = this.tail = null;
        this.size = 0;
        return val;
    }
	
	private Node getNthNode(int pos) {
		Node temp = this.head;
		for (int i = 0; i < pos; i++) {
			temp = temp.next;
		}
		return temp;
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
	
	public static void printListCustom(Node temp){
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
		tail = head;
		while(temp!=null){
			temp = temp.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		head = prev;
	}
	
	public static Node reverseByNode(Node head){
		Node cur = head;
		Node prev = null;
		Node nextNode = null;
		while(cur!=null){
			nextNode = cur.next;//backup
			cur.next = prev; //creates Links
			prev = cur; //prev moves forward
			cur = nextNode; //current moves forward
		}
		return prev;
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
	
	public Node getMidNode(){
		Node fast = head;
		Node slow = head;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public Node getMiddleNode(Node start , Node end){
		Node fast = head;
		Node slow = head;
		while(fast!=end && fast.next!=end){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public LinkedListCustom mergeSort(Node start , Node end){
		if(start == end){
			LinkedListCustom baseResult = new LinkedListCustom();
			baseResult.addLast(start.data);
			return baseResult;
		}	
		Node mid = getMiddleNode(start , end);
		LinkedListCustom first = mergeSort(start , mid);
		LinkedListCustom second = mergeSort(mid.next , end);
		LinkedListCustom sortedList = mergeSortedLists(first , second);
		return sortedList;
	}

	private LinkedListCustom mergeSortedLists(LinkedListCustom list1, LinkedListCustom list2) {
		Node one = list1.head;
		Node two = list2.head;
		LinkedListCustom list = new LinkedListCustom();
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

	public void removeDuplicate(){
		Node cur = head;
		while(cur!=null && cur.next!=null){
			Node temp = cur;
			while(temp.next!=null && temp.next.data == temp.data)
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
	
	public void foldLinkedList(){
		Node midNode = getMidNode();
		Node nHead = midNode.next;
		midNode.next = null;
		nHead = reverseByNode(nHead);	
		Node c1 = head;
		Node c2 = nHead;
		Node f1 = null;
		Node f2 = null;
		while(c2!=null){
			f1 = c1.next;
			f2 = c2.next;
			
			c1.next = c2;
			c2.next = f1;
			
			c1= f1;
			c2= f2;
		}
		printListCustom(head);
	}
	
	public void oddEvenSegregate(){
		LinkedListCustom oddll = new LinkedListCustom();
		LinkedListCustom evenll = new LinkedListCustom(); 
		while(this.size > 0){
			int val = this.getFirst();
			this.removeFirst();
			if(val%2 == 0){
				evenll.addLast(val);
			}else{
				oddll.addLast(val);
			}	
		}
		oddll.tail.next = evenll.head;
		this.head = oddll.head;
		this.tail = evenll.tail;
		this.size = oddll.size + evenll.size;
	}

	public Node mergeTwoSortedLists(Node head1, Node head2) {
		Node dummyNode = new Node(-1);
		Node prev = dummyNode;
		Node temp1 = head1;
		Node temp2 = head2;
		while(temp1!=null && temp2!=null){
			if(temp1.data < temp2.data){
				prev.next = temp1;
				temp1 = temp1.next;
			}else{
				prev.next = temp2;
				temp2 = temp2.next;
			}
			prev = prev.next;
		}
		while(temp1!=null){
			prev.next = temp1;
			temp1 = temp1.next;
		}
		while(temp2!=null){
			prev.next = temp2;
			temp2=  temp2.next;
		}
		return dummyNode.next;
	}
}
