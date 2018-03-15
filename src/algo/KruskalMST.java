package algo;

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
		Cord m = new Cord(1,1);
		Cord temp = m;
		for (int i = 2; i < 10; i++) {
			temp.setNext(new Cord(i,i));
			temp = temp.getNext();
		}
		Graph G = new Graph(9, m);
		KruskalMST k = new KruskalMST(G);
		System.out.println(k);
	}
}

