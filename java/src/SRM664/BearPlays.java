package SRM664;

public class BearPlays {
	public int pileSize(int A, int B, int K) {
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
}
