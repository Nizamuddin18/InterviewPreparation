package com.prep.interview.BinaryTrees;
import java.util.*;
public class NodeToRootPath {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		NodeToRootPath ntrp = new NodeToRootPath();
		Node root = tree.constructBinaryTree();
		int data = 70;
		ArrayList<Node> path = new ArrayList<>();
		boolean ret_val = ntrp.findNodeToRootPath(root , data , path);
		System.out.println("Does for given Node(" + data + ") any Path to Root exist ? " + ret_val);
		System.out.println("Path : " + path);

	}
	
	public boolean findNodeToRootPath(Node node , int data , ArrayList<Node> path){//Initially root is passed
		if(node == null)
			return false;
		if(node.val == data){
			path.add(node);//the given node matches thus this path will be added
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
