package hackerrank.algorithms.countInversions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static int getSum(int[] BIT, int index) {
		int sum = 0;
		while (index > 0) {
			sum += BIT[index];
			index -= index & (-index);
		}
		return sum;
	}

	private static void updateBIT(int[] BIT, int n, int index, int val) {
		while (index <= n) {
			BIT[index] += val;
			index += index & (-index);
		}
	}

	private static void countInversions(int[] a) {
		int maxElement = 0;
		for (int i = 0; i < a.length; i++)
			if (maxElement < a[i])
				maxElement = a[i];
		int[] BIT = new int[maxElement + 1];
		long ans = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			ans += getSum(BIT, a[i] - 1);
			updateBIT(BIT, maxElement, a[i], 1);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("testdata"));
		//Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int arr_i = 0; arr_i < n; arr_i++) {
				arr[arr_i] = in.nextInt();
			}
			countInversions(arr);
		}
		in.close();
	}
}