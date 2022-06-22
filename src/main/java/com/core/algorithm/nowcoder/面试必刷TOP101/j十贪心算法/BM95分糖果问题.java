package com.core.algorithm.nowcoder.面试必刷TOP101.j十贪心算法;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/27 3:39 PM
 * Description:
 */
public class BM95分糖果问题 {
    public static int candy (int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i-1] + 1;
            }
        }

        for (int i = arr.length-1; i >0; i--) {
            if (arr[i-1] > arr[i]) {
                dp[i-1] = Math.max(dp[i-1],dp[i]+1);
            }
        }

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum = sum + dp[i];
        }
        return sum;
    };

    public static void main(String[] args) {
        int[] a = {4,4,4};
        System.out.println(candy(a));
    }

}