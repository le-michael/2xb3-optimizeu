package algo;

public class Cord {
	
	private float xc;
	private float yc;
	private Cord next;

	public Cord(float x, float y) {
		xc = x;
		yc = y;
		next = null;
		// TODO Auto-generated constructor stub
	}
	
	public void setNext(Cord n) {
		next = n;
	}
	
	public Cord getNext() {
		return next;
	}
	
	public float getX() {
		return xc;
	}
	
	public float getY() {
		return yc;
	}
	
	public String toString() {
		
		return "(" + String.valueOf(xc) + "," + String.valueOf(yc) + ")";
	}
	

}
