package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/11 12:39 PM
 * Description:
 */
public class BM82买卖股票的最好时机三 {
    public int maxProfit (int[] prices) {
        //dp[i][0] 第i天不买不卖 值为截止的收益
        //dp[i][1] 第i天买1次   值为截止的收益
        //dp[i][2] 第i天买1次 卖1次   值为截止的收益
        //dp[i][3] 第i天买2次 卖1次   值为截止的收益
        //dp[i][4] 第i天买2次 卖2次   值为截止的收益
        int len = prices.length;
        //定义
        int[][] dp = new int[len][5];
        Arrays.fill(dp[0], -10000);//？？？？？？为啥要初始化-10000 不懂  好像买卖可以抵消算的是绝对值
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            //状态方程转移
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        int max = Math.max(dp[len - 1][2], dp[len - 1][4]);
        return max>0?max:0;
    }
}