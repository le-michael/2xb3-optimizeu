package algo;

/**
 * Class that implements heapsort.
 * Reference: Algorithms, 4th Edition by Robert Sedgewick and Kevin Wayne
 * @author duttonl
 *
 */
public class Heap {
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
		for (int k = n/2; k >= 1; k--) sink(x, k, n);
		while (n > 1) {
			heapExch(x, 1, n--);
			sink(x, 1, n);
		}
	}

	/**
	 * Helper sink function for implementing construction and heapsort
	 * @param x the Comparable array where sink is applied to
	 * @param n the initial parent key index
	 * @param length the length of the Comparable array
	 */
	private static void sink(Comparable[] x, int n, int length) {
		// create a local variable for parent key index
		int p = n;
		// while loop checks for existing children nodes (i.e. if depth is exceeded)
		while (2*p <= length) {
			// get child index
			int c = 2*p;
			// compare children: bigger child will be swapped
			if (c < length && lessThan(x[c-1],x[c])) c++;
			// parent key already satisfies max heap property
			if (!lessThan(x[p-1], x[c-1])) break;
			// exchange parent and targeted child
			heapExch(x, p, c);
			// child is now parent of succeding heap
			p = c;
		}
	}
	
	private static boolean lessThan(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	/**
	 * Similar to exchange but accounting for Heaps having 1-index starts
	 * @param arr The array of interest
	 * @param i The first value to be switched
	 * @param j The second value to be switched
	 */
	private static void heapExch(Comparable[] arr, int i, int j) {
		i--;j--;
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
