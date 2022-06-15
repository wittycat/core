package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/15 8:03 PM
 * Description:
 * https://www.bilibili.com/video/BV1th411o7Rg?spm_id_from=333.337.search-card.all.click&vd_source=a30bba17223939a1bea53d90c11ab6f3
 *
 */
public class BM76正则表达式匹配 {

    public static boolean match (String str, String pattern) {
        String aa = " " + str;
        String bb = " " + pattern;
        boolean[][] dp = new boolean[aa.length()][bb.length()];
        dp[0][0] = true;
        for (int i = 1; i < aa.length(); i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i < bb.length(); i++) {
            dp[0][i] = " ".equals(bb.charAt(i)) || (bb.charAt(i) == '*' && i - 2 > -1 && dp[0][i - 2]);
        }


        for (int i = 1; i < aa.length(); i++) {
            for (int j = 1; j < bb.length(); j++) {
                if (bb.charAt(j) != '*') {
                    if(aa.charAt(i) == bb.charAt(j) || bb.charAt(j) == '.'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (j - 2 > -1) {
                        //默认 取j减2的状态
                        dp[i][j] = dp[i][j - 2];
                        //这2个条件满足 就使用dp[i - 1][j] ，
                        if (aa.charAt(i) == bb.charAt(j - 1) || bb.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        }
                    }
                }
            }
        }
        Arrays.stream(dp).forEach(item -> {
            System.out.println(Arrays.toString(item));
        });
        return dp[aa.length() - 1][bb.length() - 1];
    }

    /**
     * [true, false, true, false]
     * [false, true, true, true]
     * [false, false, true, true]
     * [false, false, true, true]
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(match("aaa","a*a"));
    }
}