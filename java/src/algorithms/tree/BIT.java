package algorithms.tree;

import java.util.Arrays;

public class BIT {
	public static void updateBIT(int[] bit, int n, int index, int val) {
		index = index + 1;
		while (index <= n) {
			bit[index] += val;
			index += index & (-index);
			// 1 + 1&-1=1+1&101=2
			System.out.print(index+" ");
			System.out.println(Arrays.toString(bit));
		}
	}

	public static int[] constructBIT(int[] a) {
		int n = a.length;
		int[] bit = new int[n + 1];
		for (int i = 0; i < n; i++)
			updateBIT(bit, n, i, a[i]);
		return bit;
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] bit = constructBIT(a);
	}
}
