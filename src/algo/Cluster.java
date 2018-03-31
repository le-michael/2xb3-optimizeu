package algo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Cluster {

	private Cord centroid;
	private ArrayList<Cord> points;

	private Color c;
	

	public Cluster(double x,double y) {
		Random rand = new Random();
		centroid = new Cord(x,y);
		points = new ArrayList<Cord>();
		c = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getSize() {
		return points.size();
	}
	
	public Cord getCenter() {
		return centroid;
	}
	
	public ArrayList<Cord> getPoints() {
		return points;
	}
	
	
	public void insertCord(Cord n) {
		points.add(n);
	}
	
	public void printCluster() {
		for(Cord c : points)
			System.out.println(c.toString());
	}
	
	
}
