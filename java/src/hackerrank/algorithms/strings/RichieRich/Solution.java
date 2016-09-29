package hackerrank.algorithms.strings.RichieRich;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		String number = in.next();
		StringBuffer sb = new StringBuffer(number);
		boolean[] changed = new boolean[n];
		for (int i = 0; i < n; i++)
			changed[i] = false;
		int t = 0;
		for (int i = 0; i < n / 2; i++) {
			char ch1 = sb.charAt(i);
			char ch2 = sb.charAt(n - 1 - i);
			if (ch1 != ch2) {
				t++;
				if (ch1 <= ch2) {
					changed[i] = true;
					sb.setCharAt(i, ch2);
				} else {
					changed[n - 1 - i] = true;
					sb.setCharAt(n - 1 - i, ch1);
				}
			}
		}
		if (t > k)
			System.out.println(-1);
		else if (n == 1) {
			if (k >= 1)
				System.out.println('9');
			else
				System.out.println(sb.toString());
		} else {
			for (int i = 0; i < n / 2; i++) {
				char ch = sb.charAt(i);
				if (i == n - 1 - i && !changed[i] && ch != '9' && k - t >= 1) {
					sb.setCharAt(i, '9');
					t += 1;
				} else {
					int nn = 0;
					if (!changed[i])
						nn++;
					if (!changed[n - 1 - i])
						nn++;
					if (k - t < nn) {
						if (k - t == 1 && n % 2 == 1)
							sb.setCharAt((n - 1) / 2, '9');
						break;
					}
					if (ch != '9') {
						sb.setCharAt(i, '9');
						sb.setCharAt(n - 1 - i, '9');
						t += nn;
					}
				}
			}
			System.out.println(sb.toString());
		}
		in.close();
	}
}
