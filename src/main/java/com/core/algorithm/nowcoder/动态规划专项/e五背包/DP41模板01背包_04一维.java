package com.core.algorithm.nowcoder.动态规划专项.e五背包;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/22 2:26 PM
 * Description:
 */
public class DP41模板01背包_04一维 {

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

        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[V]);


        int[] dp2 = new int[V + 1];
        for (int j = 0; j <= V; j++) {
            if (j == 0) {
                dp2[j] = 0;
            } else {
                dp2[j] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp2[j] = Math.max(dp2[j], dp2[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp2[V] > 0 ? dp2[V] : 0);
    }
}