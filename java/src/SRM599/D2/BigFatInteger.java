package SRM599.D2;

public class BigFatInteger {
	private int minD(int r) {
		int x = 1;
		int i = 0;
		while (x < r) {
			x *= 2;
			i++;
		}
		return i;
	}

	public int minOperations(int A, int B) {
		// factorize
		int m = 0;
		int p = 0;
		for (int i = 2; i <= A / i; i++) {
			int r = 0;
			while (A % i == 0) {
				r += B;
				A /= i;
			}
			if (r > 0) {
				p++;
				m = Math.max(m, minD(r));
			}
		}
		if (A != 1) {
			p++;
			m = Math.max(m, minD(B));
		}
		return m+p;
	}
}
