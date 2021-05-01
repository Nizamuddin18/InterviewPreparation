package com.prep.interview.BinaryTrees;

public class TraversalRecursive {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Integer arr[] = {50 ,25 ,12 ,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		Node root = tree.constructBinaryTree(arr);
		System.out.println("Recursive Traversal : ");
		System.out.print("Inorder :  ");
		inOrderTraversal(root);
		System.out.println();
		System.out.print("Preorder : ");
		preOrderTraversal(root);
		System.out.println();
		System.out.print("Postorder: ");
		postOrderTraversal(root);
		System.out.println();
	}
	
	  public static void inOrderTraversal(Node node){
		  if(node == null){
			  return;
		  }
		  inOrderTraversal(node.left);
		  System.out.print(node.val + " ");
		  inOrderTraversal(node.right);
	  }
	  
	  public static void preOrderTraversal(Node node){
		  if(node == null){
			  return;
		  }
		  System.out.print(node.val + " ");
		  preOrderTraversal(node.left);
		  preOrderTraversal(node.right);
	  }
	  
	  public static void postOrderTraversal(Node node){
		  if(node == null){
			  return;
		  }
		  postOrderTraversal(node.left);
		  postOrderTraversal(node.right);
		  System.out.print(node.val + " ");
	  }

}
