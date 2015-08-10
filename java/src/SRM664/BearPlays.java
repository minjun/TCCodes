package SRM664;

public class BearPlays {
	public int pileSize_slow(int A, int B, int K) {
		int low, high;
		while (K > 0) {
			K--;
			if (A <= B) {
				low = A;
				high = B;
			} else {
				low = B;
				high = A;
			}
			high -= low;
			low += low;
			A = low;
			B = high;
		}
		if (A <= B)
			return A;
		else
			return B;
	}

	public int pileSize(int A, int B, int K) {
		int mod = A + B;
		long res = 1;
		long two = 2;
		// fast exponentiation
		while (K > 0) {
			if (K % 2 == 1)
				res = res * two % mod;
			two = two * two % mod;
			K /= 2;
		}
		res = res * A % mod;
		return Math.min((int) res, A + B - (int) res);
	}
}
