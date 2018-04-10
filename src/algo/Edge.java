package algo;

/**
 * Create edges represented by two coordinates
 * @author duttonl
 *
 */

public class Edge implements Comparable<Edge> {
	private final Cord x;
	private final Cord y;
	private final double weight;
	
	/**
	 * Constructor for an Edge object
	 * @param x the first coordinate of the edge
	 * @param y the second coordinate of the edge
	 */
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
	
	/**
	 * Get the weight of the edge.
	 * @return the distance between the two coordinate points
	 */
	public double weight() { return weight; }
	
	/**
	 * Get the first coordinate of the edge
	 * @return the coordinate of the beginning of the line
	 */
	public Cord first() { return x; }
	
	/**
	 * Get the second coordinate of the edge given a point
	 * @param point one of the points at the ends of the edge
	 * @return the coordinate of the point on the opposite side of the edge
	 */
	public Cord second(Cord point) {
		if (point == x) return y;
		else if (point == y) return x;
		else throw new IllegalArgumentException();
	}
	
	/**
	 * Comparator function for an edge
	 */
	public int compareTo(Edge that) {
		if (this.weight() < that.weight()) return -1;
		else if (this.weight() > that.weight()) return 1;
		else return 0;
	}
	
	/**
	 * Convert the edge object's value to a string
	 */
	public String toString()
	{ return x + " <-> " + y + " : " + weight; }
	
	public static void main(String[] args) {
		Edge e = new Edge(new Cord(1,1), new Cord(1,3));
		System.out.println(e);
	}
	
}


