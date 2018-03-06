package algo;

public class Cord {
	
	private double xc;
	private double yc;
	private Cord next;

	public Cord(double x, double y) {
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
	
	public double getX() {
		return xc;
	}
	
	public double getY() {
		return yc;
	}
	
	public void setX(double x) {
		xc = x;
	}
	
	
	public void setY(double y) {
		yc = y;
	}
	public String toString() {
		
		return "(" + String.valueOf(xc) + "," + String.valueOf(yc) + ")";
	}
	

}
