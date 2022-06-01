package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private HashMap<Integer, ArrayList<Integer>> adjList;
	private int v;
	public Graph(int v) {
		this.v = v;
		adjList = new HashMap<>();
		for (int i=0; i<v; i++) {
			adjList.put(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int source, int destination) {
		adjList.get(source).add(destination);
//		adjList.get(destination).add(source);
	}
	
	// BFS traversal of graph
	public void BFS(int source) {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[source] = true;
		queue.add(source);
		
		while (!queue.isEmpty()) {
			int top = queue.poll();
			System.out.print(top + " ");
			ArrayList<Integer> adj = adjList.get(top);
			for (int a : adj) {
				if (!visited[a]) {
					queue.add(a);
					visited[a] = true;
				}
			}
		}
	}
	
	public void DFSUtil(int source, boolean[] visited) {
		if (visited[source]) {
			return;
		}
		System.out.print(source + " ");
		visited[source] = true;
		
		ArrayList<Integer> adj = adjList.get(source);
		
		for (int a : adj) {
			DFSUtil(a, visited);
		}
	}

	// DFS traversal of graph
	public void DFS(int source) {
		boolean[] visited = new boolean[v];
		DFSUtil(source, visited);
	}
	
	// Check for Cycles in undirected graph - BFS traversal
	public boolean isCyclic1(int source) {
		boolean[] visited = new boolean[v];
		int[] parent = new int[v];
		LinkedList<Integer> queue = new LinkedList<>();
		
		for (int i=0; i<v; i++) {
			parent[i] = -1;
		}
		
		visited[source] = true;
		queue.add(source);
		
		while (!queue.isEmpty()) {
			int top = queue.poll();
			ArrayList<Integer> adj = adjList.get(top);
			for (int a : adj) {
				if (!visited[a]) {
					queue.add(a);
					parent[a] = top;
					visited[a] = true;
				}
				else if (a != parent[top]) { 
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isCyclic2Util(int source, boolean[] visited, int parent) {
		visited[source] = true;
		
		ArrayList<Integer> adj = adjList.get(source);
		
		for (int a : adj) {
			if (!visited[a]) {
				if (isCyclic2Util(a, visited, source)) {
					return true;
				}
			}
			else if (a != parent) {
				return true;
			}
		}
		return false;
	}

	// Check for Cycles in undirected graph - DFS traversal
	public boolean isCyclic2(int source) {
		boolean[] visited = new boolean[v];
		
		return isCyclic2Util(source, visited, -1);
	}
	
	public boolean isCyclic3Util(int source, boolean[] visited, boolean[] recStack) {
		if (recStack[source]) {
			return true;
		}
		if (visited[source]) {
			return false;
		}
		
		recStack[source] = true;
		visited[source] = true;
		
		ArrayList<Integer> adj = adjList.get(source);
		
		for (int a : adj) {
			if (isCyclic3Util(a, visited, recStack)) {
				return true;
			}
		}
		recStack[source] = false;
		return false;
	}

	// Check for Cycles in Directed graph - DFS traversal
	public boolean isCyclic3(int source) {
		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];
		
		return isCyclic3Util(source, visited, recStack);
	}
	
	public boolean findShortestDistanceUtil(int source, int destination, int[] pred, int[] dist) {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[source] = true;
		queue.add(source);
		dist[source] = 0;
		
		while (!queue.isEmpty()) {
			int top = queue.poll();
			ArrayList<Integer> adj = adjList.get(top);
			for (int a : adj) {
				if (!visited[a]) {
					queue.add(a);
					visited[a] = true;
					pred[a] = top;
					dist[a] = dist[top] + 1;
				}
				if (a == destination) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Find shortest distance from source node to destination node - Modified BFS
	public void findShortestDistance(int source, int destination) {
		int[] pred = new int[v];
		int[] dist = new int[v];
		
		for (int i=0; i<v; i++) {
			pred[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		
		boolean status = findShortestDistanceUtil(source, destination, pred, dist);
		
		if(status == false) {
			System.out.println("Path not exists between source and destination");
			return;
		}
		
		System.out.println("Distance : " + dist[destination]);
		
		LinkedList<Integer> path = new LinkedList<>();
		int traverse = destination;
		
		while(traverse != -1) {
			path.add(traverse);
			traverse = pred[traverse];
		}
		
		for (int i=path.size()-1; i>=0; i--) {
			System.out.print(path.get(i) + " ");
		}
	}
	
	public void topologicalSortingUtil(int x, boolean[] visited, Stack<Integer> stack) {
		
		visited[x] = true;
		
		ArrayList<Integer> list = adjList.get(x);
		
		for (Integer i : list) {
			if (!visited[i]) {
				topologicalSortingUtil(i, visited, stack);
			}
		}
		
		stack.push(x);
	}
	
	public void topologicalSorting() {
		boolean[] visited = new boolean[v];
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i=0; i<v; i++) {
			if(! visited[i]) {
				topologicalSortingUtil(i, visited, stack);
			}
		}
		
		System.out.println("\nTopological Sorting");
		while (!stack.empty()) {
			System.out.print(stack.pop() + "  ");
		}
	}
	
	// Kahn's Algorithm
	public void topologicalSorting1() {
		int[] indegree = new int[v];
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> topSort = new ArrayList<>();
		int count = 0;
		
		for (int i=0; i<v; i++) {
			for (int a : adjList.get(i)) {
				indegree[a]++;
			}
		}
		
		for (int i=0; i<v; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int top = queue.poll();
			topSort.add(top);
			
			for (int a : adjList.get(top)) {
				if (--indegree[a] == 0) {
					queue.add(a);
				}
			}
			++count;
		}
		
		if (count != v) {
			System.out.println("Cyclic Graph");
			return;
		}

		System.out.println("\nTopological Sorting");
		for (int a : topSort) {
			System.out.print(a + " ");
		}
	}
	
	
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);
		
		System.out.println("BFS");
		graph.BFS(2);
		System.out.println("\nDFS");
		graph.DFS(0);
		boolean cycle1 = graph.isCyclic1(0);
		System.out.println("\nCycle in Undirected graph - BFS : " + cycle1);
		boolean cycle2 = graph.isCyclic2(0);
		System.out.println("\nCycle in Undirected graph - DFS : " + cycle2);
		boolean cycle3 = graph.isCyclic3(0);
		System.out.println("\nCycle in Directed graph - DFS : " + cycle3);
		System.out.println("\nShortest Path");
		graph.findShortestDistance(0, 3);
		
		graph.topologicalSorting();
		graph.topologicalSorting1();
	}
}
