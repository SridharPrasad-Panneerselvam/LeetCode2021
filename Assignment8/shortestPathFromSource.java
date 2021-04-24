//1).Given a graph and a source vertex in the graph, find shortest paths from source to all vertices in the given graph.

class ShortestPathAlgorithm {
	static final int V = 9;
	static int minDistance(int dist[], Boolean sptSet[])
	{
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	static void printSolution(int dist[])
	{
		System.out.println("Vertex \t\t Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	static void shortestpath(int graph[][], int src)
	{
		int dist[] = new int[V]; 
		Boolean sptSet[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < V - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		printSolution(dist);
	}

	public static void main(String[] args)
	{
		int graph[][] = new int[][] { { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
									{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 },
									{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
									{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
									{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
									{ 4, 0, 8, 0, 0, 0, 0, 11, 0},
									{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		shortestpath(graph, 0);
	}
}