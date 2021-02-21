package com.prep.interview.BinaryTrees;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Integer arr[] = {1,2,4,null,null,5,null,null,3,null,6,null,null};
		Node root = tree.constructBinaryTree(arr);
		levelOrder(root);
		
	}
	
	public static void levelOrder(Node node){
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(node);
		while(!q.isEmpty()){
			int count = q.size();
			for(int i = 0 ; i < count ; i++){
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