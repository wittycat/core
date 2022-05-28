package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/27 2:53 PM
 * Description:
 */
public class BM81买卖股票的最好时机二 {
    public static int maxProfit (int[] prices) {
        int[] dp = new int[prices.length + 1];
        int low = prices[0];
        for (int i = 2; i < prices.length; i++) {
            if (low > prices[i]) {
                low = prices[i];
                continue;
            }
            if (prices[i] - low >= dp[i - 1]) {
                low = Math.min(low, prices[i]);
                dp[i] = prices[i] - low;
                dp[i - 1] = 0;
            } else {
                dp[i] = 0;
                low = prices[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum = sum + dp[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1,83,74,26,63,37,25,63,28};
        System.out.println(maxProfit(a));
    }
}