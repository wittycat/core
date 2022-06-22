package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/10 7:41 PM
 * Description:
 */
public class BM78打家劫舍一 {
    public static int rob (int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i-1], dp[i - 1]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(rob(a));

    }
}