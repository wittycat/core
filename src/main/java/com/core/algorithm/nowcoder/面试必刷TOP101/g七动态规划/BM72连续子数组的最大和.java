package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/24 9:46 PM
 * Description:
 *
 * 贪心思想属于动态规划思想中的一种，
 * 其基本原理是找出整体当中给的每个局部子结构的最优解，
 * 并且最终将所有的这些局部最优解结合起来形成整体上的一个最优解。
 *
 * 思路：https://www.bilibili.com/video/BV1ka4y1H7ZQ?spm_id_from=333.337.search-card.all.click
 */
public class BM72连续子数组的最大和 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length+1];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(array[i]+dp[i-1],array[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {-1,-2,-3,-4,5};
        System.out.println(FindGreatestSumOfSubArray(a));
    }
}