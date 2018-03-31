package algo;

import java.util.ArrayList;

public class Graph{
	private final int Centroids;
	private int edgeCount;
	private Edge[] edges;
	private ArrayList<Cord> points;
	
	public Graph(int k, ArrayList<Cord> means) {
		this.Centroids = k;
		this.points = means;
		this.edgeCount = (k*(k-1))/2;
		edges = new Edge[edgeCount];
		int count = 0;
		for (int i = 0; i < means.size()-1; i++) {
			for (int j = i+1; j < means.size(); j++) {
				edges[count] = new Edge(means.get(i),means.get(j));
				count++;
			}
		}
	}
	
	public int Centroids() { return Centroids; }
	public int edgeCount() { return edgeCount; }
	public Edge[] edges() { return edges; }
	public ArrayList<Cord> points() { return points; }
	
	public void sortEdges() {
		Heap.sortHeap(edges,edgeCount);
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < edgeCount; i++) {
			s += edges[i].toString() + "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		ArrayList<Cord> points = new ArrayList<Cord>();
		for (int i = 0; i < 9; i++) {
			points.add(new Cord(i, i));
		}
		Graph G = new Graph(9, points);
		System.out.println(G);
	}
	
	
}