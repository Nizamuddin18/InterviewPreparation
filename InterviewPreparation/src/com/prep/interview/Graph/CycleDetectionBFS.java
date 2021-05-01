package com.prep.interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.prep.interview.Graph.CycleDetectionDFS.Edge;

public class CycleDetectionBFS {
	class Edge{
		int nbr;
		int wt;
		public Edge(int nbr , int wt){
			this.nbr = nbr;
			this.wt = wt;
		}	
		public String toString(){
			return "(" + nbr + "," + wt + ")";	
		}	
	}
	class Pair{
		int v;
		String psf;
		public Pair(int v , String psf){
			this.v = v;
			this.psf = psf;
		}
	}
	
	
	ArrayList<Edge> graph[];
	public CycleDetectionBFS(int vertices){
		graph = new ArrayList[vertices];
		for(int i = 0; i < vertices ; i++)
			graph[i] = new ArrayList<>();
	}
	
	public String toString(){
		String ret_val = "";
		for(int i = 0 ; i < graph.length ; i++){
			ret_val += i + " => " + graph[i] + "\n";
		}
		return ret_val;
	}
	
	public void addEdge(int src , int dest , int wt){
		graph[src].add(new Edge(dest,wt));
		graph[dest].add(new Edge(src,wt));

	}
	
	public boolean isCycleHelper(int src , boolean visited[]){
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src , src+""));
		while(!queue.isEmpty()){
			Pair rem = queue.removeFirst();
			if(visited[rem.v] == true){
				return true;
			}
			visited[rem.v] = true;
			for(Edge edge : graph[rem.v]){
				if(visited[edge.nbr] == false){
					queue.add(new Pair(edge.nbr , rem.psf + edge.nbr));
				}
			}
		}
		return false;
	}
	public void isCycle(int vertices){
		boolean visited[] = new boolean[vertices];
		boolean result = isCycleHelper(0 , visited);
		if(result)
			System.out.println("CYCLE DETECTED!");
		else
			System.out.println("NO CYCLE DETECTED!");			
	}
	
	
	public static void main(String[] args) {
		int vertices = 5;
		CycleDetectionBFS graph = new CycleDetectionBFS(vertices);
		graph.addEdge(0, 1, 10);
		graph.addEdge(2, 3, 15);
		graph.addEdge(1, 2, 15);
		graph.addEdge(0, 4, 10);
		//graph.addEdge(4, 3, 10);
		System.out.println(graph);
		graph.isCycle(vertices);

	}

}
