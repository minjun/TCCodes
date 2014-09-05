package algorithms.sort;

public class LongestNonDescreasingSequence {
	public int maxLongestNonDescreasingSequence(int[] args) {
		int[] maxLength = new int[args.length];
		for (int i = 1; i < maxLength.length; i++) {
			maxLength[i] = 1;
			for (int j = 1; j < i; j++) {
				int max = 0;
				if (args[i] > args[j])
					max = maxLength[j] + 1;
				else
					max = maxLength[j];
				maxLength[i] = Math.max(maxLength[i], max);
			}
		}
		return maxLength[maxLength.length - 1];
	}
}
