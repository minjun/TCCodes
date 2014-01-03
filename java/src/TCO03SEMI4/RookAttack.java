package TCO03SEMI4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RookAttack {
	// capacity of the residual network
	private int[] row_match;
	private int[] col_match;
	// limitation
	private List<List<Integer>> rowsPass;

	private boolean find_match(int source) {
		// from[x] = the row-vertex that precedes x in the path
		int[] from = new int[row_match.length];
		for (int i = 0; i < from.length; i++) {
			from[i] = -1;
		}
		from[source] = source;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		boolean bFoundPath = false;
		int where = 0, match = 0;
		while (!bFoundPath && !queue.isEmpty()) {
			where = queue.remove();
			for (int i = 0; i < rowsPass.get(where).size(); i++) {
				// there is a path from where->match
				match = rowsPass.get(where).get(i);
				// next = the row matched with column:match
				int next = col_match[match];
				if (where != next) {
					if (next == -1) {
						bFoundPath = true;
						break;
					}
					// check if we already visited the row-vertex next
					if (from[next] == -1) {
						queue.add(next);
						from[next] = where;
					}
				}
			}
		}
		if (!bFoundPath)
			return false;
		while (from[where] != where) {
			// we de-match where from its current match (aux) and match it with
			// match
			int aux = row_match[where];
			row_match[where] = match;
			col_match[match] = where;
			where = from[where];
			match = aux;
		}
		// at this point where = source
		row_match[where] = match;
		col_match[match] = where;
		return true;
	}
	@SuppressWarnings("unused")
	private boolean find_match_dfs(int where) {
		// the previous column was not matched
		if (where == -1)
			return true;
		boolean[] visited = new boolean[col_match.length];
		for (int i = 0; i < rowsPass.get(where).size(); ++i) {
			int match = rowsPass.get(where).get(i);
			if (visited[match] == false) {
				visited[match] = true;
				if (find_match_dfs(col_match[match])) {
					col_match[match] = where;
					return true;
				}
			}
		}
		return false;
	}

	public int howMany(int rows, int cols, String[] cutouts) {
		// initialization
		row_match = new int[rows];
		col_match = new int[cols];
		for (int i = 0; i < row_match.length; i++)
			row_match[i] = -1;
		for (int i = 0; i < col_match.length; i++)
			col_match[i] = -1;
		rowsPass = new ArrayList<List<Integer>>();
		for (int i = 0; i < rows; i++) {
			List<Integer> list1 = new ArrayList<Integer>();
			for (int j = 0; j < cols; j++) {
				int k = 0;
				for (k = 0; k < cutouts.length; k++) {
					String[] ij = cutouts[k].split(" ");
					if (i == Integer.parseInt(ij[0])
							&& j == Integer.parseInt(ij[1])) {
						break;
					}
				}
				if (k == cutouts.length) {
					list1.add(j);
				}
			}
			rowsPass.add(list1);
		}
		// computer augmenting path
		int ret = 0;
		for (int i = 0; i < rows; i++) {
			if (find_match(i)) {
				ret++;
			}
		}
		return ret;
	}
}
