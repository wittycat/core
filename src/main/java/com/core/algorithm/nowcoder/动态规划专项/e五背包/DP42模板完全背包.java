package com.core.algorithm.nowcoder.动态规划专项.e五背包;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/27 8:18 PM
 * Description:
 */
public class DP42模板完全背包 {
    /**
     * 3 8
     * 3 10
     * 9 1
     * 10 1
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int V = scanner.nextInt();
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        int[] dp = new int[V + 1];

        int[] dp2 = new int[V + 1];
        Arrays.fill(dp2, Integer.MIN_VALUE);
        dp2[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if (j >= v[i]) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                    dp2[j] = Math.max(dp2[j], dp2[j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[V]);
        System.out.println(dp2[V] > 0 ? dp2[V] : 0);
    }
}