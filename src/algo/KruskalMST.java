package algo;

import java.util.Arrays;

public class KruskalMST {
	
	private static double weight = 0;    // weight of MST   
	private static int []V1;     //array of verticies
	private static int []V2;	
	private static int []W;     // array of weights
	private Edge[] mst; // edges in MST
	private Edge[] edges;
	
	public double weight() {
	    return this.weight;
	}
	
    public Edge[] edges() {
        return this.mst;
    }
	
	public KruskalMST(){
		//Setup for array of edges
		this.edges = new Edge[V1.length];  
	    for (int i = 0; i < V1.length; i++) {
	        this.edges[i] = new Edge(V1[i], V2[i], W[i]);
	    }
	    this.mst = new Edge[V1.length];
	    //Sort edges in non-decreasing order of weight		
		Arrays.sort(this.edges);
		UF uf = new UF(V1.length+1);    //put verticies
		int j = 0;	
		while (j < this.edges.length){   //condition till we are out of edges
			Edge e = edges[j]; // Get min weight edge from array
			int v = e.either();
			int w = e.other(v); 
	        if (!uf.connected(v, w)) { // v-w does not create a cycle
	            uf.union(v, w);  // merge v and w components
	            this.mst[j] = e;  // add edge e to mst
	            weight += e.weight();
	        }
	        j++;
		}	
	}

	public static void main(String[] args) {
		
		V1 = new int[] {1,2,3,4};
		V2 = new int[] {2,3,4,1};
		W = new int[]{4,5,5,1};
		KruskalMST mst = new KruskalMST();
		
		System.out.printf("%.5f\n", mst.weight());
		
		for (Edge e : mst.edges()) {
		    System.out.println(e);
		}
		
	}

}

