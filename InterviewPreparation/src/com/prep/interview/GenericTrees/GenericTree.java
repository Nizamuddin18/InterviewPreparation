package com.prep.interview.GenericTrees;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	ArrayList<Node> children;

	Node() {
		this.data = 0;
		this.children = new ArrayList<>();
	}

	Node(int data) {
		this.data = data;
		this.children = new ArrayList<>();
	}
	/*
	 * @Override public String toString() { return "[" + data + "]"; }
	 */

}
public class GenericTree {
	
	
	public static void display(Node node){
		String str = "[" + node.data + "] -> ";
		for(Node child : node.children){
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);
		
		for (int i = 0; i < node.children.size(); i++) {
			Node child = node.children.get(i);
			display(child);
		}
	}
	
	public static Node constructTree(int arr[]){
		Stack<Node> st = new Stack<>();
		Node root = null;
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] == -1){
				st.pop();
			}else{
				Node node = new Node(arr[i]);
				
				if(st.isEmpty()){
					root = node;		
				}else{
					st.peek().children.add(node);
				}
				st.push(node);
			}
		}
		return root;
	}
	
	public static int size(Node node){
		int size = 0;
		//calculating the size of child nodes
		for(Node child : node.children){
			int childSize = size(child);
			size += childSize;
		}
		size += 1; //size of node itself
		return size;
	}
	
	public static int getMax(Node node){
		int max = Integer.MIN_VALUE;
		for(Node child : node.children){
			max = Math.max(max, getMax(child));
		}
		max = Math.max(max, node.data);
		return max;
	}
	
	public static int getMin(Node node){
		int min = Integer.MAX_VALUE;
		for(Node child : node.children){
			min = Math.min(min, getMin(child));
		}
		min = Math.min(min, node.data);
		return min;
	}
	
	//Height - > Edge wise i,e from Root to Depth of tree get Maximum edged Height
	public static int height(Node node){
		int height = -1;
		for(Node child : node.children){
			height = Math.max(height, height(child));
		}
		height += 1;
		return height;
	}
	
	public static void levelOrderPrint(Node node){
		/*Algo
		Remove from Queue
		Mark 
		Visit Child
		Add to Queue*/
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node rem = queue.remove();
			System.out.print(rem.data + " ");
			for(Node child : rem.children){
				queue.add(child);
			}
		}
		System.out.println();
	}
	
	public static void levelOrderLineWise1(Node node){
		Queue<Node> mainQ = new ArrayDeque<>();
		Queue<Node> childQ = new ArrayDeque<>();
		mainQ.add(node);
		while(!mainQ.isEmpty()){
			Node rem = mainQ.remove();
			System.out.print(rem.data + " ");
			for(Node child : rem.children){
				childQ.add(child);
			}
			if(mainQ.isEmpty()){
				mainQ = childQ;
				childQ = new ArrayDeque<>();
				System.out.println();
			}
		}
	}
	
	public static void levelOrderLineWise2(Node node){
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		queue.add(null);
		while(!queue.isEmpty()){
			Node rem = queue.remove();
			if(rem == null){
				if(!queue.isEmpty()){
					queue.add(null);
					System.out.println();
				}
			}else{
				System.out.print(rem.data + " ");
				for(Node child : rem.children){
					queue.add(child);
				}
			}
		}
		System.out.println();
	}
	
	public static void levelOrderLineWise3(Node node){
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()){
			int curSize = queue.size();
			for(int i = 0 ; i < curSize ; i++){
				Node rem = queue.remove();
				System.out.print(rem.data + " ");
				for(Node child : rem.children){
					queue.add(child);
				}
			}
			System.out.println();
		}
	}
	
	public static void lineWiseZigZag(Node node){
		Stack<Node> mainStack = new Stack<>();
		Stack<Node> childStack = new Stack<>();
		int level = 1;
		mainStack.push(node);
		while(!mainStack.isEmpty()){
			Node rem = mainStack.pop();
			System.out.print(rem.data + " ");
			if(level % 2 == 1){
				//Move Left to Right i.e its Child will be printed right to Left
				for(int i = 0 ; i < rem.children.size() ; i++){
					Node child = rem.children.get(i);
					childStack.push(child);
				}
			}else{
				//Move Right to Left i.e its Child will be printed left to Right
				for(int i = rem.children.size() - 1 ; i >= 0  ; i--){
					Node child = rem.children.get(i);
					childStack.push(child);
				}
			}
			
			if(mainStack.isEmpty()){
				mainStack = childStack;
				childStack = new Stack<>();
				System.out.println();
				level++;
			}
		}
	}
	
	public static ArrayList<Integer> nodeToRootPath(Node node , int target){
		if(node.data == target) {
			ArrayList<Integer> bres = new ArrayList<>();
			bres.add(node.data);
			return bres;
		}
		
		for(Node child : node.children){
			ArrayList<Integer> pathChild = nodeToRootPath(child , target);
			if(pathChild.size() > 0){
				pathChild.add(node.data);
				return pathChild;
			}
		}
		return new ArrayList<>();
	}
	
	public static int LCA(Node node , int data1 , int data2){
		ArrayList<Integer> path1 = nodeToRootPath(node , data1);
		ArrayList<Integer> path2 = nodeToRootPath(node , data2);
		int i = path1.size()-1;
		int j = path2.size()-1;
		while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)){
			i--;
			j--;
		}
		i++;
		j++;
		return path1.get(i);
	}
	
	public static int distance(Node node, int data1 , int data2){
		ArrayList<Integer> path1 = nodeToRootPath(node , data1);
		ArrayList<Integer> path2 = nodeToRootPath(node , data2);
		int i = path1.size()-1;
		int j = path2.size()-1;
		while(i >= 0 && j >= 0 && path1.get(i) == path2.get(j)){
			i--;
			j--;
		}
		i++;
		j++;
		return i + j;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1,
                -1, 90, -1, -1, 40, 100, -1, -1, -1};
		Node root = constructTree(arr);
		System.out.println("1.Display Generic Tree : ");
		System.out.println("2.Size of Generic Tree : ");
		System.out.println("3.Max Node");
		System.out.println("4.Min Node");
		System.out.println("5.Height of Generic Tree : ");
		System.out.println("6.Level Order Traversal : ");
		System.out.println("7.Level Order LineWise1 : ");
		System.out.println("8.Level Order LineWise2 : ");
		System.out.println("9.Level Order LineWise3 : ");
		System.out.println("10.LineWise ZigZag : ");
		System.out.println("11.Node to Root Path : ");
		System.out.println("12.Lowest Common Ancestor : ");
		System.out.println("13.Distance Between Two Nodes : ");
		while(true){
			System.out.println("Enter Choice(Press -1 to exit) : ");
			int choice = sc.nextInt();
			switch(choice){
			case 1 : 
				display(root);
				break;
			case 2 : 
				int size = size(root);
				System.out.println("Size of Generic Tree : " + size);
				break;
			case 3 : 
				int max = getMax(root);
				System.out.println("Max Node fo Generic Tree : " + max);
				break;
			case 4 : 
				int min = getMin(root);
				System.out.println("Min Node fo Generic Tree : " + min);
				break;
			case 5 : 
				int height = height(root);
				System.out.println("Height of Generic Tree : " + height);
				break;
			case 6 : 
				levelOrderPrint(root);
				break;
			case 7 : 
				levelOrderLineWise1(root);
				break;
			case 8 :
				levelOrderLineWise2(root);
				break;
			case 9 : 
				levelOrderLineWise3(root);
				break;
			case 10 :
				lineWiseZigZag(root);
				break;
			case 11:	
				int target = 120;
				ArrayList<Integer> path  = nodeToRootPath(root , target);
				System.out.println("Node to Root Path : " + path);
				break;
			case 12 : 
				int data1 = 70;
				int data2 = 120;
				int lca = LCA(root, data1 , data2);
				System.out.println("Lowest Common Ancestor : " + lca);
				break;
			case 13 : 
				int d1 = 70;
				int d2 = 120;
				int distance = distance(root ,d1 ,d2);
				System.out.println("Distance between " + d1 + " and " + d2 + " : " + distance);
				break;
			default : 
				System.out.println("Quit...");
				System.exit(0);
			}
			
		}
	}
}
