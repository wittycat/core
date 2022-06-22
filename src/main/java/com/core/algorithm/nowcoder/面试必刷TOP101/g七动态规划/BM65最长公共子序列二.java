package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/6/9 9:22 PM
 * Description:
 * https://www.bilibili.com/video/BV1FF411g79A?spm_id_from=333.337.search-card.all.click&vd_source=a30bba17223939a1bea53d90c11ab6f3
 */
public class BM65最长公共子序列二 {

    public static String LCS (String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (length1 > 0 && length2 > 0) {
            if (s1.charAt(length1-1) == s2.charAt(length2-1)) {
                sb.append(s1.charAt(length1-1));
                length1--;
                length2--;
            } else {
                if (dp[length1 - 1][length2] > dp[length1][length2 - 1]) {
                    length1--;
                } else {
                    length2--;
                }
            }
        }
        if(sb.length()==0){
            return "-1";
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(LCS("1A2C3D4B56","B1D23A456A"));
    }
}