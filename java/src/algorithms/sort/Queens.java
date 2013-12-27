package algorithms.sort;

public class Queens {
	private int[][] board = null;
	private void printQueen() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 1)
					System.out.print('X');
				else
					System.out.print('O');
			}
			System.out.println();
		}
	}
	// if we can put a queen at column:column of row:row
	private boolean canPlace(int row,int col) {
		for (int i=0;i<row;i++) {
			if (board[i][col] == 1)
				return false;
		}
		return true;
	}

	public void PlaceQueens(int k, int n) {
		if (board == null)
			board = new int[n][n];
		if (k == n) {
			printQueen();
		} else {
			for (int i = 0; i < n; i++) {
				if (canPlace(k, i)) {
					board[k][i] = 1;
					PlaceQueens(k + 1, n);
				}
			}
		}
	}
}
