package algo;

/**
 * Coordinate ADT
 * 
 * @author Michael Le
 */

public class Cord {
	
	private double xc;
	private double yc;
	private Cord next;

	/**
	 * Class constructor for coordinate object.
	 * 
	 * @param x
	 *            - double value of x coordinate.
	 * @param y
	 *            - double value of y coordinate.
	 * @param t
	 *            - string representation of time.
	 */


	public Cord(double x, double y, String t) {
		xc = x;
		yc = y;
		next = null;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Class constructor for coordinate object.
	 * 
	 * @param x
	 *            - double value of x coordinate.
	 * @param y
	 *            - double value of y coordinate.
	 */
	
	public Cord(double x, double y) {

		xc = x;
		yc = y;
		next = null;
	}

	/**
	 * Setter method for next coordinate node.
	 * 
	 * @param n
	 *            - New coordinate object.
	 */

	public void setNext(Cord n) {
		next = n;
	}

	/**
	 * Accessor method for next coordinate node.
	 * 
	 * @return - Coordinate object assigned to variable - next.
	 */
	
	public Cord getNext() {
		return next;
	}

	/**
	 * Accessor method for x-coordinate.
	 * 
	 * @return - double value of x coordinate passed to Cord constructor.
	 */
	
	public double getX() {
		return xc;
	}

	/**
	 * Accessor method for y-coordinate.
	 * 
	 * @return - double value of y coordinate passed to Cord constructor.
	 */

	public double getY() {
		return yc;
	}

	/**
	 * Setter method for x-coordinate.
	 * 
	 * @param x
	 *            - double value of x coordinate.
	 *
	 * @return - New modified double value of x coordinate given by user.
	 */
	
	public void setX(double x) {
		xc = x;
	}
	
	/**
	 * Setter method for y-coordinate.
	 * 
	 * @param y
	 *            - double value of y coordinate.
	 *
	 * @return - New modified double value of y coordinate given by user.
	 */
	
	public void setY(double y) {
		yc = y;
	}

	/**
	 * Constructs a string representation of a x and y coordinates.
	 * 
	 * @return a string containing value of x - coordinate and y-coordinate.
	 */

	public String toString() {
		
		return "(" + String.valueOf(xc) + "," + String.valueOf(yc) + ")";
	}
	

}
