package algo;


public class KMeans {

	private static final int N = 2; // represents length of the (x,y) coordinate
	
	// unit testing goes here. Use StdRandom to shuffle any input!
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given an array of coordinates, find the minima of the coordinates
	 * @param items The array of coordinates
	 * @return The minima of the input coordinates
	 */
	private static double[] findColsMin(double[][] items) {
		double[] minima = {Integer.MAX_VALUE, Integer.MAX_VALUE};
		
		for (double[] item : items) {
			for (int i = 0; i < N; i++) {
				if (item[i] < minima[i]) {
	                minima[i] = item[i];
				}
			}
		}
		
		return minima;
	}
	
	/**
	 * Given an array of coordinates, find the maxima of the coordinates
	 * @param items The array of coordinates
	 * @return The maxima of the input coordinates
	 */
	private static double[] findColsMax(double[][] items) {
		double[] maxima = {Integer.MIN_VALUE, Integer.MIN_VALUE};
		
		for (double[] item : items) {
			for (int i = 0; i < N; i++) {
				if (item[i] > maxima[i]) {
	                maxima[i] = item[i];
				}
			}
		}
		
		return maxima;
	}
	
	/**
	 * Given two coordinates, return the Euclidean distance
	 * @param a The first coordinate
	 * @param b The second coordinate
	 * @return The distance between a and b
	 */
	private static double dist(double[] a, double[] b) {
		double sum = 0;
		for (int i = 0; i < N; i++)
			sum += Math.pow(b[i]-a[i], 2);
		return Math.sqrt(sum);
	}
	
	/**
	 * Initialize k amount of mean points
	 * @param items The dataset
	 * @param k The amount of clusters
	 * @param cMin The minima of the dataset
	 * @param cMax The maxima of the dataset
	 * @return The coordinates of the means stored in an array
	 */
	private static double[][] initMeans(double[][] items, int k, double[] cMin, double[] cMax){
		double[][] means = new double[k][N];
		for (double[] mean : means) {
			for (int i = 0; i < N; i++)
				// Note: +/- 1 narrows down the placement of initial mean spots
				mean[i] = StdRandom.uniform(cMin[i]+1,cMax[i]-1);
		}
		
		return means;
		
	}
	
	private static double[] updateMean(int size, double[] mean, double[] item) {
		for (int i = 0; i < N; i++) {
			double m = mean[i];
			// new avg = (old avg + item) / new size
			m = (m*(size-1)+item[i])/size;
			mean[i] = Math.round(m*1000.0)/1000.0;
		}
		
		return mean;
	}
	
	private static int classify(double[][] means, double[] item) {
		
		double min = Integer.MAX_VALUE;
		int index = - 1;
		double distance;
		
		for (int i = 0; i < means.length; i++) {
			distance = dist(item, means[i]); 
			
			if (distance < min) {
				min = distance;
				index = i;
			}
		}
		
		return index;		

	}
	
	public static double[][][] assignToClusters(double[][] means, double[][] items){
		// array storing increments
		int[] inc = new int[means.length];
		
		// 2nd dimension should be done with array resizing..
		double[][][] clusters = new double[means.length][items.length][N];
		
		// set initial increments to zero
		for (int i = 0; i < inc.length; i++)
			inc[i] = 0;
		
		int index;
		for (double[] item : items) {
			// find cluster to associate item to
			index = classify(means, item);
			clusters[index][inc[index]++] = item;
		}
		
		return clusters;
	}
	public static double[][] calculateMeans(int k, double[][] items, int maxIterations){
		double[] cMin = findColsMin(items), cMax = findColsMax(items);
		double[][] means = initMeans(items, k, cMin, cMax);
		double[] item; boolean noChanges;
		
		int[] clusterSizes = new int[means.length];
		int[] belongs = new int[items.length];
		
		// Calculate means
		for (int j = 0; j < maxIterations; j++) {
			noChanges = true;
				
			for (int i = 0; i < items.length; i++) {
				item = items[i];
				
				// Classify the item to the closest mean point
				int index = classify(means, item);
				
				// Update corresponding cluster size
				clusterSizes[index]++;
				
				// Update mean
				means[index] = updateMean(clusterSizes[index],means[index],item);
				
				// Item changed cluster
	            if (index != belongs[i]) noChanges = false;
				belongs[i] = index;
				
			}
			
			// break out of k-means algorithm if there are no changes to clusters
			if (noChanges) break;
		}
		
		return means;
	}
}
