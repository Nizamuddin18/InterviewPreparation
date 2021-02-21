package com.prep.interview.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GraphExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = 7;
		Graph g = new Graph(vertices);
		System.out.println("1.Breadth First Search");
		System.out.println("2.Depth First Search");
		System.out.println("3.Has Path");
		System.out.println("4.Print All Paths");
		System.out.println("5.Connected Components");
		System.out.println("6.Is Graph Connected");
		System.out.println("7.Hamiltonian Path/Cycle");
		System.out.println("8.Dijkstra's");
		System.out.println("9.Prims");
		System.out.println("10.Is Cyclic");

		System.out.println("Enter Your Choice");
		int choice = sc.nextInt();
		switch(choice){
		case 1 :
			bfs(g , vertices);
			break;
		case 2 : 
			dfs(g , vertices);
			break;
		case 3 : 
			hasPathCheck(g , vertices);
			break;
		case 4 : 
			printAllPathCheck(g , vertices);
			break;
		case 5 :
			getConnectedComponents(g , vertices);
			break;
		case 6 : 
			isGraphConnected(g , vertices);
			break;
		case 7 : 
			hamiltonian(g , vertices);
			break;
		case 8 :
			dijkstra(g , vertices);
			break;
		case 9 : 
			prim(g , vertices);
			break;
		case 10 :
			cycle(g , vertices);
			break;
		}
	}
	
	private static void cycle(Graph g, int vertices){
		g.addEdge(0, 1, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(3, 4, 15);
		g.addEdge(5, 6, 15);
		g.addEdge(4, 6, 15);
		boolean visited[] = new boolean[vertices];
		System.out.print("IS CYCLIC USING BFS : ");
		for(int v = 0; v < vertices ; v++){
			if(visited[v] == false){
				boolean cycle = g.isCycle(v, visited);
				if(cycle){
					System.out.println("TRUE");
					return;
				}
			}
		}
		System.out.println("FALSE");	
	}
	
	private static void prim(Graph g, int vertices){
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 25);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 8);
		g.addEdge(5, 6, 3);
		boolean visited[] = new boolean[vertices];
		g.prims(0, -1, 0, visited);
	}
	
	private static void dijkstra(Graph g , int vertices){
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 40);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 3);
		g.addEdge(4, 6, 8);
		g.addEdge(5, 6, 3);
		boolean visited[] = new boolean[vertices];
		g.dijkstras(0, 0 + "", 0, visited);
	}
	private static void hamiltonian(Graph g, int vertices) {
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 10);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(2, 5, 10);
		g.addEdge(3, 4, 10);
		g.addEdge(4, 5, 10);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 10);
		HashSet <Integer> visited = new HashSet<>();
		g.isHamiltonian(0, visited, 0+"", 0);
		
	}

	private static void dfs(Graph g , int vertices){
		/*g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 10);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 10);
		g.addEdge(4, 5, 10);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 10);*/
		
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 3, 10);
		g.addEdge(1, 4, 10);
		g.addEdge(2, 5, 10);
		g.addEdge(2, 6, 10);
		boolean visited[] = new boolean[vertices];
		g.depthFirstSearch(0 , visited);
		
	}
	
	
	private static void bfs(Graph g, int vertices) {
		/*vertices = 6;
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 3, 12);
		g.addEdge(2, 4, 10);
		g.addEdge(1, 4, 15);
		g.addEdge(3, 4, 12);
		g.addEdge(3, 5, 10);
		g.addEdge(4, 5, 12);*/
		
		/*g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 10);
		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 10);
		g.addEdge(4, 5, 10);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 10);*/
		
		g.addEdge(0, 1, 10);
		g.addEdge(0, 2, 10);
		g.addEdge(1, 3, 10);
		g.addEdge(1, 4, 10);
		g.addEdge(2, 5, 10);
		g.addEdge(2, 6, 10);
		boolean visited[] = new boolean[vertices];
		g.breadthFirstSearch(0, visited);
		
	}

	private static void isGraphConnected(Graph g, int vertices) {
		g.addEdge(0, 1, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(4, 5, 15);
		g.addEdge(5, 6, 15);
		g.addEdge(4, 6, 15);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for(int  i = 0; i < vertices;i++){
			if(visited[i] == false){
				ArrayList <Integer> comp = new ArrayList<>();
				g.drawTreeAndGenerateComp(i , comp , visited); 
				comps.add(comp);
			}	
		}
		if(comps.size() == 1)
			System.out.println("true");
		else
			System.out.println("false");
		
	}

	private static void getConnectedComponents(Graph g, int vertices) {
		g.addEdge(0, 1, 15);
		g.addEdge(2, 3, 15);
		g.addEdge(4, 5, 15);
		g.addEdge(5, 6, 15);
		g.addEdge(4, 6, 15);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for(int  i = 0; i < vertices;i++){
			if(visited[i] == false){
				ArrayList <Integer> comp = new ArrayList<>();
				g.drawTreeAndGenerateComp(i , comp , visited); 
				comps.add(comp);
			}	
		}
		System.out.println(comps);
	}

	private static void printAllPathCheck(Graph g , int vertices) {
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 15);
		g.addEdge(1, 2, 12);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 15);
		g.addEdge(4, 5, 12);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 12);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		g.printAllPaths(0, 6, visited, 0 + "");
	}

	private static void hasPathCheck(Graph g , int vertices) {
		g.addEdge(0, 1, 10);
		g.addEdge(0, 3, 15);
		g.addEdge(1, 2, 12);
		g.addEdge(2, 3, 10);
		g.addEdge(3, 4, 15);
		g.addEdge(4, 5, 12);
		g.addEdge(4, 6, 10);
		g.addEdge(5, 6, 12);
		System.out.println(g);
		boolean visited[] = new boolean[vertices];
		boolean ret_val = g.hasPath(0, 6, visited);
		System.out.println("Has Path : " + ret_val);
	}

	
}
