package hackerrank.algorithms.implementation.nondivisiblesubset;

import java.io.*;
import java.util.*;

public class Solution {
    public static void compute(int[] a, int k) {
        int[] c = new int[k];
        for (int i = 0; i < a.length; i++) {
            ++c[a[i] % k];
        }
        int count = 0;
        if (c[0] == 1)
            ++count;
        for (int i = 1;  i <= k - i; i++) {
            count += Math.max(c[i], c[k - i]);
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("test.txt"));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        compute(a, k);
    }
}