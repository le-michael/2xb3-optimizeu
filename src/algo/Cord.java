package algo;

public class Cord {
	
	private double xc;
	private double yc;


	
	public Cord(double x, double y) {
		xc = x;
		yc = y;
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
