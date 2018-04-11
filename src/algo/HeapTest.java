/**
 * 
 */
package algo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Omar Elemary
 *
 */
public class HeapTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	private static Integer[] unsorted;
	private static Integer[] sorted;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		unsorted = new Integer[] {4,2,3,5,1};
		sorted = new Integer[] {1,2,3,4,5};
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link algo.Heap#sortHeap(java.lang.Comparable[], int)}.
	 */
	@Test
	public void testSortHeap() {
		Heap.sortHeap(unsorted, unsorted.length); 
		assertTrue(Arrays.equals(unsorted, sorted)); 
	}

}
