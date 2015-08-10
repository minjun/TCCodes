package SRM663;

public class ABBADiv1 {

	private String reverse(String target) {
		StringBuffer sb = new StringBuffer();
		for (int i = target.length() - 1; i >= 0; i--) {
			sb.append(target.charAt(i));
		}
		return sb.toString();
	}

	private String cutTail(String target) {
		return target.substring(0, target.length() - 1);
	}

	public String canObtain(String initial, String target) {
		if (target.length() <= initial.length())
			return target.equals(initial) ? "Possible" : "Impossible";
		if (target.charAt(target.length() - 1) == 'A'
				&& canObtain(initial, cutTail(target)).equals("Possible")) {
			return "Possible";
		} else if (target.charAt(0) == 'B'
				&& canObtain(initial, cutTail(reverse(target))).equals(
						"Possible")) {
			return "Possible";
		} else {
			return "Impossible";
		}
	}
}
