package com.prep.interview.BinaryTrees;

public class PathToLeavesFRomRoot {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Integer[] arr = {50,25,12,null,null,37,30,null,null,40,null,null,75,62,60,null,null,70,null,null,87,null,null};
		Node root = tree.constructBinaryTree(arr);
		pathToLeaves(root , "" , 0,150,250);
	}

	private static void pathToLeaves(Node node, String path, int sum, int low, int high) {
		if(node == null)
			return;
		
		if(node.left == null && node.right == null){
			sum = sum + node.val;
			if(sum >= low && sum <= high){
				System.out.println("Path : " + path + node.val);
			}
			return;
		}
		pathToLeaves(node.left , path + node.val + "  " , sum + node.val , low , high);
		pathToLeaves(node.right , path + node.val + " " , sum + node.val , low , high);

	}

}
