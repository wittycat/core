package com.core.algorithm.nowcoder.面试必刷TOP101.k十一模拟;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/7 2:44 PM
 * Description:
 */
public class BM97旋转数组 {
    public static int[] solve (int n, int m, int[] a) {
        int i = m % n;

        reverse(a, 0, n - 1);
        reverse(a, 0, i - 1);
        reverse(a, i, n - 1);
        return a;
    }

    private static void reverse(int[] arr, int i, int j) {
        int start = i;
        int end = j;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        int[] solve = solve(6, 7, a);
        System.out.println(Arrays.toString(solve));
    }
}