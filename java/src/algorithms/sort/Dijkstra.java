package algorithms.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
	int vertex;
	int dist;

	Node(int vertex, int dist) {
		this.vertex = vertex;
		this.dist = dist;
	}
}

class NodeComparator implements Comparator<Node> {
	public int compare(Node arg0, Node arg1) {
		return arg0.dist - arg1.dist;
	}
}

public class Dijkstra {
	public int[] shortestPath(int[][] weights, int s) {
		int[] dist = new int[weights.length];
		int[] prev = new int[weights.length];
		// initialize
		PriorityQueue<Node> pq = new PriorityQueue<Node>(weights.length,
				new NodeComparator());
		for (int i = 0; i < weights.length; i++) {
			if (weights[s][i] == -1)
				dist[i] = Integer.MAX_VALUE;
			else
				dist[i] = weights[s][i];
			pq.add(new Node(i, dist[i]));
			prev[i] = -1;
		}
		while (!pq.isEmpty()) {
			Node node = pq.remove();
			for (int i = 0; i < weights.length; i++) {
				if (weights[node.vertex][i] > 0) {
					if (dist[i] > dist[node.vertex] + weights[node.vertex][i]) {
						dist[i] = dist[node.vertex] + weights[node.vertex][i];
						prev[i] = node.vertex;
					}
				}
			}
		}
		for (int i = 0; i < prev.length; i++)
			System.out.println("Prev of " + i + " is " + prev[i]);
		return dist;
	}
}
