package SRM197.D1;

import java.util.ArrayList;
import java.util.List;

public class GeneralChess {
	private boolean checkIfSameExist(String str, String[][] strings, int fromIndex) {
		if (fromIndex >= strings.length)
			return true;
		else {
			String[] strs = strings[fromIndex];
			int i = 0;
			for (i = 0; i < strs.length; i++) {
				if (str.equals(strs[i])) {
					return checkIfSameExist(str, strings, fromIndex + 1);
				}
			}
			return false;
		}
	}

	public String[] attackPositions(String[] pieces) {
		assert (pieces.length > 0);
		String[][] threatenedBy = new String[pieces.length][8];
		int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };
		for (int i = 0; i < pieces.length; i++) {
			String[] coord = pieces[i].split(",");
			if (coord.length == 2) {
				int x = Integer.parseInt(coord[0]);
				int y = Integer.parseInt(coord[1]);
				for (int j = 0; j < dx.length; j++) {
					threatenedBy[i][j] = "" + (x + dx[j]) + "," + (y + dy[j]);
				}
			}
		}
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < 8; i++) {
			String position = threatenedBy[0][i];
			if (position != null && checkIfSameExist(position, threatenedBy, 1))
				result.add(position);
		}
		return (String[]) result.toArray(new String[result.size()]);
	}
}
