package SRM207.D2;

public class CaptureThemAll {
	private static final int ROW = 8;

	private int[] npos(int x, int y, int i) {
		int x1 = 0, y1 = 0;
		switch (i) {
		case 0:
			x1 = -2;
			y1 = -1;
			break;
		case 1:
			x1 = -2;
			y1 = 1;
			break;
		case 2:
			x1 = 2;
			y1 = -1;
			break;
		case 3:
			x1 = 2;
			y1 = 1;
			break;
		case 4:
			x1 = -1;
			y1 = -2;
			break;
		case 5:
			x1 = -1;
			y1 = 2;
			break;
		case 6:
			x1 = 1;
			y1 = -2;
			break;
		case 7:
			x1 = 1;
			y1 = 2;
			break;
		}
		x += x1;
		y += y1;
		if (!(x >= 0 && x < ROW && y >= 0 && y < ROW))
			return new int[] { -1, -1 };
		return new int[] { x, y };
	}

	public int fastKnight(String knight, String rook, String queen) {
		int[][] distances = new int[ROW][ROW];
		int[][] queue = new int[ROW * ROW][2];
		int startX = knight.charAt(0) - 'a';
		int startY = knight.charAt(1) - '1';
		int sumdis = 0;
		boolean getR = false, getQ = false;
		while (true) {
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < ROW; j++) {
					distances[i][j] = -1;// Using -1 for infinity
				}
			}
			distances[startX][startY] = 0;
			queue[0][0] = startX;
			queue[0][1] = startY;
			int head = 0;
			int tail = 1;
			boolean get = false;
			while (tail > head) {
				int x = queue[head][0];
				int y = queue[head][1];
				head++;
				if (!getR && x == (rook.charAt(0) - 'a')
						&& y == (rook.charAt(1) - '1')) {
					get = true;
					getR = true;
				}
				if (!getQ && x == (queen.charAt(0) - 'a')
						&& y == (queen.charAt(1) - '1')) {
					get = true;
					getQ = true;
				}
				if (get) {
					sumdis += distances[x][y];
					if (getR && getQ)
						return sumdis;
					startX = x;
					startY = y;
					break;
				}
				for (int i = 0; i < 8; i++) {
					int[] numbers = npos(x, y, i);
					int x1 = numbers[0];
					int y1 = numbers[1];
					if (x1 != -1 && y1 != -1 && distances[x1][y1] == -1) {
						distances[x1][y1] = distances[x][y] + 1;
						queue[tail][0] = x1;
						queue[tail][1] = y1;
						tail++;
					}
				}// end for
			} // end while
		}// end while
	}
}
