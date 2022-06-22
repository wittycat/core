package com.core.algorithm.nowcoder.面试必刷TOP101.f六递归回溯;

/**
 * Created by chenxun.
 * Date: 2022/5/31 5:13 PM
 * Description:
 */
public class BM57岛屿数量 {
    public int solve (char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                char c = grid[i][j];
                if(c=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        char c = grid[i][j];
        if (c == '1') {
            grid[i][j] = '0';
        }

        if (j + 1 < n && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
        if (j - 1 > -1 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (i + 1 < m && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (i - 1 > -1 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
    }

}