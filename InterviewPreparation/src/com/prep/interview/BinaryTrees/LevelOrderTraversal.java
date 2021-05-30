package com.prep.interview.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		System.out.println(" ::::: Level Order Traversal of Tree ::::: " );
		levelOrder(root);
		
	}
	
	public static void levelOrder(Node node){
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(node);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i = 0 ; i < size ; i++){
				Node rem = q.remove();	
				System.out.print(rem.val + " ");
				if(rem.left!=null){
					q.add(rem.left);
				}
				if(rem.right!=null){
					q.add(rem.right);
				}
			}
			System.out.println();
		}
	}

}
