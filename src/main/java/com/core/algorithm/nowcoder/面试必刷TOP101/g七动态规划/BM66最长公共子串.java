package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/6/9 11:11 PM
 * Description:
 */
public class BM66最长公共子串 {

    public static String LCS (String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int maxLength=0;
        int maxLengthLast=0;

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j]>maxLength){
                        maxLength=dp[i][j];
                        maxLengthLast=i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(maxLength);
        System.out.println(maxLengthLast);
        return str1.substring(maxLengthLast-maxLength,maxLengthLast);
    }

    public static void main(String[] args) {
        System.out.println(LCS("abcdefg","ab1cdefgabc1defg"));
    }
}