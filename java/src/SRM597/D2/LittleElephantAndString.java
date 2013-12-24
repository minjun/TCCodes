package SRM597.D2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LittleElephantAndString {
	private Map<String, Integer> getMultiSet(String A) {
		Map<String, Integer> sets = new HashMap<String, Integer>();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			Integer num = sets.get(ch);
			if (num == null) {
				num = 0;
			}
			num++;
			sets.put("" + ch, num);
		}
		Iterator<Map.Entry<String, Integer>> iter = sets.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iter
					.next();
			System.out.print(entry.getKey() + "=" + entry.getValue() + ";");

		}
		System.out.println();
		return sets;
	}

	public int getNumber(String A, String B) {
		if (getMultiSet(A) != getMultiSet(B)) {
			return -1;
		}
		int j = A.length() - 1;
		for (int i = B.length() - 1; i >= 0; i--) {
			while ((j >= 0) && (A.charAt(j) != B.charAt(i))) {
				j--;
			}
			if (j < 0)
				return i + 1;
			j--;
		}
		return 0;
	}
}
