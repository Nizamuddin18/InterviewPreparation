package com.prep.interview.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import com.prep.interview.Graph.MColoringProblem.Edge;

public class Bipartite {
	class Pair{
		int src;
		String psf;
		int level;
		Pair(int src , String psf , int level){
			this.src = src;
			this.psf = psf;
			this.level = level;
		}
	}
	class Edge{
		int nbr;
		int wt;
		Edge(int nbr , int wt){
			this.nbr = nbr;
			this.wt = wt;
		}
		public String toString(){
			return "(" + nbr + "," + wt +")";
		}
	}
	ArrayList<Edge> graph[];
	public Bipartite(int vertices){
		graph = new ArrayList[vertices];
		for(int i = 0 ; i < vertices ; i++)
			graph[i] = new ArrayList<>();
	}
	
	public String toString(){
		String retString = "";
		for(int i = 0 ; i < graph.length ; i++){
			retString += i +" => " +graph[i] + "\n";
		}
		return retString;
	}
	public void addEdge(int src , int dest , int wt){
		graph[src].add(new Edge(dest , wt));
		graph[dest].add(new Edge(src , wt));

	}
	
	public boolean isComponentBipartite(int vertices , int visited[] , int src){
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src , src + "" , 0));
		while(queue.size() > 0){
			Pair rem = queue.removeFirst();
			if(visited[rem.src] != -1){ //already visited
				if(rem.level != visited[rem.src]){
					return false;
				}
			}else{
				visited[rem.src] = rem.level;
			}
			for(Edge edge : graph[rem.src]){
				if(visited[edge.nbr] == -1){
					queue.add(new Pair(edge.nbr , edge.nbr + rem.psf , rem.level+1));
				}
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		int vertices = 6;
		Bipartite graph = new Bipartite(vertices);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 10);
		graph.addEdge(1, 3, 10);
		graph.addEdge(2, 4, 10);
		graph.addEdge(3, 5, 10);
		graph.addEdge(4, 5, 10);
		//System.out.println(graph);
		int visited[] = new int[vertices];
		Arrays.fill(visited, -1);
		System.out.println("IS Graph Bipartite for " + vertices + " vertices ? ");
		for(int v = 0 ; v < vertices ; v++){
			if(visited[v] == -1){
				boolean checkBipartite = graph.isComponentBipartite(vertices , visited , v);
				if(checkBipartite == false){
					System.out.println("FALSE ");
					System.exit(0);
				}
			}
		}
		System.out.println("TRUE ");

	}

}
