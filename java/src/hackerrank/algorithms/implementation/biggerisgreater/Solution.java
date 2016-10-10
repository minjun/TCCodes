package hackerrank.algorithms.implementation.biggerisgreater;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// 0 1 2 2 5 5 3 3 2 2 0 -> 0 1 3 5 5 3 2 0
public class Solution {
	private static String nextWord(char[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		if (i == 0)
			return "no answer";
		int j = arr.length - 1;
		while (arr[j] <= arr[i - 1]) {
			j--;
		}
		char temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;

		j = arr.length - 1;
		while (j > i) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return new String(arr);
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			String w = scanner.next();
			System.out.println(nextWord(w.toCharArray()));
		}
		scanner.close();
	}
}