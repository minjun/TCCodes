package SRM600.D2;

public class TheShuttles {
	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
		int sum = Integer.MAX_VALUE;
		for (int j = 1; j <= 100; j++) {
			int num = 0;
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] % j == 0)
					num += cnt[i] / j;
				else
					num += cnt[i] / j + 1;
			}
			sum = Math.min(sum, (baseCost + j * seatCost) * num);
		}
		return sum;
	}
}
