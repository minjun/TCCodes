package SRM663;

public class ABBADiv1 {

	private String reverseString(String target) {
		StringBuffer sb = new StringBuffer();
		for (int i = target.length() - 1; i >= 0; i--) {
			sb.append(target.charAt(i));
		}
		return sb.toString();
	}

	public String canObtain(String initial, String target) {
		if (target.length() <= initial.length())
			return target.equals(initial) ? "Possible" : "Impossible";
		char ch = target.charAt(target.length() - 1);
		target = target.substring(0, target.length() - 1);
		if (ch == 'A') {
			return (canObtain(initial, target).equals("Possible") || canObtain(initial, reverseString(target)).equals("Possible")) ? "Possible" : "Impossible";
		} else {
			return canObtain(initial, reverseString(target));
		}
	}
}
