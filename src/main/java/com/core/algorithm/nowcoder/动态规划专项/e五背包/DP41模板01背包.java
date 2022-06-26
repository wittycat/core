package com.core.algorithm.nowcoder.动态规划专项.e五背包;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/22 2:26 PM
 * Description:
 */
public class DP41模板01背包 {

    public static void main (String[] args) {
        int n = 3;
        int V = 5;
        //物体体积
        int[] v = {2, 4, 1};
        //物体价值
        int[] w = {10, 5, 4};

        //用体积数作为下标, 可以找到体积数对应的价值
//        int[] dp1 = new int[V+1];
        int[] dp2 = new int[V+1];
        Arrays.fill(dp2, Integer.MIN_VALUE); //用来区分放了东西价值为零, 还是没放东西
        dp2[0] = 0;
        //物品遍历
        for (int i = 0; i < n; i++) {
            for (int j = V; j >= v[i]; j--){
//                dp1[j] = Math.max(dp1[j], dp1[j-v[i]]+w[i]);
                dp2[j] = Math.max(dp2[j], dp2[j-v[i]]+w[i]);
            }

        }
//        System.out.println(dp1[V]);
        //dp2[V] < 0表示不能满足正好放满的条件
        System.out.println(dp2[V] < 0 ? 0 : dp2[V]);

    }
}