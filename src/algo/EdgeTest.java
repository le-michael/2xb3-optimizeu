/**
 * 
 */
package algo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class EdgeTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	private static Edge e1;
	private static Edge e2;
	private static Cord c1;
	private static Cord c2;
	private static Cord c3;
	private static Cord c4;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		c1 = new Cord(1,1);
		c2 = new Cord(1,3);
		c3 = new Cord(5,5);
		c4 = new Cord(3,3);
		e1 = new Edge(c1,c2);
		e2 = new Edge(c3,c4);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link algo.Edge#weight()}.
	 */
	@Test
	public void testWeight() {
		assertTrue(e1.weight() == 2);
		assertTrue(e2.weight() == 2.8284271247461903);
	}

	/**
	 * Test method for {@link algo.Edge#first()}.
	 */
	@Test
	public void testFirst() {
		assertTrue(e1.first().getX() == 1);
		assertTrue(e1.first().getY() == 1);
		assertTrue(e2.first().getX() == 5);
		assertTrue(e2.first().getY() == 5);
	}

	/**
	 * Test method for {@link algo.Edge#second(algo.Cord)}.
	 */
	@Test
	public void testSecond() {
		assertTrue(e1.second(c1).getX() == 1);
		assertTrue(e1.second(c1).getY() == 3);
		assertTrue(e1.second(c2).getX() == 1);
		assertTrue(e1.second(c2).getY() == 1);
		assertTrue(e2.second(c3).getX() == 3);
		assertTrue(e2.second(c3).getY() == 3);
		assertTrue(e2.second(c4).getX() == 5);
		assertTrue(e2.second(c4).getY() == 5);
	}

	/**
	 * Test method for {@link algo.Edge#compareTo(algo.Edge)}.
	 */
	@Test
	public void testCompareTo() {
		assertTrue(e1.compareTo(e2) == -1);
	}

}
