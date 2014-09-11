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
		int[] ways = new int[sum + 1];
		// find ways
		for (int i = 0; i < ways.length; i++) {
			ways[i] = 0;
		}
		ways[0] = 1;
		for (int j = 0; j < values.length; j++) {
			for (int i = sum; i >= values[j]; i--) {
				ways[i] += ways[i - values[j]];
			}
		}
		for (int i = 0; i < ways.length; i++) {
			System.out.print("sum[" + i + "]=" + ways[i] + " ");
		}
		System.out.println();
		// count
		int count = 0;
		for (int i = 0; i < values.length; i++) {
			for (int s = values[i]; s <= sum; s++) {
				count += ways[s - values[i]] * ways[s];
			}
		}
		return count;
	}
}
