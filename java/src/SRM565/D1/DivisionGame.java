package SRM565.D1;

public class DivisionGame {
	public int computeNimber(int n) {
		int c = 0;
		for (int p = 2; p <= n / p; p++) {
			while (n % p == 0) {
				n /= p;
				c++;
			}
		}
		if (n > 1)
			c++;
		return c;
	}
	public long countWinningIntervals(int L, int R) {
		int n = R - L + 1;
		// compute nimber
		int[] nimber = new int[n];
		for (int i = L; i <= R; i++) {
			nimber[i-L] = computeNimber(i);
		}
		return 0;
	}
}
