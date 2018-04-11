/**
 * 
 */
package algo;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClusterTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	private static Cluster clust;
	private static Cord p1;
	private static Cord p2;
	private static Cord p3;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		clust = new Cluster(5,6);
		p1 = new Cord(4,5);
		p2 = new Cord(-1,-3);
		p3 = new Cord(8,12);
		clust.insertCord(p1);
		clust.insertCord(p2);
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	/**
	 * Test method for {@link algo.Cluster#getSize()}.
	 */
	@Test
	public void testGetSize() {
		assertTrue(clust.getSize() == 2);
		clust.insertCord(p3);
		assertTrue(clust.getSize() == 3);
		
	}

	/**
	 * Test method for {@link algo.Cluster#getCenter()}.
	 */
	@Test
	public void testGetCenter() {
		assertTrue(clust.getCenter().getX() == 5);
		assertTrue(clust.getCenter().getY() == 6);
	}

	/**
	 * Test method for {@link algo.Cluster#getPoints()}.
	 */
	@Test
	public void testGetPoints() {
		assertTrue(clust.getPoints().get(0).getX() == 4);
		assertTrue(clust.getPoints().get(0).getY() == 5);		
		assertTrue(clust.getPoints().get(1).getX() == -1);
		assertTrue(clust.getPoints().get(1).getY() == -3);
	}

	/**
	 * Test method for {@link algo.Cluster#insertCord(algo.Cord)}.
	 */
	@Test
	public void testInsertCord() {
		clust.insertCord(p3);
		assertTrue(clust.getPoints().get(2).getX() == 8);
		assertTrue(clust.getPoints().get(2).getY() == 12);
	}

}
