package SRM660;

public class Cyclemin {
	public String bestmod(String s, int k) {
		String sMin = s;
		for (int i = 0; i <= s.length(); i++) {
			String s1 = s.substring(i) + s.substring(0, i);
			char[] arr = s1.toCharArray();
			int m = k;
			for (int j = 0; j < arr.length; j++) {
				if (m == 0)
					break;
				if (arr[j] != 'a') {
					arr[j] = 'a';
					m--;
				}
			}
			s1 = new String(arr);
			if (s1.compareTo(sMin) < 0) {
				sMin = s1;
			}
		}
		return sMin;
	}
}
