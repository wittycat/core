package com.core.algorithm.nowcoder面试必刷TOP101.七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/27 12:21 PM
 * Description:
 */
public class BM80买卖股票的最好时机一 {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public static int maxProfit (int[] prices) {
        //方式1
        int[] dp = new int[prices.length+1];
        int lowPrice = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length ; i++) {
            dp[i]= prices[i]- lowPrice;
            max = Math.max(max,dp[i]);
            lowPrice = Math.min(prices[i],lowPrice);
        }
        //方式1
//        int max = getMax(prices);
        return max;
    }

    private static int getMax(int[] prices) {
        int lowPrice = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length ; i++) {
            int get= prices[i]- lowPrice;
            max = Math.max(max,get);
            lowPrice = Math.min(prices[i],lowPrice);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,2,1,3,5,1};
        System.out.println(maxProfit(a));
    }
}