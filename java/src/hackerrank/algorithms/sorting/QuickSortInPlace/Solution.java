package hackerrank.algorithms.sorting.QuickSortInPlace;

import java.util.*;

public class Solution {
    private static int partition(int[] arr, int s, int e) {
        while(s<e) {
            while(s<e-1 && arr[s] <= arr[e])
                s++;
            int s1 = s+1;
            while(s1<e&&arr[s1] >= arr[e])
                s1++;
            if (s1 <e) {
                int temp = arr[s];
                arr[s] = arr[s1];
                arr[s1] = temp;
            } else {
                break;
            }
        }
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        return s;
    }
    private static void sort(int[] arr,int s,int e) {
        if (s < e) {
			int q = partition(arr, s, e);
			for (int i=0;i<arr.length;i++)
			    System.out.print(arr[i]+" ");
			System.out.println(q);
			sort(arr, s, q - 1);
			sort(arr, q + 1, e);
		}
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	/*
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++)
            nums[i] = scanner.nextInt();
            */
    	int[] nums = new int[]{9,8,6,7,3,5,4,1,2};
        sort(nums,0,nums.length-1);
        //scanner.close();
    }
}