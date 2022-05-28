package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/24 9:43 PM
 * Description:
 */
public class BM67不同路径的数目一 {
    public int uniquePaths (int m, int n) {
        if(m==1||n==1){
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
}