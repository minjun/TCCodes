package crackingTheCodingInterview.array;

public class Array {
	public static void rotateByNinetyToLeft(int[][] matrix, int n) {
		for (int x = 0; x < n / 2; ++x) {
			for (int y = x; y < n - 1 - x; ++y) {
				int top = matrix[x][y];
				matrix[x][y] = matrix[y][n - 1 - x];
				matrix[y][n - 1 - x] = matrix[n - 1 - x][n - 1 - y];
				matrix[n - 1 - x][n - 1 - y] = matrix[n - 1 - y][x];
				matrix[n - 1 - y][x] = top;
			}
		}
	}
}
