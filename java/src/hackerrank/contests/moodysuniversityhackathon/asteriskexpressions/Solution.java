package hackerrank.contests.moodysuniversityhackathon.asteriskexpressions;

import java.io.*;
import java.util.*;

public class Solution {
	private static long computeExpression(Stack<Long> oper, String op) {
		if (oper.empty())
			return -1;
		long oper1 = oper.pop();
		if (oper.empty())
			return -1;
		long oper2 = oper.pop();
		if ("*".equals(op)) {
			return oper1 * oper2;
		} else {
			long result = 1;
			for (long i = 0; i < oper1; i++) {
				result *= oper2;
			}
			return result;
		}
	}

	private static long evaluateExpression(String expr) {
		Stack<Long> oper = new Stack<Long>();
		Stack<String> op = new Stack<String>();
		int i = 0;
		while (i < expr.length()) {
			char ch = expr.charAt(i);
			if (ch >= '0' && ch <= '9') {
				StringBuffer sb = new StringBuffer();
				sb.append(ch);
				while (++i < expr.length()) {
					ch = expr.charAt(i);
					if (ch >= '0' && ch <= '9') {
						sb.append(ch);
					} else {
						break;
					}
				}
				oper.push(Long.parseLong(sb.toString()));
				if (!op.empty() && ("**".equals(op.peek()))) {
					oper.push(computeExpression(oper, op.pop()));
				}
				if (i == expr.length()) {
					while (!op.empty() && "*".equals(op.peek())) {
						oper.push(computeExpression(oper, op.pop()));
					}
				}
			} else if (ch == '*') {
				StringBuffer sb = new StringBuffer();
				sb.append(ch);
				while (++i < expr.length()) {
					ch = expr.charAt(i);
					if (ch == '*') {
						sb.append(ch);
					} else {
						break;
					}
				}
				if (sb.length() > 2) {
					return -1;
				}
				op.push(sb.toString());
			}
		}
		if (!op.empty() || oper.empty())
			return -1;
		return oper.pop();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < t; i++) {
			long result = evaluateExpression(scanner.nextLine());
			if (result == -1) {
				System.out.println("Syntax Error");
			} else {
				System.out.println(result);
			}
		}
		scanner.close();
	}
}