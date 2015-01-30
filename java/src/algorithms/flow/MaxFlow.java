package algorithms.flow;

public class MaxFlow {
	private int find_path(int[][] weights, int start, int end, int[][] cap) {
		int[] queue = new int[weights.length];
		boolean[] visited = new boolean[weights.length];
		int[] from = new int[weights.length];
		for (int i = 0; i < weights.length; i++)
			from[i] = -1;
		int qget = 0, qput = 0;
		queue[qput++] = start;
		visited[start] = true;
		// breadth first search
		while (qget <= qput) {
			int vertex = queue[qget++];
			for (int i = 0; i < weights.length; i++) {
				if (weights[vertex][i] > 0 && !visited[i] && cap[vertex][i] > 0) {
					queue[qput++] = i;
					visited[i] = true;
					from[i] = vertex;
					if (i == end) {
						qget = qput + 1;
						break;
					}
				}
			}
		}
		// find the minium path capacity
		int path_cap = Integer.MAX_VALUE;
		int where = end;
		while (from[where] > -1) {
			int prev = from[where];
			path_cap = Math.min(path_cap, cap[prev][where]);
			where = prev;
		}
		// update residual network
		where = end;
		while (from[where] > -1) {
			int prev = from[where];
			cap[prev][where] -= path_cap;
			cap[where][prev] += path_cap;
			where = prev;
		}
		if (path_cap == Integer.MAX_VALUE)
			return 0;
		return path_cap;
	}

	public int maxFlow(int[][] weights, int start, int end) {
		int result = 0;
		int path_capacity;
		int[][] cap = new int[weights.length][weights[0].length];
		for (int i = 0; i < weights.length; i++)
			for (int j = 0; j < weights[0].length; j++) {
				if (weights[i][j] > 0)
					cap[i][j] = weights[i][j];
			}
		while ((path_capacity = find_path(weights, start, end, cap)) > 0) {
			result += path_capacity;
		}
		return result;
	}
}
