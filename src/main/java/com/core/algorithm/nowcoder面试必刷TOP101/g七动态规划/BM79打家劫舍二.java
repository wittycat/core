package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/10 7:41 PM
 * Description:
 */
public class BM79打家劫舍二 {
    public static int rob (int[] nums) {
        int i1 = getI(Arrays.copyOfRange(nums,0,nums.length-1));
        int i2 = getI(Arrays.copyOfRange(nums,1,nums.length));
        return Math.max(i1,i2);
    }

    private static int getI(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[] a = {19,43,94,4,34,33,91,75,38,79};
        System.out.println(rob(a));

    }
}