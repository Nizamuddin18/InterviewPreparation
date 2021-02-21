package com.prep.interview.Graph;
import java.util.ArrayList;



public class CycleDetectionDFS {
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
	
	ArrayList<Edge> graph[];
	public CycleDetectionDFS(int vertices){
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
	
	public void isCycle(int vertices){
		boolean visited[] = new boolean[vertices];
		boolean result = isCycleHelper(0 , visited , -1);
		if(result)
			System.out.println("CYCLE DETECTED!");
		else
			System.out.println("NO CYCLE DETECTED!");
	}
	
	public boolean isCycleHelper(int src , boolean visited[] , int parent){
		visited[src] = true;
		for(Edge edge : graph[src]){
			if(visited[edge.nbr] == false){
				boolean ret_cycle = isCycleHelper(edge.nbr , visited , src);
				if(ret_cycle)
					return true;
			}else if(edge.nbr!=parent){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int vertices = 5;
		CycleDetectionDFS graph = new CycleDetectionDFS(vertices);
		graph.addEdge(1, 0, 10);
		graph.addEdge(0, 4, 15);
		graph.addEdge(4, 3, 10);
		graph.addEdge(3, 2, 15);
		graph.addEdge(2, 1, 10);
		System.out.println(graph);
		graph.isCycle(vertices);
	}

}
