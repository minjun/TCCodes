package com.topcoder.srm565;

public class DivisibleSequence {
	private final int MOD = 1000000009;

	long modPow(long x, long y) {
		long r = 1, a = x;
		while (y > 0) {
			if ((y & 1) == 1) {
				r = (r * a) % MOD;
			}
			a = (a * a) % MOD;
			y /= 2;
		}
		return r;
	}

	long modInverse(long x) {
		return modPow(x, MOD - 2);
	}

	long modDivision(long p, long q) {
		return (p * modInverse(q)) % MOD;
	}

	private long C(int n, int k) {
		if (k > n)
			return 0;
		long p = 1, q = 1;
		for (int i = 1; i <= k; i++) {
			q = (q * i) % MOD;
			p = (p * (n - i + 1)) % MOD;
		}
		return modDivision(p, q);
	}

	public int count(int N, int H) {

		long res = 1;
		// Let us use trial divison to find prime factors p
		for (int p = 2; p <= N / p; p++) {
			int c = 0;
			while (N % p == 0) {
				N /= p;
				c++;
			}
			res = (res * C(H - 1 + c, c)) % MOD;
		}

		if (N > 1) {
			// N is one last prime factor, c = 1
			// C(H-1+1,1) = H
			res = (res * H) % MOD;
		}
		return (int) res;
	}
}
