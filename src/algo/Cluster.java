package algo;

import java.awt.Color;
import java.util.Random;

public class Cluster {

	private Cord centroid;
	private int size;
	private Color c;
	

	public Cluster(float x,float y) {
		Random rand = new Random();
		centroid = new Cord(x,y);
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
	
	
	public void insertCord(Cord n) {
		insertCord(centroid,n);
		size++;
	}
	
	private void insertCord(Cord head,Cord n) {
		if (head.getNext() != null)
			insertCord(head.getNext(),n);
		else
			head.setNext(n);
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
