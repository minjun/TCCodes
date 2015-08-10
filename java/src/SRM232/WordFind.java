package SRM232;

public class WordFind {
	public String[] findWords(String[] grid, String[] wordlist) {
		int indexX = 0, indexY = 0;
		String[] ret = new String[wordlist.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = "";
		}
		for (int m = 0; m < wordlist.length; m++) {
			for (int n = 0; n < wordlist[m].length(); n++) {
				int ch1 = wordlist[m].charAt(n);
				for (int i = 0; i < grid.length; i++) {
					for (int j = 0; j < grid[i].length(); j++) {
						char ch2 = grid[i].charAt(j);
						if (ch2 == ch1) {
							if (n == wordlist[m].length() - 1) {
								ret[m] = "\"" + indexX + " " + indexY + "\"";
							}
						}
					}
				}
			}
		}
		return ret;
	}
}
