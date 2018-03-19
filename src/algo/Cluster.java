package algo;

import java.awt.Color;
import java.util.Random;

public class Cluster {

	private Cord centroid;
	private Cord head;
	private int size;
	private Color c;
	

	public Cluster(double x,double y) {
		Random rand = new Random();
		centroid = new Cord(x,y);
		head = centroid;
		size = 1;
		c = new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat());
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getSize() {
		return size;
	}
	
	public Cord getCenter() {
		return centroid;
	}
	
	public Cord getHead() {
		return head;
	}
	
	
	public void insertCord(Cord n) {
		n.setNext(head);
		head = n;
		size++;
	}
	

	
	public void printCluster() {
		printCluster(centroid);
	}
	
	private void printCluster(Cord n) {
		System.out.println(n.toString());
		if (n.getNext() != null)
			printCluster(n.getNext());
	}

	
}
