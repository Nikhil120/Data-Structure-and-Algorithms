package graph;

import java.util.*;

public class Dijkstra {
	class Pair {
		int vertex;
		int weight;
		
		public Pair(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}
	
	ArrayList<Pair>[] adjList;
	int size;
	
	public Dijkstra(int size) {
		this.size = size;
		this.adjList = new ArrayList[size];
		
		for (int i=0; i<size; i++) {
			adjList[i] = new ArrayList<Pair>();
		}
	}
	
	public void addEdge(int source, int destination, int weight) {
		adjList[source].add(new Pair(destination, weight));
	}
	
	public int findMinimumPath(int[] dist, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int pos = -1;
		
		for (int i=0; i<dist.length; i++) {
			if (!visited[i] && (dist[i] <= min)) {
				min = dist[i];
				pos = i;
			}
		}
		
		return pos;
	}
	
	public int[] findDistance() {
		int[] dist = new int[size];
		boolean[] visited = new boolean[size];
		
		for (int i=0; i<size; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		
		dist[0] = 0;
		
		for (int i=0; i<size-1; i++) {
			int pos = findMinimumPath(dist, visited);
			visited[pos] = true;
			
			for (Pair pair : adjList[pos]) {
				int v = pair.vertex; 
				
				if (!visited[v] && dist[pos] != Integer.MAX_VALUE && (dist[pos] + pair.weight) < dist[v]) {
					dist[v] = dist[pos] + pair.weight;
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		Dijkstra dijkstra = new Dijkstra(9);
		
		int[][] mat = new int[][] 
			{ { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
            { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
            { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
            
       for (int i=0; i<mat.length; i++) {
    	   for (int j=0; j<mat[0].length; j++) {
    		   if (mat[i][j] != 0) {
    			   dijkstra.addEdge(i, j, mat[i][j]);   
    		   }
    	   }
       }
       
       int[] dist = dijkstra.findDistance();
       
       for (int i=0; i<dist.length; i++) {
    	   System.out.print(dist[i] + ", ");
       }
	}
}