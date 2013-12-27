package TCO03SEMI4;

public class AvoidRoads {
	private boolean blocked(String[] bad, int x, int y, int x1, int y1) {
		for (int k = 0; k < bad.length; k++) {
			String[] cords = bad[k].split(" ");
			int x2 = Integer.parseInt(cords[0]);
			int y2 = Integer.parseInt(cords[1]);
			int x3 = Integer.parseInt(cords[2]);
			int y3 = Integer.parseInt(cords[3]);
			if ((x2 == x && y2 == y && x3 == x1 && y3 == y1)
					|| (x2 == x1 && y2 == y1 && x3 == x && y3 == y)) {
				return true;
			}
		}
		return false;
	}

	public long numWays(int width, int height, String[] bad) {
		long[][] dp = new long[width + 1][height + 1];
		dp[0][0] = 1;
		for (int i = 0; i <= width; i++)
			for (int j = 0; j <= height; j++) {
				if (i > 0 && !blocked(bad, i - 1, j, i, j))
					dp[i][j] += dp[i - 1][j];
				if (j > 0 && !blocked(bad, i, j - 1, i, j)) {
					dp[i][j] += dp[i][j - 1];
				}
			}
		return dp[width][height];
	}
}