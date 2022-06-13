package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/6/13 7:11 PM
 * Description:
 */
public class BM75编辑距离一 {
    public int editDistance (String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] ints = new int[len1+1][len2+1];
        for (int i = 1; i < len1+1; i++) {
            ints[i][0]=i;
        }
        for (int i = 1; i < len2+1; i++) {
            ints[0][i]=i;
        }
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j <len2+1 ; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    ints[i][j]=ints[i-1][j-1];
                }else {
                    ints[i][j]=Math.min(Math.min(ints[i-1][j],ints[i][j-1]),ints[i-1][j-1])+1;
                }
            }
        }


        return ints[len1][len2];
    }
}