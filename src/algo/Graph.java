package algo;

public class Graph{
	private final int Centroids;
	private int edgeCount;
	private Edge[] edges;
	private Cord points;
	
	public Graph(int k, Cord means) {
		this.Centroids = k;
		this.points = means;
		this.edgeCount = (k*(k-1))/2;
		edges = new Edge[edgeCount];
		int count = 0;
		for (Cord v = means; v != null; v = v.getNext()) {
			for (Cord w = v.getNext(); w != null; w = w.getNext()) {
				edges[count] = new Edge(v,w);
				count++;
			}
		}
	}
	
	public int Centroids() { return Centroids; }
	public int edgeCount() { return edgeCount; }
	public Edge[] edges() { return edges; }
	public Cord points() { return points; }
	
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
		Cord m = new Cord(1,1);
		Cord temp = m;
		for (int i = 2; i < 10; i++) {
			temp.setNext(new Cord(i,i));
			temp = temp.getNext();
		}
		Graph G = new Graph(9, m);
		System.out.println(G);
	}
	
	
}