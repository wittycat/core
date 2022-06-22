package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/26 9:37 PM
 * Description:
 */
public class BM63跳台阶 {

    public int jumpFloor(int target) {
        int[] dp = new int[41];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <41 ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
}