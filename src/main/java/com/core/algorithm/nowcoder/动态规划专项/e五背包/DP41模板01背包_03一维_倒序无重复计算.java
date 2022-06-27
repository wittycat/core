package com.core.algorithm.nowcoder.动态规划专项.e五背包;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/22 2:26 PM
 * Description:
 */
public class DP41模板01背包_03一维_倒序无重复计算 {

    /**
     * 3 5
     * 2 10
     * 4 5
     * 1 4
     * 3 5 2 10 4 5 1 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        //dp[i][j] 前i个物品能放到j体积下的最大价值
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            System.out.println("===========" + i + "==========");
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                System.out.println(Arrays.toString(dp));
            }
        }
        System.out.println(dp[V]);

    }
}