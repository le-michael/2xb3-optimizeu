package algo;

import java.util.Arrays;

public class KruskalMST {
	
	private double weight;    // weight of MST   
	private static int []V1;     //array of verticies
	private static int []V2;	
	private static int []W;     // array of weights
	private Edge[] mst; // edges in MST
	private Edge[] edges;
	
	public double weight() {
	    return weight;
	}
	
    public Edge[] edges() {
        return mst;
    }
	
	public KruskalMST(){
		//Setup for array of edges
		edges = new Edge[(V1.length + V2.length)/2];  
	    for (int i = 0; i < (V1.length + V2.length)/2; ++i) {
	        edges[i] = new Edge(V1[i], V2[i], W[i]);
	    }   
	    //Sort edges in non-decreasing order of weight		
		Arrays.sort(edges);
		UF uf = new UF(V1.length + V2.length);    //put verticies
		int j = 0;	
		while (j < edges.length && mst.length < V1.length + V2.length-1){   //condition till we are out of edges
			Edge e = edges[j]; // Get min weight edge from array
			int v = e.either();
			int w = e.other(v); 
	        if (!uf.connected(v, w)) { // v-w does not create a cycle
	            uf.union(v, w);  // merge v and w components
	            mst[j] = e;  // add edge e to mst
	            weight += e.weight();
	            j++;
	       }
	}	
}

	public static void main(String[] args) {
		
		V1 = new int[] {1,2,3,4};
		V2 = new int[] {2,3,4,1};
		W = new int[]{4,5,5,10};
		KruskalMST mst = new KruskalMST();
		
		for (Edge e : mst.edges()) {
		    System.out.println(e);
		}

		System.out.printf("%.5f\n", mst.weight());
	}

}

