package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class KruskalMST {
	
	private Edge[] edges;
	
	public KruskalMST(Graph G) {
		G.sortEdges();
		UF uf = new UF(G.Centroids(),G.points());
		edges = new Edge[G.Centroids()-1];
		int count = 0;
		for (Edge edge : G.edges()) {
			if (!uf.connected(edge.first(),edge.second(edge.first()))) {
				uf.union(edge.first(),edge.second(edge.first()));
				edges[count++] = edge;
			}
		}
	}
	
	public Edge[] getEdges() { return edges; }
	
	public String toString() {
		String s = "";
		for (int i = 0; i < edges.length; i++)
			s += edges[i] + "\n";
		return s;
	}

	public static void main(String[] args) {
		ArrayList<Cord> points = new ArrayList<Cord>();
		for (int i = 1; i < 10; i++) {
			points.add(new Cord(i, i));
		}
		Graph G = new Graph(9, points);
		KruskalMST k = new KruskalMST(G);
		System.out.println(k);
	}
}

