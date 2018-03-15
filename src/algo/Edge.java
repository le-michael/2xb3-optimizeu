package algo;

public class Edge implements Comparable<Edge> {
	private final Cord x;
	private final Cord y;
	private final double weight;
	
	public Edge(Cord x, Cord y) {
		this.x = x;
		this.y = y;
		this.weight = dist(x,y);
	}
	
	// Same as k-means
	private static double dist(Cord a, Cord b) {
		double sum = 0;
		sum += Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(),2);
		return Math.sqrt(sum);
	}
	
	public double weight() { return weight; }
	public Cord first() { return x; }
	public Cord second(Cord point) {
		if (point == x) return y;
		else if (point == y) return x;
		else throw new IllegalArgumentException();
	}
	
	public int compareTo(Edge that) {
		if (this.weight() < that.weight()) return -1;
		else if (this.weight() > that.weight()) return 1;
		else return 0;
	}
	
	public String toString()
	{ return x + " <-> " + y + " : " + weight; }
	
	public static void main(String[] args) {
		Edge e = new Edge(new Cord(1,1), new Cord(1,3));
		System.out.println(e);
	}
	
}


