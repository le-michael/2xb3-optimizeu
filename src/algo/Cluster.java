package algo;


public class Cluster {

	private Cord centroid;

	
	public Cord getCenter() {
		return centroid;
	}
	
	public Cluster(float x,float y) {
		centroid = new Cord(x,y);
	}
	
	public void insertCord(Cord n) {
		insertCord(centroid,n);
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
