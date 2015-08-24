package SRM655;

public class FoldingPaper2 {
	private int times(int size, long wantSize) {
		if (size < wantSize || wantSize == 0)
			return Integer.MAX_VALUE / 3;
		if (size == wantSize)
			return 0;
		int times = 1;
		size = size % 2 == 0 ? size / 2 : size / 2 + 1;
		while (size > 1 && wantSize <= size) {
			times++;
			size = size % 2 == 0 ? size / 2 : size / 2 + 1;
		}
		return times;
	}

	public int solve(int W, int H, int A) {
		int times = Integer.MAX_VALUE;
		for (int i = 1; i <= Math.ceil(Math.sqrt(A)); i++) {
			if (A % i == 0) {
				int times1 = Math.min(times(W, i) + times(H, A / i), times(H, i) + times(W, A / i));
				times = Math.min(times, times1);
			}
		}
		return times >= Integer.MAX_VALUE / 3 ? -1 : times;
	}
}
