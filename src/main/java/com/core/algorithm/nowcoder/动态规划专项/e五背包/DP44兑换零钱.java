package com.core.algorithm.nowcoder.动态规划专项.e五背包;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/27 8:40 PM
 * Description:
 */
public class DP44兑换零钱 {

    /**
     * 3 20
     * 5 2 3
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kinds = scanner.nextInt();
        int MAX = scanner.nextInt();
        int[] currency = new int[kinds + 1];
        for (int i = 1; i <= kinds; i++) {
            currency[i] = scanner.nextInt();
        }
        int[] dp = new int[MAX + 1];
        //最大最小 一般一半即可 防止溢出
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= kinds; i++) {
            for (int j = 0; j <= MAX; j++) {
                if (j >= currency[i]) {
                    dp[j] = Math.min(dp[j], dp[j - currency[i]] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[MAX] > -1 && dp[MAX] < Integer.MAX_VALUE / 2 ? dp[MAX] : -1);
    }
}