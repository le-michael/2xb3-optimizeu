/**
 * 
 */
package algo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Omar Elemary
 *
 */
public class UFTest {

	/**
	 * @throws java.lang.Exception
	 */
	private static Cluster c1;
	private static Cluster c2;
	private static Cluster c3;
	private static ArrayList<Cord> centroids;
	private static UF UFTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		c1 = new Cluster(5,4);
		c2 = new Cluster(3,8);
		c3 = new Cluster(9,0);
		centroids = new ArrayList<Cord>();
		centroids.add(c1.getCenter());
		centroids.add(c2.getCenter());
		centroids.add(c3.getCenter());		
		UFTest = new UF(centroids.size(), centroids);
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link algo.UF#connected(algo.Cord, algo.Cord)}.
	 */
	@Test
	public void testConnected() {
		assertTrue(!UFTest.connected(centroids.get(0), centroids.get(1)));

	}

	/**
	 * Test method for {@link algo.UF#find(algo.Cord)}.
	 */
	@Test
	public void testFind() {
		assertTrue(UFTest.find(centroids.get(0)) == 0);
	}

	/**
	 * Test method for {@link algo.UF#union(algo.Cord, algo.Cord)}.
	 */
	@Test
	public void testUnion() {
		UFTest.union(centroids.get(0), centroids.get(2));
		assertTrue(UFTest.connected(centroids.get(0), centroids.get(2)));
	}

}
