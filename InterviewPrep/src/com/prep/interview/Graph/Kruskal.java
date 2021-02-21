package com.prep.interview.Graph;

import java.util.Arrays;

public class Kruskal {
	class Edge{
		int src;
		int dest;
		int wt;
		public Edge(){
			src = 0 ; dest = 0 ; wt = 0;
		}
	}
	
	class Node{
		int parent;
		int rank;
		public Node(){
			parent = 0;
			rank = 0;
		}
	}
	Edge edge[];
	int V,E;
	
	public Kruskal(int v , int e){
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i = 0; i < E ; i++)
			edge[i] = new Edge();
	}
	
	public String toString(){
		String result = "";
		for(int i = 0 ; i < edge.length ; i++){
			result = result +  edge[i].src +"," + edge[i].dest + "," + edge[i].wt + "\n";
		}
		//System.out.println(result);
		return result;
	}
	
	public int find(Node[] node , int root){
		if(node[root].parent != -1)
			node[root].parent = find(node , node[root].parent);
		return node[root].parent;	
	}
	
	public void union(Node node[] , int src , int dest){
		int srcroot = find(node , src);
		int destroot = find(node , dest);
		if(node[srcroot].parent < node[destroot].parent)
			node[srcroot].parent = destroot;
		else if(node[destroot].parent < node[srcroot].parent)
			node[destroot].parent = srcroot;
		else{
			node[srcroot].parent = destroot;
			node[destroot].rank++;
		}
	}
	public void mstKruskal(Kruskal graph){
		Edge result[] = new Edge[V]; 
        int e = 0; 
        int i = 0; 
        for (i = 0; i < V; ++i)
            result[i] = new Edge();
 
        // Step 1:  Sort all the edges in non-decreasing
        // order of their weight.  If we are not allowed to
        // change the given graph, we can create a copy of
        // array of edges
        Arrays.sort(edge);
 
        // Allocate memory for creating V ssubsets
        Node node[] = new Node[V];
        for (i = 0; i < V; ++i)
            node[i] = new Node();
        for (int v = 0; v < V; ++v) 
        {
            node[v].parent = -1;
            node[v].rank = 0;
        }
        
        while (e < V - 1) 
        {
            // Step 2: Pick the smallest edge. And increment
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(node, next_edge.src);
            int y = find(node, next_edge.dest);
 
            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y) {
                result[e++] = next_edge;
                union(node, x, y);
            }
            // Else discard the next_edge
        }
        
        System.out.println("Following are the edges in "
                + "the constructed MST");
		int minimumCost = 0;
		for (i = 0; i < e; ++i)
		{
		 System.out.println(result[i].src + " -- "
		                    + result[i].dest
		                    + " == " + result[i].wt);
		 minimumCost += result[i].wt;
		}
		System.out.println("Minimum Cost Spanning Tree "
		                + minimumCost);
 
	}

	public static void main(String[] args) {
		int vertices = 6;
		int edges = 10;
		Kruskal graph = new Kruskal(vertices , edges);
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].wt = 1;
		
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].wt = 2;
		
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].wt = 3;
		
		graph.edge[3].src = 1;
		graph.edge[3].dest = 4;
		graph.edge[3].wt = 3;
		
		graph.edge[4].src = 2;
		graph.edge[4].dest = 4;
		graph.edge[4].wt = 1;
		
		graph.edge[5].src = 1;
		graph.edge[5].dest = 3;
		graph.edge[5].wt = 1;
		
		graph.edge[6].src = 2;
		graph.edge[6].dest = 3;
		graph.edge[6].wt = 2;
		
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].wt = 2;
		
		graph.edge[8].src = 4;
		graph.edge[8].dest = 5;
		graph.edge[8].wt = 3;
		
		graph.edge[9].src = 3;
		graph.edge[9].dest = 5;
		graph.edge[9].wt = 4;
		
		System.out.println(graph);
		
		
	}

}
