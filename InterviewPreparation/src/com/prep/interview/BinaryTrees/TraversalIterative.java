package com.prep.interview.BinaryTrees;
import java.util.*;
public class TraversalIterative {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Integer arr[] = {50 ,25 ,12 ,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root = tree.constructBinaryTree(arr);
		System.out.println("Iterative Traversal : ");
		inPrePostOrderTraversalIterative(root);
	}
	
	public static void inPrePostOrderTraversalIterative(Node node){
		if(node == null){
			return;
		}
		String inorder = "";
		String preorder = "";
		String postorder = "";
		Pair root_pair = new Pair(node , 1);
		Stack<Pair> stack = new Stack<>();
		stack.push(root_pair);
		while(!stack.isEmpty()){
			Pair top = stack.peek();
			if(top.state == 1){
				preorder = preorder + top.node.val + " ";
				top.state++;
				if(top.node.left != null){
					Pair left = new Pair(top.node.left , 1);
					stack.push(left);
				}
			}else if(top.state == 2){
				inorder = inorder + top.node.val + " ";
				top.state++;
				if(top.node.right!=null){
					Pair right = new Pair(top.node.right , 1);
					stack.push(right);
				}
			}else{
				postorder = postorder + top.node.val + " ";
				stack.pop();
			}
		}	
		
		System.out.println("Inorder :   " + inorder);
		System.out.println("Preorder :  " + preorder);
		System.out.println("Postorder : " + postorder);
	}
}
