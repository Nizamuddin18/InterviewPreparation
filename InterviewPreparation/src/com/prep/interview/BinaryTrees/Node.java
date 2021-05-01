/**
 * 
 */
package com.prep.interview.BinaryTrees;

class Pair{
	Node node;
	int state;
	Pair(Node node,int state){
		this.node = node;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Pair [node=" + node + ", state=" + state + "]";
	}
	
}


public class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int val , Node left , Node right){
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "" + val;
	}
	
}
