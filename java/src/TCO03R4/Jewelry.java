package TCO03R4;

import java.util.Arrays;

public class Jewelry {
	public long howMany(int[] values) {
		assert (values != null && values.length > 0);
		Arrays.sort(values);
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		sum = (int) Math.ceil(sum / 2);
		long[][] dp = new long[values.length][sum];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {

			}
		}
		return dp[values.length - 1][sum];
	}
}
