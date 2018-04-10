package algo;

import java.util.ArrayList;

/**
 * Create a graph object to connect up all nodes with weighted edges
 * @author duttonl
 *
 */

public class Graph{
	private final int Centroids;
	private int edgeCount;
	private Edge[] edges;
	private ArrayList<Cord> points;
	
	/**
	 * Constructor for a graph object
	 * @param k the number of nodes
	 * @param means the coordinate of all the nodes
	 */
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
	
	/**
	 * Get the number of nodes
	 * @return the number of nodes
	 */
	public int Centroids() { return Centroids; }
	
	/**
	 * Get the max number of edges
	 * @return the number of edges
	 */
	public int edgeCount() { return edgeCount; }
	
	/**
	 * Get the edges as an edge object
	 * @return an array storing edge objects connecting the nodes
	 */
	public Edge[] edges() { return edges; }
	
	/**
	 * The coordinate of all the nodes
	 * @return an array storing all the coordinate of all the nodes
	 */
	public ArrayList<Cord> points() { return points; }
	
	/**
	 * Sort the edges in the graph
	 */
	public void sortEdges() {
		Heap.sortHeap(edges,edgeCount);
	}
	
	/**
	 * Convert the graph to a string
	 */
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