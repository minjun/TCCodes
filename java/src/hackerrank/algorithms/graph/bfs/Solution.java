package hackerrank.algorithms.graph.bfs;

import java.io.*;
import java.util.*;

public class Solution {

	private static void bfs(int n, int[][] e, int s) {
		int[] d = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n + 1; i++) {
			d[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		d[s] = 0;
		q.add(s);
		while (!q.isEmpty()) {
			int v = q.poll();
			visited[v] = true;
			for (int i = 1; i < n + 1; i++) {
				if (e[v][i] == 1) {
					d[i] = Math.min(d[i], d[v] + 6);
					if (!visited[i])
						q.add(i);
				}
			}
		}
		for (int i = 1; i < n + 1; i++) {
			if (i == s)
				continue;
			if (d[i] == Integer.MAX_VALUE)
				System.out.print("-1 ");
			else
				System.out.print(d[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(new File("test.txt"));
		int q = scanner.nextInt();
		for (int i = 0; i < q; i++) {
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			int[][] e = new int[n + 1][n + 1];
			for (int j = 0; j < m; j++) {
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				e[from][to] = 1;
				e[to][from] = 1;
			}
			int s = scanner.nextInt();
			bfs(n, e, s);
		}
		scanner.close();
	}
}