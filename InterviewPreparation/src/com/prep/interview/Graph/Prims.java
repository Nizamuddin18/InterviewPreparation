package com.prep.interview.Graph;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
	static class Edge implements Comparable<Edge>{
		int v;
		int wt;
		Edge(int v , int wt){
			this.v = v;
			this.wt = wt;
		}
		public String toString(){
			return "(" + this.v + ", " + this.wt + ")";
		}
		public int compareTo(Edge o){
			return this.wt - o.wt;
		}
	}
	static ArrayList<ArrayList<Edge>> graph;
	
	public String toString(){
		String str = "";
		for(int i = 0 ; i < graph.size() ; i++){
			str = str + i + " => " + graph.get(i) + "\n";
		}
		return str;
	}
	
	public static void main(String[] args) {
		int vertices = 7;
		
		graph = new ArrayList<>();
		for(int v = 0 ; v < vertices ; v++){
			graph.add(new ArrayList<>());
		}
		
		graph.get(0).add(new Edge(1 , 10));
		graph.get(0).add(new Edge(3 , 25));
		graph.get(1).add(new Edge(2 , 10));
		graph.get(2).add(new Edge(3 , 10));
		graph.get(3).add(new Edge(4 , 2));
		graph.get(4).add(new Edge(5 , 3));
		graph.get(4).add(new Edge(6 , 8));
		graph.get(5).add(new Edge(6 , 3));
		
		//Prims Algorithm
		int mst = 0;
		boolean visited[] = new boolean[graph.size()];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0 , 0));
		
		while(!pq.isEmpty()){
			Edge rem = pq.remove();
			if(visited[rem.v] == true)
				continue;
			visited[rem.v] = true;
			mst = mst + rem.wt;
			for(Edge e : graph.get(rem.v)){
				if(visited[e.v] == false){
					pq.add(e);
				}
			}
		}
		System.out.println("Minimum Spanning Tree(Cost) : " + mst);
	}
}
