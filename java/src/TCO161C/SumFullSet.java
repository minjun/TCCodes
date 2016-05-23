package TCO161C;

public class SumFullSet {

	public String isSumFullSet(int[] elements) {
		boolean isFullSet = true;
		int i = -1;
		while (isFullSet && ++i < elements.length) {
			int j = i;
			while (isFullSet && ++j < elements.length) {
				int k = 0;
				for (k = 0; k < elements.length; k++) {
					if (elements[k] == elements[i] + elements[j]) {
						break;
					}
				}
				if (k == elements.length) {
					isFullSet = false;
				}
			}
		}
		return isFullSet ? "closed" : "not closed";
	}
}
