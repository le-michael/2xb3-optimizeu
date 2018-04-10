package algo;

/**
 * Create a Cord object to store a coordinate 
 * @author Michael Le
 *
 */

public class Cord {
	
	private double xc;
	private double yc;


	/**
	 * Constructor for a coordinate object
	 * @param x the x-coordinate of the new cord
	 * @param y the y-coordinate of the new cord
	 */
	public Cord(double x, double y) {
		xc = x;
		yc = y;
	}
	
	/**
	 * Get the x-coordinate of the Cord object
	 * @return the x value of the Cord object
	 */
	public double getX() {
		return xc;
	}
	
	/**
	 * Get the y-coordinate of the Cord object
	 * @return the y value of the Cord object
	 */
	public double getY() {
		return yc;
	}
	
	/**
	 * Set the x-coordinate of the Cord object
	 * @param x the new x value
	 */
	public void setX(double x) {
		xc = x;
	}
	
	/**
	 * Set the y-coordinate of the Cord object
	 * @param y the new y value
	 */
	public void setY(double y) {
		yc = y;
	}
	
	/**
	 * Convert a Cord object to a string
	 */
	public String toString() {
		
		return "(" + String.valueOf(xc) + "," + String.valueOf(yc) + ")";
	}
	

}
