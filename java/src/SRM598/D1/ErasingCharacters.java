package SRM598.D1;

/* minjun wang */
public class ErasingCharacters {
	public String simulate1(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				return simulate1(s.substring(0, i) + s.substring(i + 2));
			}
		}
		return s;
	}

	public String simulate2(String s) {
		while (true) {
			int i = 0;
			for (i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					break;
				}
			}
			if (s.length() < 2 || i == s.length() - 1) {
				break;
			} else {
				s = s.substring(0, i) + s.substring(i + 2);
			}
		}
		return s;
	}

	public String simulate(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (sb.length() == 0)
				sb.append(s.charAt(i));
			else if (s.charAt(i) == sb.charAt(sb.length() - 1)) {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
