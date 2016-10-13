package hackerrank.algorithms.dp.mandragora;

import java.io.*;
import java.util.*;

public class Solution {
    public static void getMaxEP(int[] a) {
        Arrays.sort(a);
        long[] dp = new long[a.length + 1];
        for (int i = a.length - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + a[i];
        }
        long max = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = (1 + i) * dp[i];
            if (sum > max)
                max = sum;
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Scanner scanner = new Scanner(System.in);
    	Scanner scanner = new Scanner(new File("testdata"));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            getMaxEP(a);
        }
    }
}
