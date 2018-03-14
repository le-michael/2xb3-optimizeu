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
	
	public static void main(String[] args) {
		int N = 100;
		int k = 10;
		Random rand = new Random();
		
		Cord items = new Cord(0,0);
		Cord tmp = items;
		for (int i=0;i<N;i++) {
			tmp.setX(50+rand.nextDouble()*600);
			tmp.setY(50+rand.nextDouble()*600);
			tmp.setNext(new Cord(0,0));
			tmp = tmp.getNext();
		}
		

		System.out.println("done");
		Cord means = calculateMeans(k,N,items,1000000);
		System.out.println("done");
		for (Cord i = means; i != null; i = i.getNext())
			System.out.println(i);
		Cluster[] clusters = assignToClusters(means,items,k);

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
	private static Cord findColsMin(Cord items) {
		Cord minima = new Cord(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Cord temp = items;
		while (temp != null) {
			if (temp.getY() < minima.getY())
				minima.setY(temp.getY());
			if (temp.getX() < minima.getX())
				minima.setX(temp.getX());
			temp = temp.getNext();
		}
		
		return minima;
	}
	
	/**
	 * Given an array of coordinates, find the maxima of the coordinates
	 * @param items The array of coordinates
	 * @return The maxima of the input coordinates
	 */
	private static Cord findColsMax(Cord items) {
		Cord maxima = new Cord(Integer.MIN_VALUE, Integer.MIN_VALUE);
		Cord temp = items;
		while (temp != null) {
			if (temp.getY() > maxima.getY())
				maxima.setY(temp.getY());
			if (temp.getX() > maxima.getX())
				maxima.setX(temp.getX());
			temp = temp.getNext();
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
	private static Cord initMeans(Cord items, int k, Cord cMin, Cord cMax){
		Random rand = new Random();
		Cord means = new Cord(cMin.getX() + rand.nextDouble() * ( cMax.getX() - cMin.getX()),cMin.getY() + rand.nextDouble() * ( cMax.getY() - cMin.getY()));
		Cord temp = means;
		for (int i = 1; i < k; i++) {
			temp.setNext(new Cord(cMin.getX() + rand.nextDouble() * ( cMax.getX() - cMin.getX()),cMin.getY() + rand.nextDouble() * ( cMax.getY() - cMin.getY())));
			temp = temp.getNext();
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
	private static void updateMean(int size, Cord mean, Cord item) {
		// new avg = (old avg + item) / new size
		mean.setX((mean.getX()*(size-1)+item.getX())/size);
		mean.setY((mean.getY()*(size-1)+item.getY())/size);
	}
	
	/**
	 * Classify items based on their distance to the nearest cluster
	 * @param means The cluster mean points
	 * @param item The item to classify
	 * @return The index of the mean which the iteam is classified to
	 */
	private static int classify(Cord means, Cord item) {
		
		double min = Integer.MAX_VALUE;
		int index = - 1;
		double distance;
		
		Cord temp = means;
		int i = 0;
		while (temp != null) {
			distance = dist(temp, item);
			if (distance < min) {
				min = distance;
				index = i;
			}
			temp = temp.getNext();
			i++;
		}
		/**
		for (int i = 0; i < means.length; i++) {
			distance = dist(means[i], item); 
			
			if (distance < min) {
				min = distance;
				index = i;
			}
		}
		**/
		return index;		

	}
	
	/**
	 * Assign each data point to a cluster based on nearest distance to mean
	 * @param means The mean of each cluster
	 * @param items The items to assign 
	 * @param k The number of clusters
	 * @return The items that are assigned to the corresponding mean's index
	 */
	public static Cluster[] assignToClusters(Cord means, Cord items, int k){
		Cluster[] clusters = new Cluster[k];
		int index = 0;
		for (Cord i = means; i != null; i = i.getNext()) {
			clusters[index] = new Cluster(i.getX(), i.getY());
			index++;
		}
		
		for (Cord i = items; i != null; i = i.getNext()) {
			index = classify(means,i);
			System.out.println(index);
			clusters[index].insertCord(i);
		}
		
		/**
		for (Cord item : items) {
			// find cluster to associate item to
			index = classify(means, item);
			clusters[index].insertCord(item);
		}
		**/
		
		return clusters;
	}
	
	/**
	 * Calculates the mean cluster points
	 * @param k The amount of clusters needed
	 * @param items The items used to calculate mean clusters
	 * @param maxIterations Infinite loop termination condition
	 * @return The calculated mean cluster points
	 */
	public static Cord calculateMeans(int k, int datasize, Cord items, int maxIterations){
		Cord cMin = findColsMin(items), cMax = findColsMax(items);
		Cord means = initMeans(items, k, cMin, cMax);
		boolean noChanges;
		
		int[] clusterSizes = new int[k];
		int[] belongs = new int[datasize+1];
		
		// Calculate means
		for (int j = 0; j < maxIterations; j++) {
			noChanges = true;
			int index, count = 0;
			for (Cord i = items; i != null; i = i.getNext()) {
				index = classify(means,items);
				clusterSizes[index]++;
				Cord temp = means;
				for (int p = 0; p < index; p++)
					temp = temp.getNext();
				updateMean(clusterSizes[index],temp,items);
				if (index != belongs[count]) noChanges = false;
				belongs[count] = index;
				count++;
			}
			/**
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
			**/
			// break out of k-means algorithm if there are no changes to clusters
			if (noChanges) break;
		}
		return means;
	}
}
