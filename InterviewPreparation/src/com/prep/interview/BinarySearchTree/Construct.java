package com.prep.interview.BinarySearchTree;

public class Construct {

	public Node constructBST(){
		int arr[] = {12,25,30,37,40,50,55,62,70,75,87};
		int high = arr.length - 1;
		int low = 0;
		Node root = constructBST(arr,low,high);
		return root;
	}

	private Node constructBST(int[] arr, int low , int high) {
		if(low > high) return null;
		
		int mid = low + (high - low)/2;
		int data = arr[mid];
		Node leftChild = constructBST(arr , low , mid-1);
		Node rightChild = constructBST(arr , mid+1 , high);
		Node node = new Node(data , leftChild , rightChild);
		return node;
	}
	
	public void display(Node node) {
		if (node == null) return;
		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public static void main(String args[]){
		Construct bst = new Construct();
		Node root = bst.constructBST();
		bst.display(root);
	}

}
