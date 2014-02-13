package SRM604.D2;

public class PowerOfThreeEasy {
    @SuppressWarnings("unused")
    private String ableToGet(int x, int y, int p) {
	// if x or y was negative, it is impossible.
	// Else if x==0 , y==0 it is already possible.
	// else we backtrack, first subtracting p from x or y and remember to
	// multiply p by 3.
	if ((x >= 0)
		&& (y >= 0)
		&& ((x == 0 && y == 0)
			|| (ableToGet(x - p, y, p * 3) == "Possible") || (ableToGet(
			x, y - p, p * 3) == "Possible"))) {
	    return "Possible";
	} else {
	    return "Impossible";
	}
    }

    public String ableToGet(int x, int y) {
	// return ableToGet(x, y, 1);
	// If (x==0, y==0, then it is possible).
	while (x != 0 || y != 0) {
	    // decreasing one of x or y must yield a multiple of 3.
	    // so either x%3 == 1 and y%3 == 0 or
	    // x%3 == 0 and y%3 == 1.
	    // It can be reduced to the following condition:
	    if (x % 3 + y % 3 != 1) {
		return "Impossible";
	    }
	    // Decrease one of them, divide them by 3.
	    // * If x % 3 == 1, then x/3 = (x-1)/3
	    // * Same with y.
	    x /= 3;
	    y /= 3;
	}
	return "Possible";
    }
}
