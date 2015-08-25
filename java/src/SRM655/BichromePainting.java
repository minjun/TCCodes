package SRM655;

import java.util.HashSet;
import java.util.Set;

public class BichromePainting {

	public String isThatPossible(String[] board, int k) {
		if (k == 1)
			return "Impossible";
		int n = board.length;
		Set<Point> points = new HashSet<Point>();
		for (int i = 0; i + k <= n; i++) {
			for (int j = 0; j + k <= n; j++) {
				points.add(new Point(i, j));
			}
		}
		while (true) {
			boolean okay = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i].charAt(j) == 'B') {
						okay = false;
					}
				}
			}
			if (okay) {
				return "Possible";
			}
			boolean change = false;
			for (Point p : points) {
				char ch = '?';
				boolean bad = false;
				for (int i = 0; i < k; i++) {
					for (int j = 0; j < k; j++) {
						char ch2 = board[p.x + i].charAt(p.y + j);
						if (ch2 != '?') {
							if (ch == '?') {
								ch = ch2;
							} else if (ch != ch2) {
								bad = true;
							}
						}
					}
				}
				if (!bad) {
					change = true;
					for (int i = 0; i < k; i++) {
						char[] arr = board[i].toCharArray();
						for (int j = 0; j < k; j++) {
							arr[p.y + j] = '?';
						}
						board[i] = new String(arr);
					}
					points.remove(p);
					break;
				}
			}
			if (!change) {
				break;
			}
		}
		return "Impossible";
	}
}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
