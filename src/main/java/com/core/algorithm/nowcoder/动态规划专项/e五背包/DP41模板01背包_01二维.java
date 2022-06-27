package com.core.algorithm.nowcoder.动态规划专项.e五背包;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/22 2:26 PM
 * Description:
 */
public class DP41模板01背包_01二维 {

    /**
     * 3 5
     * 2 10
     * 4 5
     * 1 4
     *
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
        int[][] dp = new int[n + 1][V + 1];
        for (int i = 1; i < V + 1; i++) {
            if (i > v[1]) {
                dp[1][i] = w[1];
            } else {
                dp[1][i] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                //默认不放i物品，那么价值就等于j体积下i-1的价值
                dp[i][j] = dp[i - 1][j];
                //如果当前空间大于i物品的体积，那么和不放i物品的价值比较，取能放下的最大价值
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[n][V]);


        int[][] dp2 = new int[n + 1][V + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= V; j++) {
                // 将dp2[i][0]置为0， 将其余的置为负数极限
                // 这是为了恰好装满的条件，
                // 这样可以保证，如果到容量为v时不是正好装满，就一定时Integer.MIN_VALUE + maxVal，远远小于0
                // 保证恰好装满是从dp2[i][0]转移过来的
                if (j == 0) {
                    dp2[i][j] = 0;//体积为0，不用装也算满 价值就为0
                } else {
                    dp2[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                dp2[i][j] = dp2[i - 1][j];
                if (j >= v[i]) {
                    dp2[i][j] = Math.max(dp2[i - 1][j], dp2[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp2[n][V] > 0 ? dp2[n][V] : 0);
    }
}