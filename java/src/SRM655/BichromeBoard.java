package SRM655;

public class BichromeBoard {

	public String stringReplace(String str, int index, char ch) {
		if (index >= str.length() || index < 0)
			return str;
		if (index == 0)
			return "" + ch + str.substring(1);
		else if (index == str.length() - 1)
			return str.substring(0, index) + ch;
		else
			return str.substring(0, index) + ch + str.substring(index + 1);
	}

	public String ableToDraw(String[] board) {
		for (int k = 0; k < 2; k++) {
			boolean bad = false;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length(); j++) {
					char ch = board[i].charAt(j);
					if (ch != '?' && ch != (((k + i + j) % 2 == 0) ? 'W' : 'B')) {
						bad = true;
					}
				}
			}
			if (!bad) {
				return "Possible";
			}
		}
		return "Impossible";
	}
}
