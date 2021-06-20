package com.prep.interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BreadthFirstSearch {
	public static class Edge{
		int nbr;
		int wt;
		Edge(int nbr , int wt){
			this.nbr = nbr;
			this.wt = wt;
		}
		@Override
		public String toString() {
			return "(" + nbr + "," + wt + ")";
		}
	}
	static ArrayList<Edge>[] graph;
	
	// Graph Constructor
	BreadthFirstSearch(int vertices){
		graph = new ArrayList[vertices];
		for(int i = 0 ; i < graph.length ; i++)
			graph[i] = new ArrayList<>();
	}
	
	public static void addEdge(int src , int dest , int wt){
		graph[src].add(new Edge(dest , wt)); // src - > dest with weight wt
	}
	
	@Override
	public String toString() {
		String res = "";
		for(int i = 0 ; i < graph.length ; i++){
			res += "[" + i + " => " + graph[i] + "]";
		}
		return res;
	}

	public static void bfs(int src , boolean visited[]){
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(src);
		while(!queue.isEmpty()){
			int data = queue.remove(); 	//Remove
			if(visited[data] == true)
				continue;
			visited[data] = true; 		//Mark*
			System.out.println(data);	//Work
			for(Edge e : graph[data]){	//Add*
				if(visited[e.nbr] == false)
					queue.add(e.nbr);
			}
		}
	}
	
	public static void main(String[] args) {
		int vertices = 7;
		BreadthFirstSearch bfs = new BreadthFirstSearch(vertices);
		addEdge(0, 1, 10);
		addEdge(0, 3, 15);
		addEdge(1, 2, 12);
		addEdge(2, 3, 10);
		addEdge(3, 4, 15);
		addEdge(4, 5, 12);
		addEdge(4, 6, 10);
		addEdge(5, 6, 12);
		
		boolean visited[] = new boolean[vertices];
		bfs(0 , visited);
	}

}
