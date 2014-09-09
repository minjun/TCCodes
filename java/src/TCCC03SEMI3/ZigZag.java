package TCCC03SEMI3;

public class ZigZag {
	public int longestZigZag(int[] sequence) {
		assert (sequence != null && sequence.length > 0);
		if (sequence.length == 1)
			return 1;
		else {
			int[] diff = new int[sequence.length - 1];
			for (int i = 0; i < diff.length; i++) {
				diff[i] = sequence[i + 1] - sequence[i];
			}
			int[] maxL = new int[sequence.length - 1];
			maxL[0] = 1;
			for (int i = 1; i < maxL.length; i++) {
				int length;
				for (int j = 0; j < i; j++) {
					if (diff[i] * diff[j] < 0) {
						length = maxL[j] + 1;
					} else {
						length = maxL[j];
					}
					maxL[i] = Math.max(maxL[i], length);
				}
			}
			return maxL[maxL.length - 1] + 1;
		}
	}
}
