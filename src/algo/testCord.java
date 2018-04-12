/**
 * 
 */
package algo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Omar Elemary
 *
 */
public class testCord {
	
	/**
	 * @throws java.lang.Exception
	 */
	
	private static Cord c1;
	private static Cord c2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c1 = new Cord(1,0);
		c2 = new Cord(-5,3);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link algo.Cord#getX()}.
	 */
	@Test
	public void testGetX() {
		assertTrue(c1.getX() == 1);
		assertTrue(c2.getX() == -5);	
	}

	/**
	 * Test method for {@link algo.Cord#getY()}.
	 */
	@Test
	public void testGetY() {
		assertTrue(c1.getY() == 0);
		assertTrue(c2.getY() == 3);	
	}

	/**
	 * Test method for {@link algo.Cord#setX(double)}.
	 */
	@Test
	public void testSetX() {
		c1.setX(8);
		c2.setX(10);
		assertTrue(c1.getX() == 8);
		assertTrue(c2.getX() == 10);			
	}

	/**
	 * Test method for {@link algo.Cord#setY(double)}.
	 */
	@Test
	public void testSetY() {
		c1.setY(-2);
		c2.setY(0);
		assertTrue(c1.getY() == -2);
		assertTrue(c2.getY() == 0);	
	}

}
