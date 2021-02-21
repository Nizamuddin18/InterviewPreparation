package com.prep.interview.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
	class Edge{
		int v;
		int wt;
		public Edge(int v , int wt){
			this.v = v;
			this.wt = wt;
		}
		@Override
		public String toString() {
			return "(" + v + "," + wt + ")";
		}	
	}
	
	ArrayList <Edge> graph[];
	public TopologicalSort(int vertices){
		graph = new ArrayList[vertices];
		for(int  i = 0; i < vertices ; i++){
			graph[i] = new ArrayList(); // This creates a new LinkedList for all the vertices of array G.
		}
	}
	
	@Override
	public String toString() {
		String retString = "";
		for(int i = 0 ; i < graph.length; i++){
			retString = retString + i + " => " + graph[i] + "\n";
		}		
		return retString;
	}
	
	public void addEdge(int u , int v , int wt){
		graph[u].add(new Edge(v , wt));
	}

	public void topolocialSort(int src , boolean[] visited , Stack<Integer> stack){
		visited[src] = true;
		for(Edge e : graph[src]){
			if(visited[e.v] == false){
				topolocialSort(e.v , visited , stack);
			}
		}
		stack.push(src);
	}

	public static void main(String[] args) {
		System.out.println("===========================================TOPOLOGICAL SORT===========================================");
		int vertices = 7;
		TopologicalSort graph = new TopologicalSort(vertices);
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[vertices];
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 3, 15);
		graph.addEdge(1, 2, 20);
		graph.addEdge(2, 3, 10);
		graph.addEdge(4, 3, 20);
		graph.addEdge(4, 5, 10);
		graph.addEdge(5, 6, 15);
		graph.addEdge(4, 6, 10);
		//System.out.println(graph);
		for(int v = 0 ; v < vertices ; v++){
			if(visited[v] == false){
				graph.topolocialSort(v , visited , stack);
			}
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop()+"  ");

	}

}
