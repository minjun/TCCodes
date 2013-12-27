package SRM146.D2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeCrossing {
	// record already passed people
	// because we need the quickest people to bring back the flashlight
	List<Integer> timesPassed = new ArrayList<Integer>();

	public int minTime(int[] times) {
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
					sum1 += minTime(timesnew);
					sum = Math.min(sum, sum1);
				}
			}
		}
		return sum;
	}
}
