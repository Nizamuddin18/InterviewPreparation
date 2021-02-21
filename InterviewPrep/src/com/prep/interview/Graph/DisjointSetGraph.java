package com.prep.interview.Graph;

public class DisjointSetGraph {
	class Edge{
		int src , dest;
	}
	
	int V,E;//no of vertices and edges
	Edge edge[];
	public DisjointSetGraph(int v , int e){
		V = v;
		E = e;
		edge = new Edge[e];
		for(int i = 0 ; i < e ; i++){
			edge[i] = new Edge();
		}
	}
	
	public int find(int [] parent , int src)
	{
		if(parent[src] == -1)
			return src;
		return find(parent , parent[src]);
		
	}
	 
	public void union(int [] parent , int abs_x , int abs_y){
		int xset = find(parent , abs_x);
		int yset = find(parent , abs_y);
		parent[xset] = yset;
	}
	
	public boolean isCyclic(DisjointSetGraph graph){
		int [] parent = new int[graph.V];
		for(int i = 0 ; i < graph.V ; ++i){
			parent[i] = -1;
		}
		for(int i = 0 ; i < graph.E ; ++i){
			int x = graph.find(parent , graph.edge[i].src);
			int y = graph.find(parent , graph.edge[i].dest);
			if(x == y)
				return true;
			
			union(parent , x , y);
		}
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		int vertices = 5;
		int edges = 5;
		DisjointSetGraph graph = new DisjointSetGraph(vertices , edges);
		
		// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 2-3
        graph.edge[1].src = 2;
        graph.edge[1].dest = 3;
 
        // add edge 1-2
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        
        // add edge 0-4
        graph.edge[3].src = 0;
        graph.edge[3].dest = 4;
        
        // add edge 4-3
        graph.edge[4].src = 4;
        graph.edge[4].dest = 3;
        
        if(graph.isCyclic(graph))
        	System.out.println("Graph contains cycle");
        else
        	System.out.println("Graph doesn't contains cycle");
	}

}
