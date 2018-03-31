package algo;

import java.util.ArrayList;
import java.util.HashMap;

public class UF{
	private int[] parent;
	private int[] size;
	private HashMap<Cord,Integer> dict;
	
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
	
	public boolean connected(Cord p, Cord q) { return find(p) == find(q); }
	
	// Assuming comparison by object reference NOT VALUE
	public int find(Cord p) {
		int i = dict.get(p);
		while (i != parent[i]) i = parent[i];
		return i;
	}
	
	public void union(Cord p, Cord q) {
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		
		if (size[i] < size[j]) { parent[i] = j; size[j] += size[i]; }
		else { parent[j] = i; size[i] += size[j]; }
	}
	
}