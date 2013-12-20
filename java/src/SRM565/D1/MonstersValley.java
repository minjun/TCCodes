package SRM565.D1;
/* minjun wang */
public class MonstersValley {
	private int minimumPriceBT(int[] dread, int[] price, int i, long sumDread) {
		if (i >= dread.length)
			return 0;
		if (sumDread < dread[i]) {
			return price[i]
					+ minimumPriceBT(dread, price, i + 1, sumDread + dread[i]);
		} else {
			int sumPriceBribe = price[i]
					+ minimumPriceBT(dread, price, i + 1, sumDread + dread[i]);
			int sumPriceNoBribe = minimumPriceBT(dread, price, i + 1, sumDread);
			if (sumPriceBribe < sumPriceNoBribe) {
				return sumPriceBribe;
			} else {
				return sumPriceNoBribe;
			}
		}
	}

	/*
	 * {200, 107, 105, 206, 307, 400} {1, 2, 1, 1, 1, 2} Returns: 2 Manao can
	 * bribe monsters 0 and 3.
	 */
	public int minimumPrice(int[] dread, int[] price) {
		return minimumPricePoly(dread, price);
	}

	private int minimumPricePoly(int[] dread, int[] price) {
		int n = dread.length;
		long[][] maxDread = new long[2 * n + 1][n + 1];
		for (int i = 0; i < 2 * n + 1; i++) {
			maxDread[i][0] = 0;
			for (int j = 1; j <= n; j++) {
				maxDread[i][j] = Long.MIN_VALUE;
				// bribe j-1
				if (i > price[j-1]) {
					maxDread[i][j] = maxDread[i - price[j - 1]][j - 1]
							+ dread[j - 1];
				}
				if (maxDread[i][j - 1] > price[j-1]) {
					maxDread[i][j] = Math.max(maxDread[i][j],
							maxDread[i][j - 1]);
				}
			}
		}
//		for (int i=0;i<2*n+1;i++) {
//			for (int j=0;j<n+1;j++) {
//				System.out.print(maxDread[i][j]+" ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < 2 * n + 1; i++) {
			if (maxDread[i][n] >= 0) {
				return i;
			}
		}
		return 2 * n;
	}
}
