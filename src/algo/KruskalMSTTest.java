/**
 * 
 */
package algo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class KruskalMSTTest {
	
	private static Graph G;
	private static KruskalMST krusk;


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayList<Cord> points = new ArrayList<Cord>();
		for (int i = 0; i < 9; i++) {
			points.add(new Cord(i, i));
		}
		G = new Graph(9, points);
		krusk = new KruskalMST(G);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link algo.KruskalMST#getEdges()}.
	 */
	@Test
	public void testGetEdges() {
		for (int i = 0; i < krusk.getEdges().length-1; i++) {
			assertTrue(krusk.getEdges()[i].weight() <= krusk.getEdges()[i+1].weight());
		}
	}

}
