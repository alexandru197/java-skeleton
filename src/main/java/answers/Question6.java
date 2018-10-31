package answers;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Question6
{
	static int V = 0;
	static int dist[] = new int[1];

	public static int minDistance(int dist[], Boolean sptSet[])
	{
		int min = Integer.MAX_VALUE, min_index=-1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	public static void printSolution(int dist[], int n)
	{
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i+" tt "+dist[i]);
	}

	public static void dijkstra(int graph[][], int src)
	{
		Boolean sptSet[] = new Boolean[V];

		for (int i = 0; i < V; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < V-1; count++)
		{
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;

			for (int v = 0; v < V; v++)
				if (!sptSet[v] &&
						dist[u] != Integer.MAX_VALUE &&
						dist[u]+graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
//        printSolution(dist, V);
	}


	public static int shortestServerRoute(int numServers, int targetServer, int[][] times) {
		if (times == null || times.length == 0) {
			return 0;
		}

		V = numServers;
		dist = new int[V+10];

		dijkstra(times, 0);

		return dist[targetServer];
	}

//    public static void main (String[] args)
//    {
//
//        /* Let us create the example graph discussed above */
//        int graph[][] = new int[][]{
//                {0, 7, 4},
//                {7, 0, 2},
//                {4, 2, 0}
//        };
//
//        System.out.println(shortestServerRoute(graph.length, 1, graph));
//    }
}