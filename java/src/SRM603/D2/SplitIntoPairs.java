package SRM603.D2;

public class SplitIntoPairs {

    public int makepairs(int[] A, int X) {
	int minPositive = Integer.MAX_VALUE;
	int maxNegative = Integer.MIN_VALUE;
	int numNegative = 0;
	for (int i = 0; i < A.length; i++) {
	    if (A[i] < 0) {
		numNegative++;
		maxNegative = Math.max(maxNegative, A[i]);
	    } else {
		minPositive = Math.min(minPositive, A[i]);
	    }
	}
	if (numNegative % 2 == 0 || maxNegative * minPositive >= X) {
	    return A.length / 2;
	} else {
	    return A.length / 2 - 1;
	}
    }

}
