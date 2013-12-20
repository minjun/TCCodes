package SRM598.D1;

import java.util.Arrays;

public class BinPackingEasy {
	public int minBins(int[] item) {
		Arrays.sort(item);
		int i = 0;
		int j = item.length - 1;
		int bin = 0;
		while (i < j) {
			if (item[i] + item[j] <= 300) {
				i++;
				j--;
				bin++;
			} else {
				j--;
				bin++;
			}
		}
		if (i == j)
			bin++;
		return bin;
	}
}
