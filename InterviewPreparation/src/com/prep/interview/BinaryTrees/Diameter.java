package com.prep.interview.BinaryTrees;

public class Diameter {
	private static int height(Node node) {
		if(node == null) return -1;
		int lheight = height(node.left);
		int rheight = height(node.right);
		return Math.max(lheight, rheight) + 1;
	}
	private static int diameter1(Node node){
		if(node == null) return 0;
		//max distance between 2 nodes at LHS
		int leftdia = diameter1(node.left);
		//max distance between 2 nodes at RHS
		int rightdia = diameter1(node.right);
		//max distance between left's deepest and right's deepest
		int factor = height(node.left) + height(node.right) + 2;
		int dia = Math.max(factor, Math.max(leftdia, rightdia));
		return dia;
	}
	
	static class DiaPair{
		int height;
		int dia;
		DiaPair(){
			this.height = -1;
			this.dia = 0;
		}
	}
	
	public static DiaPair diameter2(Node node){
		if(node == null){
			DiaPair basepair = new DiaPair();
			return basepair;
		}
		DiaPair leftpair = diameter2(node.left);
		DiaPair rightpair = diameter2(node.right);
		
		DiaPair mypair = new DiaPair();
		mypair.height = Math.max(leftpair.height, rightpair.height) + 1;
		int factor = leftpair.height + rightpair.height + 2;
		mypair.dia = Math.max(factor, Math.max(leftpair.dia, rightpair.dia));
		
		return mypair;
	}
	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		Node root = tree.constructBinaryTree();
		int diameter = diameter1(root);
		DiaPair pair = diameter2(root);
		//System.out.println("Diameter of Binary Tree : " + diameter);
		System.out.println("Diameter of Bianry Tree : " + pair.dia);
	}

}
