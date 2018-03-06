package algo;

import java.util.Random;

/**
 * k-means clustering algorithm.
 * Creates k-clusters and approximates (or solves) their optimal positions
 * after a chosen amount of iterations.
 * Assigns data points to the approximated (solved) clusters
 * @author duttonl
 *
 */
public class KMeans {
	
	
	
	// unit testing goes here. Use StdRandom to shuffle any input!
	public static void main(String[] args) {
		int N = 10000;
		int k = 100;
		Random rand = new Random();
		
		Cord[] items = new Cord[N];
		for (int i=0;i<N;i++) {
			items[i] = new Cord(50+rand.nextDouble()*600,50+rand.nextDouble()*600);
		}
		
		
		Cord[] means = calculateMeans(k,items,1000000);
		Cluster[] clusters = assignToClusters(means,items);

		for( Cluster clus: clusters) {
			System.out.println("Cluster");
			clus.printCluster();
		}
        DisplayClusters ex = new DisplayClusters(clusters);
        ex.setVisible(true);
		
	}

	/**
	 * Given an array of coordinates, find the minima of the coordinates
	 * @param items The array of coordinates
	 * @return The minima of the input coordinates
	 */
	private static Cord findColsMin(Cord[] items) {
		Cord minima = new Cord(Integer.MAX_VALUE, Integer.MAX_VALUE);
		
		for (Cord item : items) {
			if (item.getY() < minima.getY())
				minima.setY(item.getY());
			if (item.getX() < minima.getX())
				minima.setX(item.getX());
		}
		
		return minima;
	}
	
	/**
	 * Given an array of coordinates, find the maxima of the coordinates
	 * @param items The array of coordinates
	 * @return The maxima of the input coordinates
	 */
	private static Cord findColsMax(Cord[] items) {
		Cord maxima = new Cord(Integer.MIN_VALUE, Integer.MIN_VALUE);
		
		for (Cord item : items) {
			if (item.getY() > maxima.getY())
				maxima.setY(item.getY());
			if (item.getX() > maxima.getX())
				maxima.setX(item.getX());
		}
		
		return maxima;
	}
	
	/**
	 * Given two coordinates, return the Euclidean distance
	 * @param a The first coordinate
	 * @param b The second coordinate
	 * @return The distance between a and b
	 */
	private static double dist(Cord a, Cord b) {
		double sum = 0;
		sum += Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(),2);
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
	private static Cord[] initMeans(Cord[] items, int k, Cord cMin, Cord cMax){
		Cord[] means = new Cord[k];
		
		Random rand = new Random();
		
			for (int i = 0; i < k; i++) {
				// Note: +/- 1 narrows down the placement of initial mean spots
				// mean[i] = StdRandom.uniform(cMin[i]+1,cMax[i]-1);
				
				means[i] = new Cord(cMin.getX() + rand.nextDouble() * ( cMax.getX() - cMin.getX()),cMin.getY() + rand.nextDouble() * ( cMax.getY() - cMin.getY()));
			}
		return means;
		
	}
	
	/**
	 * Updates the mean of selected cluster after adding a point to it
	 * @param size The size of the cluster
	 * @param mean The mean point to update
	 * @param item The new item added to the cluster
	 * @return The updated mean
	 */
	private static Cord updateMean(int size, Cord mean, Cord item) {
		Cord m = new Cord(0,0);
		// new avg = (old avg + item) / new size
		m.setX((mean.getX()*(size-1)+item.getX())/size);
		m.setY((mean.getY()*(size-1)+item.getY())/size);
		
		return m;
	}
	
	/**
	 * Classify items based on their distance to the nearest cluster
	 * @param means The cluster mean points
	 * @param item The item to classify
	 * @return The index of the mean which the iteam is classified to
	 */
	private static int classify(Cord[] means, Cord item) {
		
		double min = Integer.MAX_VALUE;
		int index = - 1;
		double distance;
		
		for (int i = 0; i < means.length; i++) {
			distance = dist(means[i], item); 
			
			if (distance < min) {
				min = distance;
				index = i;
			}
		}
		
		return index;		

	}
	
	/**
	 * Assign each data point to a cluster based on nearest distance to mean
	 * @param means The mean of each cluster
	 * @param items The items to assign 
	 * @return The items that are assigned to the corresponding mean's index
	 */
	public static Cluster[] assignToClusters(Cord[] means, Cord[] items){
		Cluster[] clusters = new Cluster[means.length];
		
		for (int i = 0; i < means.length; i++) {
			clusters[i] = new Cluster(means[i].getX(), means[i].getY());
		}
		
		int index;
		for (Cord item : items) {
			// find cluster to associate item to
			index = classify(means, item);
			clusters[index].insertCord(item);
		}
		
		return clusters;
	}
	
	/**
	 * Calculates the mean cluster points
	 * @param k The amount of clusters needed
	 * @param items The items used to calculate mean clusters
	 * @param maxIterations Infinite loop termination condition
	 * @return The calculated mean cluster points
	 */
	public static Cord[] calculateMeans(int k, Cord[] items, int maxIterations){
		Cord cMin = findColsMin(items), cMax = findColsMax(items);
		Cord[] means = initMeans(items, k, cMin, cMax);
		Cord item; boolean noChanges;
		
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
