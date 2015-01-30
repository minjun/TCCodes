package algorithms.graph;

public class FloydWarshall {
	public int[][] shortestPath(int[][] weights) {
		int n = weights.length;
		int[][][] dist = new int[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (k == 0 && weights[i][j] != -1)
						dist[i][j][k] = weights[i][j];
					else
						dist[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 1; k < n; k++) {
					dist[i][j][k] = Math.min(dist[i][j][k - 1],
							dist[i][k][k - 1] + dist[k][j][k - 1]);
					if (k == n-1)
						System.out.println(dist[i][j][k]);
				}
			}
		}
		return null;
	}
}
