package com.topcoder.SRM598;

public class TPS {

	private int rec(int[][][] dp, String[] linked, int x, int parent, int must) {
		int n = linked.length;
		int res = n;
		if (dp[x][parent][must] == -1) {
			int sum = 0; // sum of rec(y,x, true) for each child y of x
			int c = 0;
			for (int y = 0; y < n; y++) {
				if (parent != y && linked[x].charAt(y) == 'Y') {
					c++;
					sum += rec(dp, linked, y, x, 1);
				}
			}
			if (c == 0) {
				res = must; // leaf
			} else {
				// Number of beacons so that at least c-1 branches have a beacon
				int tem = n;
				for (int y = 0; y < n; y++) {
					if ((parent != y) && (linked[x].charAt(y) == 'Y')) {
						tem = Math.min(tem, sum - rec(dp, linked, y, x, 1)
								+ rec(dp, linked, y, x, 0));
					}
				}
				// a) put beacon
				res = Math.min(res, 1 + tem);
				// b) don't put beacon
				if (parent != n) { // must not be the root
					if (must == 1 && c == 1) {
						res = Math.min(res, sum);
					} else {
						res = Math.min(res, tem);
					}
				}
			}
		}
		return res;
	}

	public int minimalBeacons(String[] linked) {
		int dp[][][] = new int[50][51][2];
		for (int i = 0; i < 50; i++)
			for (int j = 0; j < 51; j++)
				for (int k = 0; k < 2; k++) {
					dp[i][j][k] = -1;
				}
		int n = linked.length;
		int res = n;
		for (int i = 0; i < n; i++) {
			res = Math.min(res, rec(dp, linked, i, n, 0));
		}
		return res;
	}
}