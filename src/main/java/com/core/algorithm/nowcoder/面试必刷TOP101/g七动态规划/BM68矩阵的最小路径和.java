package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/9 11:41 PM
 * Description:
 */
public class BM68矩阵的最小路径和 {
    public static int minPathSum (int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        //填充第一行
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        //填充第一列
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        Arrays.stream(dp).forEach(item->System.out.println(Arrays.toString(item)));

        return dp[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{1,2,3},{1,2,3}};
        System.out.println(minPathSum(matrix));
    }
}