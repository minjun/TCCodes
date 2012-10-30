package com.SRM1;

public class BinaryCode {

	public String[] decode(String message) {
		return new String[] { decode1(message, 0), decode1(message, 1) };
	}

	private String decode1(String message, int p0) {
		String ret = "";
		int p1 = 0, p = p0, p2 = p0;
		for (int i = 0; i < message.length(); i++) {
			ret = ret + String.valueOf(p2);
			int q = Integer.parseInt("" + message.charAt(i));
			p2 = q - p - p1;
			p1 = p;
			p = p2;
			if (p2 > 1 || p2 < 0 || p1 < 0 || p1 > 1) {
				ret = "NONE";
				break;
			}
		}
		return ret;
	}
}
