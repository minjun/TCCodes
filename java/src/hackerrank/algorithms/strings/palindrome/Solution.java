package hackerrank.algorithms.strings.palindrome;

import java.util.*;

public class Solution {
	private static boolean isPalindrome(String a) {
		int i = 0;
		for (i = 0; i < a.length() / 2; i++) {
			if (a.charAt(i) != a.charAt(a.length() - 1 - i))
				break;
		}
		return i == a.length() / 2;
	}

	private static void buildPalindrome(String a, String b) {
		String result = null;
		for (int i = a.length(); i > 0; i--)
			for (int j = 0; j < a.length() + 1 - i; j++)
				for (int m = b.length(); m > 0; m--)
					for (int n = 0; n < b.length() + 1 - m; n++) {
						String sa = a.substring(j, j + i);
						String sb = b.substring(n, n + m);
						if (isPalindrome(sa + sb) && (result == null || ((sa + sb).length() >= result.length() && (sa + sb).compareTo(result) < 0))) {
							result = sa + sb;
						}
						if (isPalindrome(sb + sa) && (result == null || ((sb + sa).length() >= result.length() && (sb + sa).compareTo(result) < 0))) {
							result = sb + sa;
						}
					}
		if (result == null)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String[] ss = new String[2 * n];
		for (int i = 0; i < n; i++) {
			ss[2 * i] = scanner.nextLine().trim();
			ss[2 * i + 1] = scanner.nextLine().trim();

		}
		for (int i = 0; i < n; i++) {
			buildPalindrome(ss[2 * i], ss[2 * i + 1]);
		}
		scanner.close();
	}
}