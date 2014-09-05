package algorithms.sort;

public class Queens {
	private int[][] board = null;
	private int number = 0;

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
	private boolean canPlace(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 1)
				return false;
		}
		return true;
	}

	private void initBoard() {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = 0;
	}

	public void PlaceQueens(int k, int n) {
		if (board == null)
			board = new int[n][n];
		if (k == n) {
			number++;
			System.out.println("Solution:"+number);
			printQueen();
		} else {
			for (int i = 0; i < n; i++) {
				if (k == 0) initBoard();
				if (canPlace(k, i)) {
					board[k][i] = 1;
					PlaceQueens(k + 1, n);
				}
			}
		}
	}
}
