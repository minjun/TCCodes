package InterviewQuestions.PrintMatrixClockwisely;

import java.util.LinkedList;
import java.util.List;

public class PrintMatrix {
    private void PrintARowIncreasingly(int[][] matrix, int columns, int rows,
	    int y, int firstX, int lastX, List<Integer> list) {
	for (int i = firstX; i <= lastX; ++i)
	    list.add(matrix[y][i]);
    }

    void PrintAColumnIncreasingly(int[][] matrix, int columns, int rows, int x,
	    int firstY, int lastY, List<Integer> list) {
	for (int i = firstY; i <= lastY; ++i)
	    list.add(matrix[i][x]);
    }

    void PrintARowDecreasingly(int[][] matrix, int columns, int rows, int y,
	    int firstX, int lastX, List<Integer> list) {
	for (int i = firstX; i >= lastX; --i)
	    list.add(matrix[y][i]);
    }

    void PrintAColumnDecreasingly(int[][] matrix, int columns, int rows, int x,
	    int firstY, int lastY, List<Integer> list) {
	for (int i = firstY; i >= lastY; --i)
	    list.add(matrix[i][x]);
    }

    private void PrintMatrixInCircle(int[][] matrix, int columns, int rows,
	    int startX, int startY, List<Integer> list) {
	{
	    int endX = columns - 1 - startX;
	    int endY = rows - 1 - startY;

	    PrintARowIncreasingly(matrix, columns, rows, startY, startX, endX,
		    list);

	    if (startY < endY)
		PrintAColumnIncreasingly(matrix, columns, rows, endX,
			startY + 1, endY, list);

	    if (startX < endX && startY < endY)
		PrintARowDecreasingly(matrix, columns, rows, endY, endX - 1,
			startX, list);

	    if (startX < endX && startY < endY - 1)
		PrintAColumnDecreasingly(matrix, columns, rows, startX,
			endY - 1, startY + 1, list);
	}
    }

    public List<Integer> PrintMatrixClockwisely(int[][] matrix) {
	List<Integer> list = new LinkedList<Integer>();
	if (matrix != null) {
	    int startX = 0, startY = 0;
	    int rows = matrix.length;
	    int columns = matrix[0].length;
	    while (columns > startX * 2 && rows > startY * 2) {
		PrintMatrixInCircle(matrix, columns, rows, startX, startY, list);
		startX++;
		startY++;
	    }
	}
	return list;
    }
}
