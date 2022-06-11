package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/10 11:29 AM
 * Description:
 */
public class BM71最长上升子序列一 {
    public static int LIS (int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int dp[] = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] a = {6,3,1,5,2,3,7};
        System.out.println(LIS(a));
    }
}