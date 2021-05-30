package com.prep.interview.BinaryTrees;

public class TransformToLeftClonedTree {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		System.out.println("INITIAL TREE : ");
		System.out.println();
		tree.display(root);
		Node newRoot = transformToLeftCloned(root);
		System.out.println("=============================");
		System.out.println("LEFT CLONED TREE : ");
		System.out.println();
		tree.display(newRoot);
	}
	
	private static Node transformToLeftCloned(Node node){
		if(node == null){
			return null;
		}
		Node leftCloneRoot = transformToLeftCloned(node.left);
		Node rightCloneRoot = transformToLeftCloned(node.right);
		Node newNode = new Node(node.val , leftCloneRoot , null);
		node.left = newNode;
		node.right = rightCloneRoot;
		return node;
	}
}
