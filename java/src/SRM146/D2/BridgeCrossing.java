package SRM146.D2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BridgeCrossing {
	// record already passed people
	// because we need the quickest people to bring back the flashlight
	List<Integer> timesPassed = new ArrayList<Integer>();

	// backTracking solution
	public int minTimeBT(int[] times) {
		int sum = Integer.MAX_VALUE;
		if (times.length == 1)
			sum = times[0];
		else if (times.length == 2)
			sum = Math.max(times[0], times[1]);
		// times.length > 2
		else {
			for (int i = 0; i < times.length; i++) {
				for (int j = i + 1; j < times.length; j++) {
					int sum1 = 0;
					sum1 += Math.max(times[i], times[j]);
					// the smaller will return
					int returned = Integer.MAX_VALUE;
					timesPassed.add(times[i]);
					timesPassed.add(times[j]);
					returned = Collections.min(timesPassed);
					timesPassed.remove(timesPassed.indexOf(returned));
					sum1 += returned;
					// left people: remove 'i','j', add 'returned'
					int[] timesnew = new int[times.length - 1];
					int l = 0;
					for (int k = 0; k < times.length; k++) {
						if (k != i && k != j) {
							timesnew[l++] = times[k];
						}
					}
					timesnew[l++] = returned;
					// now we need to pass left people
					sum1 += minTimeBT(timesnew);
					sum = Math.min(sum, sum1);
				}
			}
		}
		return sum;
	}

	public int minTime(int[] times) {
		Arrays.sort(times);
		int n = times.length;
		int sum = 0;
		int i = times.length;
		for (i = n - 1; i > 2; i -= 2) {
			sum += Math.min(times[0] + times[1] * 2 + times[i], times[0] * 2
					+ times[i - 1] + times[i]);
		}
		if (i == 2)
			sum = sum + times[0] + times[1] + times[2];
		else if (i == 1)
			sum = sum + times[1];
		else
			sum = times[0];
		return sum;
	}
}
