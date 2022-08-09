package graph;

import java.util.ArrayList;

public class BellmanFord {
	class Pair {
		int v;
		int w;
		
		public Pair(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	int size;
	ArrayList<Pair>[] adjList;
	
	public BellmanFord(int size) {
		this.size = size;
		adjList = new ArrayList[size];
		
		for (int i=0; i<size; i++) {
			adjList[i] = new ArrayList<Pair>();
		}
	}
	
	public void addEdge(int u, int v, int w) {
		adjList[u].add(new Pair(v, w));
	}
	
	public int[] findMinimumPath() {
		int[] dist = new int[size];
		
		for (int i=0; i<size; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[0] = 0;
		
		for (int c=1; c<size; c++) {
			for (int i=0; i<size; i++) {
				for (Pair pair : adjList[i]) {
					int u = i;
					int v = pair.v;
					int w = pair.w;
					
					if (dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v]) {
						dist[v] = dist[u] + w;
					}
				}
			}
		}
		for (int i=0; i<size; i++) {
			for (Pair pair : adjList[i]) {
				int u = i;
				int v = pair.v;
				int w = pair.w;
				
				if (dist[u] != Integer.MAX_VALUE && (dist[u] + w) < dist[v]) {
					System.out.println("Graph contains negative weight cycle");
					return dist;
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		BellmanFord bellmanFord = new BellmanFord(5);
		
		bellmanFord.addEdge(0, 1, -1);
		bellmanFord.addEdge(0, 2, 4);
		bellmanFord.addEdge(1, 2, 3);
		bellmanFord.addEdge(1, 3, 2);
		bellmanFord.addEdge(1, 4, 2);
		bellmanFord.addEdge(3, 2, 5);
		bellmanFord.addEdge(3, 1, 1);
		bellmanFord.addEdge(4, 3, -3);
		
		int[] dist = bellmanFord.findMinimumPath();
		
		for (int i=0; i<dist.length; i++) {
			System.out.print(dist[i] + ", ");
		}
	}
}
