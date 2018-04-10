package algo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Create a UF object to compute Union Find on a set of given
 * @author duttonl
 *
 */

public class UF{
	private int[] parent;
	private int[] size;
	private HashMap<Cord,Integer> dict;
	
	/**
	 * Constructor for a union find object
	 * @param k the number of nodes
	 * @param means an array storing all the nodes
	 */
	public UF(int k, ArrayList<Cord> means) {
		parent = new int[k];
		for (int i = 0; i < k; i++) parent[i] = i;
		size = new int[k];
		for (int i = 0; i < k; i++) size[i] = 1;
		// hash coordinates to an index to make union-find work
		dict = new HashMap<Cord, Integer>();
		int count = 0;
		for (Cord cord : means) {
			dict.put(cord, count);
			count++;
		}
	}
	
	/**
	 * Determine whether two nodes are connected
	 * @param p the first node
	 * @param q the second node
	 * @return a boolean stating whether or not node p and q are connected
	 */
	public boolean connected(Cord p, Cord q) { return find(p) == find(q); }
	
	/**
	 * Find the parent of a given node
	 * @param p the node being passed in
	 * @return the parent of a node
	 */
	public int find(Cord p) {
		int i = dict.get(p);
		while (i != parent[i]) i = parent[i];
		return i;
	}
	
	/**
	 * Combine two nodes into one group
	 * @param p the first node
	 * @param q the second node
	 */
	public void union(Cord p, Cord q) {
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		
		if (size[i] < size[j]) { parent[i] = j; size[j] += size[i]; }
		else { parent[j] = i; size[i] += size[j]; }
	}
	
}