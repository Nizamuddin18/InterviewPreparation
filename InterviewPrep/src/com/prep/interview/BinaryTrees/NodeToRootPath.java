package com.prep.interview.BinaryTrees;
import java.util.*;
public class NodeToRootPath {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		NodeToRootPath ntrp = new NodeToRootPath();
		Integer arr[] = {50 ,25 ,12 ,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root = tree.constructBinaryTree(arr);
		int data = 70;
		ArrayList<Node> path = new ArrayList<>();
		boolean ret_val = ntrp.findNodeToRootPath(root , data , path);
		System.out.println("Node to Root Path exist : " + ret_val);
		System.out.println("Path : " + path);

	}
	
	public boolean findNodeToRootPath(Node node , int data , ArrayList<Node> path){//Initially root is passed
		if(node == null)
			return false;
		if(node.val == data){
			path.add(node);
			return true;
		}
		boolean leftChild = findNodeToRootPath(node.left , data , path);
		if(leftChild){
			path.add(node);
			return true;
		}
		boolean rightChild = findNodeToRootPath(node.right , data , path);
		if(rightChild){
			path.add(node);
			return true;
		}
		return false;
	}

}
