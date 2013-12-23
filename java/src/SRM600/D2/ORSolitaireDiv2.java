package SRM600.D2;

public class ORSolitaireDiv2 {
    private int res = 0;

    private void backTrack(int[] numbers, int p, int x, int removed, int goal) {
	if (p == numbers.length) {
	    res = Math.min(res, removed);
	} else {
	    if ((goal | numbers[p]) != goal) {
		backTrack(numbers, p + 1, x, removed, goal);
	    } else {
		if (removed + 1 < res) {
		    backTrack(numbers, p + 1, x, removed + 1, goal);
		} else {
		    if ((x | numbers[p]) != goal) {
			backTrack(numbers, p+1, x | numbers[p], removed, goal);
		    }
		}
	    }
	}
    }

    public int getMinimum(int[] numbers, int goal) {
	res = numbers.length;
	backTrack(numbers, 0, 0, 0, goal);
	return res;
    }
}
