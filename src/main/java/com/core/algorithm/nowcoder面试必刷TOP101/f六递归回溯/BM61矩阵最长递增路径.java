package com.core.algorithm.nowcoder面试必刷TOP101.f六递归回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2022/6/14 6:23 PM
 * Description:
 */
public class BM61矩阵最长递增路径 {


    static int max = 0;
    public static int solve (int[][] matrix) {
        int[][] visit = new int[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList();

        int leni = matrix.length;
        int leny = matrix[0].length;
        for (int i = 0; i < leni; i++) {
            for (int j = 0; j < leny; j++) {
                res.add(matrix[i][j]);
                visit[i][j] = 1;
                dfs(matrix, visit, res, i, j);
                res.remove(res.size() - 1);
                visit[i][j] = 0;
            }
        }
        return max;
    }

    private static void dfs(int[][] matrix, int[][] visit, List<Integer> res, int i, int j) {
        int leni = matrix.length;
        int leny = matrix[0].length;
        int cur = matrix[i][j];

        max = Math.max(res.size(), max);
        if(res.size()==6) {
            System.out.println(res);
        }

        if (j + 1 < leny && cur < matrix[i][j + 1] && visit[i][j + 1] == 0) {
            visit[i][j + 1] = 1;
            res.add(matrix[i][j + 1]);
            dfs(matrix, visit, res, i, j + 1);
            visit[i][j + 1] = 0;
            res.remove(res.size() - 1);
        }
        if (j - 1 > 0 && cur < matrix[i][j - 1] && visit[i][j - 1] == 0) {
            visit[i][j - 1] = 1;
            res.add(matrix[i][j - 1]);
            dfs(matrix, visit, res, i, j - 1);
            visit[i][j - 1] = 0;
            res.remove(res.size() - 1);
        }
        if (i + 1 < leni && cur < matrix[i + 1][j] && visit[i + 1][j] == 0) {
            visit[i + 1][j] = 1;
            res.add(matrix[i + 1][j]);
            dfs(matrix, visit, res, i + 1, j);
            visit[i + 1][j] = 0;
            res.remove(res.size() - 1);
        }
        if (i - 1 > 0 && cur < matrix[i - 1][j] && visit[i - 1][j] == 0) {
            visit[i - 1][j] = 1;
            res.add(matrix[i - 1][j]);
            dfs(matrix, visit, res, i - 1, j);
            visit[i - 1][j] = 0;
            res.remove(res.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] a = {
                {4, 3, 3, 6, 6, 3, 2, 1, 0, 7},
                {1, 8, 2, 8, 5, 9, 2, 8, 3, 1},
                {8, 0, 9, 2, 4, 3, 2, 4, 3, 7},
                {1, 2, 2, 6, 3, 0, 3, 9, 7, 0},
                {7, 4, 3, 8, 8, 3, 2, 4, 6, 8},
                {2, 8, 9, 2, 9, 3, 0, 8, 7, 8},
                {8, 9, 9, 4, 6, 3, 3, 4, 9, 6},
                {2, 8, 3, 8, 1, 3, 7, 3, 0, 7},
                {2, 1, 1, 6, 4, 1, 0, 8, 1, 6},
                {4, 1, 3, 6, 3, 4, 4, 4, 0, 3}};
        System.out.println(solve(a));
    }
}