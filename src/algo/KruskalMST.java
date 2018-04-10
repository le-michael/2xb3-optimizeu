package algo;

/**
 * Create an KruskalMST object to compute the MST of a given graph
 * @author duttonl
 *
 */

public class KruskalMST {
	
	private Edge[] edges;
	/**
	 * Constructor for a Kruskal object
	 * @param G the graph that Kruskal will run on
	 */
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
	
	/**
	 * Get the edges that form a MST
	 * @return the calculated edges
	 */
	public Edge[] getEdges() { return edges; }
	
	/**
	 * Convert the MST to string format
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < edges.length; i++)
			s += edges[i] + "\n";
		return s;
	}

}

