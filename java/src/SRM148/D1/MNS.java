package SRM148.D1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MNS {
	private int ans = 0;
	private int row = 0;

	private boolean isExist(List<int[]> results, int[] newresult) {
		for (int i = 0; i < results.size(); i++) {
			if (Arrays.equals(results.get(i), newresult)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkPermution(int[] status) {
		int[][] check = new int[row][row];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				check[i][j] = status[3 * i + j];
			}
		}
		int sum = 0;
		for (int i = 0; i < row; i++) {
			sum += check[0][i];
		}
		for (int i = 0; i < row; i++) {
			int sum1 = 0, sum2 = 0;
			for (int j = 0; j < row; j++) {
				sum1 += check[i][j];
				sum2 += check[j][i];
			}
			if (sum1 != sum || sum2 != sum)
				return false;
		}
		//printStatus(status);
		return true;
	}

	@SuppressWarnings("unused")
	private void printStatus(int[] status) {
		for (int i = 0; i < status.length; i++) {
			System.out.print(status[i] + " ");
		}
		System.out.println();
	}

	private void go(int index, int[] numbers, int[] used, int[] status, List<int[]> results) {
		if (index == 9) {
			if (checkPermution(status) && !isExist(results, status)) {
				results.add(status.clone());
				ans++;
			}
		} else {
			for (int i = 0; i < used.length; i++) {
				if (used[i] == 1)
					continue;
				used[i] = 1;
				status[index] = numbers[i];
				go(index + 1, numbers, used, status, results);
				used[i] = 0;
			}
		}

	}

	public int combos(int[] numbers) {
		assert (numbers.length == 9);
		int[] status = new int[numbers.length];
		int[] used = new int[numbers.length];
		ans = 0;
		row = (int) Math.sqrt(status.length);
		//Arrays.sort(numbers);
		go(0, numbers, used, status, new ArrayList<int[]>());
		return ans;
	}
}
