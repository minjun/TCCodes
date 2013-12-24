package SRM600.D1;

public class ORSolitaire {
	public int getMinimum(int[] numbers, int goal) {
		int res = numbers.length;
		for (int i = 0; i < 32; i++) {
			if ((goal & (1 << i)) > 0) {
				int c = 0;
				for (int x : numbers) {
					if ((x & (1 << i)) > 0 && ((goal & x) == x)) {
						c++;
					}
				}
				res = Math.min(res, c);
			}
		}
		return res;
	}
}
