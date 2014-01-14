package SRM602.D2;

public class BlackBoxDiv2 {
    private static int MOD = 1000000007;

    // Pascal's triangle: compute binomial coefficients
    private void getC(int c[][]) {
	for (int i = 0; i < c.length; i++) {
	    c[i][0] = 1;
	    for (int j = 1; j <= i; j++) {
		c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
	    }
	}
    }

    public int count(String front, String side) {
	int w = 0, h = 0;
	for (int i = 0; i < front.length(); i++) {
	    if (front.charAt(i) == 'B') {
		w++;
	    }
	}
	for (int i = 0; i < side.length(); i++) {
	    if (side.charAt(i) == 'B') {
		h++;
	    }
	}
	int c[][] = new int[51][51];
	getC(c);
	int dp[][] = new int[w + 1][h + 1];
	for (int i = 0; i <= w; i++) {
	    for (int j = 0; j <= h; j++) {
		if (i == 0) {
		    dp[i][j] = (j == 0) ? 1 : 0;
		} else {
		    dp[i][j] = 0;
		    for (int r = 0; r <= h - j; r++) {
			for (int s = 0; s <= j; s++) {
			    if (r + s >= 1) {
				int p = c[j][s];
				p = (p * c[h - j][r]) % MOD;
				dp[i][j] += (p * dp[i - 1][j - s]) % MOD;
			    }
			}
		    }
		    dp[i][j] %= MOD;
		}
	    }
	}
	return dp[w][h];
    }

}
