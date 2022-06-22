package com.core.algorithm.nowcoder.面试必刷TOP101.k十一模拟;

/**
 * Created by chenxun.
 * Date: 2022/6/7 3:01 PM
 * Description:
 */
public class BM99顺时针旋转矩阵 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        //发现规律 行转变成列的关系
        int[][] newArr=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                newArr[j][n-1-i]=mat[i][j];
            }
        }
        return newArr;
    }
}