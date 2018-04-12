/**
 * 
 */
package algo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author duttonl
 *
 */
public class testKMeans {

	private static Cord[] testArray = { new Cord(1,2), new Cord(5,6), new Cord(2,3), new Cord(6,9) };
	private static ArrayList<Cord> testPoints;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		testPoints = new ArrayList<Cord>(Arrays.asList(testArray));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link algo.KMeans#assignToClusters(java.util.ArrayList, java.util.ArrayList, int)}.
	 */
	@Test
	public void testAssignToClusters() {
		ArrayList<Cord> centroids = KMeans.calculateMeans(2, 4, testPoints, 10000);
		Cluster[] clusters = KMeans.assignToClusters(centroids,testPoints,2);
		assertTrue(clusters.length == 2);
	}

	/**
	 * Test method for {@link algo.KMeans#calculateMeans(int, int, java.util.ArrayList, int)}.
	 */
	@Test
	public void testCalculateMeans() {
		// Two-cluster k-means
		ArrayList<Cord> centroids = KMeans.calculateMeans(2, 4, testPoints, 10000);
		assertTrue(centroids.size() == 2);
	}

}
