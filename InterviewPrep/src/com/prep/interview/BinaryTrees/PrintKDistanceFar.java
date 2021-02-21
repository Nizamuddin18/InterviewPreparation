package com.prep.interview.BinaryTrees;
import java.util.*;
import com.prep.interview.BinaryTrees.PrintKLevelsDown;
public class PrintKDistanceFar {

	public static void main(String[] args) {
		ConstructBinaryTree tree = new ConstructBinaryTree();
		NodeToRootPath ntrp = new NodeToRootPath();
		PrintKDistanceFar p = new PrintKDistanceFar();
		//Integer arr[] = {50 ,25 ,12 ,null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		
		//Node root = tree.constructBinaryTree(arr);
		Node root = new Node(50,null,null);
		root.left = new Node(25,null,null);
		root.left.left = new Node(12,null,null);
		root.left.right = new Node(37,null,null);
		root.left.right.left = new Node(30,null,null);
		root.right= new Node(75,null,null);
		root.right.left = new Node(62,null,null);
		root.right.left.right = new Node(70,null,null);
		root.right.right = new Node(87,null,null);
		tree.display(root);
		ArrayList<Node> path = new ArrayList<>();
		int k = 2;
		boolean pathToRoot = ntrp.findNodeToRootPath(root, 75, path);
		p.printklevelsFar(root, path, k);
	}
	
	private void printklevelsFar(Node node, ArrayList<Node> path , int k){
		System.out.println(path);
		for(int  i = 0 ; i < path.size() ; i++){
			printKLevelsDown(path.get(i), k-i , i==0 ? null : path.get(i));
		}
		
	}
	
	private static void printKLevelsDown(Node node , int k , Node blocker){
		if(node == null || k < 0 || node == blocker){
			return;
		}
		if(k==0){
			System.out.print(node.val + " ");
		}
		printKLevelsDown(node.left , k-1 , blocker);
		printKLevelsDown(node.right , k-1 , blocker);
	}

}
