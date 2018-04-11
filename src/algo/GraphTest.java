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
public class GraphTest {

	private static Graph G1;
	private static Graph G2;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayList<Cord> points = new ArrayList<Cord>();
		for (int i = 0; i < 9; i++) {
			points.add(new Cord(i, i));
		}
		G1 = new Graph(9, points);
		G2 = new Graph(9, points);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link algo.Graph#Centroids()}.
	 */
	@Test
	public void testCentroids() {
		assertTrue(G1.Centroids() == 9);
	}

	/**
	 * Test method for {@link algo.Graph#edgeCount()}.
	 */
	@Test
	public void testEdgeCount() {
		assertTrue(G1.edgeCount() == 36);
	}

	/**
	 * Test method for {@link algo.Graph#edges()}.
	 */
	@Test
	public void testEdges() {
		for (int i = 0; i < G1.edgeCount(); i++) {
			assertTrue(G1.edges()[i].compareTo(G2.edges()[i]) == 0);
		}
	}

	/**
	 * Test method for {@link algo.Graph#points()}.
	 */
	@Test
	public void testPoints() {
		for (int i = 0; i < 9; i++) {
			assertTrue(G1.points().get(i).getX() == i);
			assertTrue(G1.points().get(i).getY() == i);
		}	
	}

	/**
	 * Test method for {@link algo.Graph#sortEdges()}.
	 */
	@Test
	public void testSortEdges() {
		G1.sortEdges();
		for (int i = 0; i < G1.edgeCount()-1; i++) {
			assertTrue(G1.edges()[i].weight() <= G1.edges()[i+1].weight());
		}	
	}

}
