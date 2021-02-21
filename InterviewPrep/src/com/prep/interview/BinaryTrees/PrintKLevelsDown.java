package com.prep.interview.BinaryTrees;

public class PrintKLevelsDown {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Integer arr[] = {50 ,25 ,12 ,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root = tree.constructBinaryTree(arr);
		int k = 2;
		printKLevelsDown(root , k);

	}
	
	public static void printKLevelsDown(Node node , int k){
		if(node == null || k < 0){
			return;
		}
		if(k==0){
			System.out.print(node.val + " ");
		}
		printKLevelsDown(node.left , k-1);
		printKLevelsDown(node.right , k-1);
	}

}
