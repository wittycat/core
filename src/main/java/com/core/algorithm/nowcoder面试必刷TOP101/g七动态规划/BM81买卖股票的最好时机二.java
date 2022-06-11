package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/27 2:53 PM
 * Description:
 */
public class BM81买卖股票的最好时机二 {
    public static int maxProfit (int[] prices) {
        //dp[i][0] 第i天不持有 值为截止的收益
        //dp[i][1] 第i天持有   值为截止的收益
        int len = prices.length;
        //定义
        int[][] dp = new int[len][2];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            //状态方程转移
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int[] a = {1,83,74,26,63,37,25,63,28};
        System.out.println(maxProfit(a));
    }
}