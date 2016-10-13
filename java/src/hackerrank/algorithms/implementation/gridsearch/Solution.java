package hackerrank.algorithms.implementation.gridsearch;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static boolean isPresent(int x, int y, String[] G, String[] P) {
		int lineP = P.length;
		int colP = P[0].length();
		int lineG = G.length;
		int colG = G[0].length();
		for (int i = 0; i < lineP; i++)
			for (int j = 0; j < colP; j++) {
				int ii = i + x, jj = j + y;
				if (ii >= lineG || jj >= colG || G[ii].charAt(jj) != P[i].charAt(j)) {
					return false;
				}
			}
		return true;
	}

	private static String findPattern(String[] G, String[] P) {
		for (int i = 0; i < G.length; i++) {
			for (int j = 0; j < G[0].length(); j++) {
				if (isPresent(i, j, G, P))
					return "YES";
			}
		}
		return "NO";
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("test.txt"));
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int R = in.nextInt();
			int C = in.nextInt();
			String G[] = new String[R];
			for (int G_i = 0; G_i < R; G_i++) {
				G[G_i] = in.next();
			}
			int r = in.nextInt();
			int c = in.nextInt();
			String P[] = new String[r];
			for (int P_i = 0; P_i < r; P_i++) {
				P[P_i] = in.next();
			}
			System.out.println(findPattern(G, P));
		}
	}
}