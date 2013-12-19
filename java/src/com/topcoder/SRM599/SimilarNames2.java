package com.topcoder.SRM599;

import java.util.Arrays;

public class SimilarNames2 {

    static int MOD = 1000000007;

    public int count(String[] names, int L) {
	int n = names.length;
	int dp[][] = new int[L + 1][n];
	for (int i = 0; i < n; i++) {
	    dp[L][i] = 1;
	}
	for (int i = L - 1; i >= 1; i--) {
	    for (int j = 0; j < n; j++) {
		dp[i][j] = 0;
		for (int k = 0; k < n; k++) {
		    if (names[k].startsWith(names[j])) {
			dp[i][j] += dp[i + 1][k];
		    }
		}
		dp[i][j] %= MOD;
	    }
	}
	long sum = 0;
	for (int i = 0; i < n; i++)
	    sum += dp[1][i];
	sum %= MOD;
	long f = 1;
	for (int i = 1; i <= n - L; i++) {
	    f = (f * i) % MOD;
	}
	return (int) (sum * f) % MOD;
    }
}
