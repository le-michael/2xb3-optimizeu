package algo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Create cluster objects to store the groups of coordinates 
 * @author Michael Le
 *
 */
public class Cluster {

	private Cord centroid;
	private ArrayList<Cord> points;

	private Color c;
	

	/**
	 * Constructor for a cluster object
	 * @param x the x coordinate of the centroid
	 * @param y the y coordinate of the centroid
	 */
	public Cluster(double x,double y) {
		Random rand = new Random();
		centroid = new Cord(x,y);
		points = new ArrayList<Cord>();
		c = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	}
	
	/**
	 * Get the colour of the cluster
	 * @return the colour of the cluster
	 */
	public Color getColor() {
		return c;
	}
	
	/**
	 * Get the size of the cluster
	 * @return the size of the cluster
	 */
	public int getSize() {
		return points.size();
	}
	
	/**
	 * Get the center of the cluster
	 * @return the centroid coordinates of the cluster
	 */
	public Cord getCenter() {
		return centroid;
	}
	
	/**
	 * Get the points in a cluster
	 * @return an array of coordinates
	 */
	public ArrayList<Cord> getPoints() {
		return points;
	}
	
	/**
	 * Insert a new point into the cluster
	 * @param n the coordinate of the new point
	 */
	public void insertCord(Cord n) {
		points.add(n);
	}
	
	/**
	 * Print the all the points in a cluster
	 */
	public void printCluster() {
		for(Cord c : points)
			System.out.println(c.toString());
	}
	
	
}
