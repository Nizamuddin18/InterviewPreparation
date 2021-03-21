package com.prep.interview.BinaryTrees;
import java.util.*;

public class ConstructBinaryTree {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Integer arr[] = {50 ,25 ,12 ,null, null, 37, null, 30, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root = tree.constructBinaryTree(arr);
		display(root);
	}

	public Node constructBinaryTree(Integer[] arr) {
		Stack<Pair> st = new Stack<>();
		int root_val = arr[0];
		Node root = new Node(root_val , null , null);
		Pair root_pair = new Pair(root , 1);
		st.push(root_pair);
		int idx = 0;
		while(!st.isEmpty()){
			Pair top = st.peek();
			if(top.state == 1){
				idx++;
				if(arr[idx]!=null){
					top.node.left = new Node(arr[idx] , null ,null);
					Pair leftPair = new Pair(top.node.left , 1);
					st.push(leftPair);
				}else{
					top.node.left = null;
				}
				top.state++;
			}else if(top.state == 2){
				idx++;
				if(arr[idx]!=null){
					top.node.right = new Node(arr[idx] , null ,null);
					Pair rightPair = new Pair(top.node.right , 1);
					st.push(rightPair);
				}else{
					top.node.left = null;
				}
				top.state++;
			}else{
				st.pop();
			}
		}
		return root;
	}
	
	  public static void display(Node node) {
		    if (node == null) {
		      return;
		    }

		    String str = "";
		    str += node.left == null ? "." : node.left.val + "";
		    str += " <- " + node.val + " -> ";
		    str += node.right == null ? "." : node.right.val + "";
		    System.out.println(str);
		    display(node.left);
		    display(node.right);
		  }
	  
	public Node getTreeRoot(){
		Node root = new Node(50,null,null);
		//Left Sub Tree
		root.left = new Node(25,null,null);
		root.left.left = new Node(12,null,null);
		root.left.right = new Node(37,null,null);
		root.left.right.left = new Node(30,null,null);
		
		//Right Sub Tree
		root.right= new Node(75,null,null);
		root.right.left = new Node(62,null,null);
		root.right.left.left = new Node(60,null,null);
		root.right.left.right = new Node(70,null,null);
		root.right.left.right.left = new Node(68,null,null);
		
		root.right.right = new Node(87,null,null);
		root.right.right.right = new Node(89,null,null);
		root.right.right.right.left = new Node(85,null,null);
		root.right.right.right.right = new Node(99,null,null);
		return root;
	}
}
