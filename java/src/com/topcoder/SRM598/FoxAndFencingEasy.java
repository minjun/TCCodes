package com.topcoder.SRM598;

public class FoxAndFencingEasy {
	public String WhoCanWin(int mov1, int mov2, int d) {
		if ((d <= mov1) || (mov2 * 2 < mov1)) {
			return "Ciel";
		} else if (mov1 * 2 < mov2) {
			return "Liss";
		} else {
			return "Draw";
		}
	}
}
