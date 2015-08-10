package SRM664;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BearplaysDiv2 {

	private boolean transform(int a, int b, int c, Set<Piles> can) {
		if (a == b && b == c)
			return true;
		if (a < 0 || b < 0 || c < 0)
			return false;
		if (can.contains(new Piles(a, b, c)))
			return false;
		can.add(new Piles(a, b, c));
		if (transform(a + a, b - a, c, can))
			return true;
		if (transform(a + a, b, c - a, can))
			return true;
		if (transform(a, b + b, c - b, can))
			return true;
		if (transform(a, b - c, c + c, can))
			return true;
		if (transform(a - b, b + b, c, can))
			return true;
		if (transform(a - c, b, c + c, can))
			return true;
		return false;
	}

	public String equalPiles(int A, int B, int C) {
		Set<Piles> can = new HashSet<Piles>();
		if ((A + B + C) % 3 != 0)
			return "impossible";
		if (transform(A, B, C, can))
			return "possible";
		return "impossible";
	}
}

class Piles {
	int[] piles;

	public Piles(int a, int b, int c) {
		piles = new int[] { a, b, c };
		Arrays.sort(piles);
	}

	@Override
	public boolean equals(Object anotherPile) {
		return Arrays.equals(this.piles, ((Piles) anotherPile).piles);
	}

	@Override
	public int hashCode() {
		return piles[0] + piles[1] + piles[2];
	}
}