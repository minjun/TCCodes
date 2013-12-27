package TCCC04R4;

public class BadNeighbors {
	public int maxDonations(int[] donations) {
		int dp[] = new int[donations.length];
		// without last
		dp[0] = donations[0];
		dp[1] = Math.max(dp[0], donations[1]);
		for (int i = 2; i < donations.length - 1; i++) {
			dp[i] = Math.max(dp[i - 2] + donations[i], dp[i - 1]);
		}
		int max = dp[donations.length - 2];
		// without first
		dp[1] = donations[1];
		if (donations.length > 2) {
			dp[2] = Math.max(dp[1], donations[2]);
			for (int i = 3; i < donations.length; i++) {
				dp[i] = Math.max(dp[i - 2] + donations[i], dp[i - 1]);
			}
		}
		return Math.max(max, dp[donations.length - 1]);
	}
}
