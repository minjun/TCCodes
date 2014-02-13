package InterviewQuestions.MaxPairDiffToRight;

public class MaxPairDiffToRight {
    public int MaxDiff(int[] values) {
	int maxValue = values[0];
	int maxDiff = Integer.MIN_VALUE;
	for (int i = 1; i < values.length; i++) {
	    maxDiff = Math.max(maxDiff, maxValue - values[i]);
	    if (values[i] > maxValue) {
		maxValue = values[i];
	    }

	}
	return maxDiff;
    }
}
