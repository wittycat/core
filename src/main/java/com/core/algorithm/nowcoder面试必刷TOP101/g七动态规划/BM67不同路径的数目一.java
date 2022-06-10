package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/24 9:43 PM
 * Description:
 */
public class BM67不同路径的数目一 {
    public static int uniquePaths (int m, int n) {
        int[][] dp = new int[m][n];
        //填充第一行
        dp[0][0] = 1;
        if (m > 1) {
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        //填充第一列
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < m && m > 1; i++) {
            for (int j = 1; j < n && n > 1; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2,7));
    }

//    public int uniquePaths2 (int m, int n) {
//        if(m==1||n==1){
//            return 1;
//        }
//        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
//    }
}