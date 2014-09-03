package SRM211.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GrafixMask {
	public int[] sortedAreas(String[] rectangles) {
		return bfs(rectangles);
	}

	public int[] dfs(String[] rectangles) {
		// /init grid to false.
		boolean[][] grid = new boolean[400][600];

		for (int g = 0; g < 400; g++) {
			for (int h = 0; h < 600; h++) {
				grid[g][h] = true; // /Assigns the specified boolean value to
									// each element of the specified array of
									// booleans.
			}
		}

		for (int i = 0; i < rectangles.length; i++) {
			String[] result = rectangles[i].split("\\s"); // / result[0] is x1.
															// result[1] is y1.
															// result[2] is x2.
															// result[3] is y2.
			for (int j = Integer.parseInt(result[0]); j <= Integer.parseInt(result[2]); j++) {
				for (int k = Integer.parseInt(result[1]); k <= Integer.parseInt(result[3]); k++) {
					grid[j][k] = false;

				}
			}
		}

		ArrayList<Integer> al = new ArrayList<Integer>();
		Stack<int[]> sta = new Stack<int[]>();
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		for (int x = 0; x < 400; x++) {
			for (int y = 0; y < 600; y++) {
				int result = 0;
				if (grid[x][y]) {
					sta.push(new int[] { x, y });
				}

				while (sta.empty() == false) {
					int[] s = sta.pop();
					int sx = s[0];
					int sy = s[1];
					if (sx < 0 || sy < 0 || sx >= 400 || sy >= 600 || !grid[sx][sy])
						continue;
					grid[sx][sy] = false;
					result++;
					for (int k = 0; k < dx.length; k++) {
						int a = sx + dx[k];
						int b = sy + dy[k];
						sta.push(new int[] { a, b });
					}
				}
				if (result != 0)
					al.add(result);
			}
		}

		int[] ret = new int[al.size()];
		for (int i = 0; i < al.size(); i++) {
			ret[i] = ((Integer) al.get(i)).intValue();
		}
		Arrays.sort(ret);

		// int[] duck = {1,0,1};
		return ret;
	}

	public int[] bfs(String[] rectangles) {
		final int ROW = 400;
		final int COL = 600;
		boolean visited[][] = new boolean[ROW][COL];
		List<Integer> areas = new LinkedList<Integer>();
		Queue<int[]> queue = new LinkedList<int[]>();
		// initialize
		for (int i = 0; i < rectangles.length; i++) {
			String[] coords = rectangles[i].split(" ");
			int x1 = Integer.parseInt(coords[0]);
			int y1 = Integer.parseInt(coords[1]);
			int x2 = Integer.parseInt(coords[2]);
			int y2 = Integer.parseInt(coords[3]);
			for (int j = x1; j <= x2; j++) {
				for (int k = y1; k <= y2; k++) {
					visited[j][k] = true;
				}
			}
		}
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				{
					if (visited[i][j])
						continue;
					int area = 0;
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					while (queue.size() > 0) {
						int[] coord = queue.poll();
						int x = coord[0];
						int y = coord[1];
						area++;
						if (x - 1 >= 0 && !visited[x - 1][y]) {
							visited[x - 1][y] = true;
							queue.add(new int[] { x - 1, y });
						}
						if (y - 1 >= 0 && !visited[x][y - 1]) {
							visited[x][y - 1] = true;
							queue.add(new int[] { x, y - 1 });
						}
						if (x + 1 < ROW && !visited[x + 1][y]) {
							visited[x + 1][y] = true;
							queue.add(new int[] { x + 1, y });
						}
						if (y + 1 < COL && !visited[x][y + 1]) {
							visited[x][y + 1] = true;
							queue.add(new int[] { x, y + 1 });
						}
					}
					areas.add(area);
				}
			}
		}
		Collections.sort(areas);
		int[] result = new int[areas.size()];
		for (int i = 0; i < areas.size(); i++) {
			result[i] = areas.get(i).intValue();
		}
		return result;
	}
}
