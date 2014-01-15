package SRM601.D2;

public class WinterAndReindeers {

    private final static int INF = 50000;
    private int[][][] dp;

    private int cEndA[];
    private int cEndB[];

    // For each i, find the minimum cEnd[i], such that the substring [i, cEnd[i]
    // )
    // of A contains C as a subsequence.
    private void makeCEnd(String A, String C, int[] cEnd) {
	int n = A.length();
	int m = C.length();
	// For each i:
	for (int i = 0; i < n; i++) {
	    cEnd[i] = -1; // If none exist, mark with -1
	    int k = 0;
	    // Find the characters of C one by one, finish when we find them
	    // all:
	    for (int j = i; j < n; j++) {
		if (A.charAt(j) == C.charAt(k)) {
		    k++;
		    if (k == m) {
			cEnd[i] = j + 1;
			break;
		    }
		}
	    }
	}
    }

    private int getNumber(String A, String B, String C) {
	// Assume we already concatenated the contents of allA, allB and allC
	int m = A.length()+1;
	int n = B.length()+1;
	// precalculate cEndA:
	cEndA = new int[m];
	cEndB = new int[n];
	dp = new int[m][n][2];
	makeCEnd(A, C, cEndA);
	// precalculate cEndB:
	makeCEnd(B, C, cEndB);
	System.out.print("cEndA:");
	for (int i = 0; i < cEndA.length; i++)
	    System.out.print(cEndA[i] + ",");
	System.out.println();
	System.out.print("cEndB:");
	for (int i = 0; i < cEndB.length; i++)
	    System.out.print(cEndB[i] + ",");
	System.out.println();

	for (int i = A.length(); i >= 0; i--) {
	    for (int j = B.length(); j >= 0; j--) {
		for (int d = 0; d < 2; d++) {
		    int res = dp[i][j][d];
		    if (i >= A.length() || j >= B.length()) {
			res = (d > 0) ? 0 : -INF;
		    } else {
			res = -INF;
			if (A.charAt(i) == B.charAt(j)) {
			    // match
			    res = Math.max(res, 1 + dp[i + 1][j + 1][d]);
			}
			// move i:
			res = Math.max(res, dp[i + 1][j][d]);
			// move j:
			res = Math.max(res, dp[i][j + 1][d]);
			if ((cEndA[i] != -1) && (cEndB[j] != -1)) {
			    // match c!
			    res = Math.max(res, C.length()
				    + dp[cEndA[i]][cEndB[j]][1]);
			}
		    }
		}
	    }
	}
	return Math.max(0, dp[0][0][0]);
    }

    private String concat(String[] strs) {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < strs.length; i++) {
	    sb.append(strs[i]);
	}
	return sb.toString();
    }

    public int getNumber(String[] allA, String[] allB, String[] allC) {
	return getNumber(concat(allA), concat(allB), concat(allC));
    }
}
