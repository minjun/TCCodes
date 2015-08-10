package SRM663;

public class ABBA {
	public String canObtain(String initial, String target) {
		while (target.length() > initial.length()) {
			char ch = target.charAt(target.length() - 1);
			if (ch == 'A') {
				target = target.substring(0, target.length() - 1);
			} else if (ch == 'B') {
				target = target.substring(0, target.length() - 1);
				StringBuffer sb = new StringBuffer();
				for (int i = target.length() - 1; i >= 0; i--) {
					sb.append(target.charAt(i));
				}
				target = sb.toString();
			}
		}
		return target.equals(initial) ? "Possible" : "Impossible";
	}
}
