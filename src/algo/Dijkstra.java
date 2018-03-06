
public class Dijkstra {
	
    static final int V=100;
    int minDistance(int distance[], Boolean Set[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (Set[v] == false && distance[v] <= min)
            {
                min = distance[v];
                min_index = v;
            }
 
        return min_index;
    }

    int[] dijkstra(int graph[][], int src)
    {
        int distance[] = new int[V];
 
        Boolean Set[] = new Boolean[V];
 
        for (int i = 0; i < V; i++)
        {
            Set[i] = false;
            distance[i] = Integer.MAX_VALUE;
            
        }
 
        dist[src] = 0;
 
        for (int count = 0; count < V-1; count++)
        {
            
            int u = minDistance(dist, sptSet);
 
            Set[u] = true;
 
            
            for (int v = 0; v < V; v++)
 
                if (!Set[v] && graph[u][v]!=0 &&
                        distance[u] != Integer.MAX_VALUE &&
                        distance[u]+graph[u][v] < distance[v])
                    distance[v] = distance[u] + graph[u][v];
        }
 
        return distance;
    }
 
}
