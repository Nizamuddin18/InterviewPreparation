package com.prep.interview.BinaryTrees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class PrintLeftView {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Integer arr[] = {1,2,4,null,null,5,null,null,3,null,6,null,null};
		Node root = tree.constructBinaryTree(arr);
		//tree.display(root);
		printleftView(root);
	}
	
	public static void printleftView(Node node){
		Queue<Node> q = new ArrayDeque<Node>();
		q.add(node);
		while(!q.isEmpty()){
			int count = q.size();
			for(int i = 0 ; i < count ; i++){
				Node rem = q.remove();	
				if(i ==0)
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
