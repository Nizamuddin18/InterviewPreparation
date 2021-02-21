package com.prep.interview.Graph;
import java.util.*;

public class BellmanFord {
	class Edge{
		int src;
		int dest;
		int weight;
		public Edge(){
			src = 0;
			dest = 0;
			weight = 0;
		}
	}
	
	int V,E;
	Edge[] edge;
	public BellmanFord(int v , int e){
		V = v;
		E = e;
		edge = new Edge[e];
		for(int i = 0 ; i < e ; i++)
			edge[i] = new Edge();	
	}
	
	public boolean bellmanFord(BellmanFord graph , int src){
		int vertices = graph.V;
		int edges = graph.E;
		int dist[] = new int[vertices];
		for(int i = 0 ; i < dist.length ; i++)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;
		for(int i = 1 ; i < vertices ; i++){
			for(int j = 0 ; j < edges ; j++){
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if(dist[u]!=Integer.MAX_VALUE && dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
				
			}
		}
		
		for (int j = 0; j < edges; ++j) { 
            int u = graph.edge[j].src; 
            int v = graph.edge[j].dest; 
            int weight = graph.edge[j].weight; 
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
               // System.out.println("Graph contains negative weight cycle"); 
                return false; 
            } 
        } 
		printGraph(dist ,vertices);
		return true;
	}

	public static void printGraph(int dist[] , int vertices){
		System.out.println("Vertex Distance from Source"); 
        for (int i = 0; i < vertices; ++i) 
            System.out.println(i + "\t\t" + dist[i]); 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Vertcies and Edges of the Graph");
		int v = sc.nextInt();
		int e = sc.nextInt();
		BellmanFord graph = new BellmanFord(v , e);
		
		 // add edge 0-1 (or A-B in above figure) 
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = -1; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 4; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src = 1; 
        graph.edge[2].dest = 2; 
        graph.edge[2].weight = 3; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 2; 
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = 1; 
        graph.edge[4].dest = 4; 
        graph.edge[4].weight = 2; 
  
        // add edge 3-2 (or D-C in above figure) 
        graph.edge[5].src = 3; 
        graph.edge[5].dest = 2; 
        graph.edge[5].weight = 5; 
  
        // add edge 3-1 (or D-B in above figure) 
        graph.edge[6].src = 3; 
        graph.edge[6].dest = 1; 
        graph.edge[6].weight = 1; 
  
        // add edge 4-3 (or E-D in above figure) 
        graph.edge[7].src = 4; 
        graph.edge[7].dest = 3; 
        graph.edge[7].weight = -3;
        
        boolean ans = graph.bellmanFord(graph, 0);
        if(ans == false){
        	System.out.println("Graph contains negative weight cycle"); 
        }
	}

}
