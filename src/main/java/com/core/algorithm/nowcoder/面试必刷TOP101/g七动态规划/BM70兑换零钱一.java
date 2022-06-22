package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/10 6:16 PM
 * Description:
 */
public class BM70兑换零钱一 {
    public static int minMoney (int[] arr, int aim) {

        /**
         * 动态三步
         *  定义状态
         *  初始化状态
         *  状态转移方程
         */
        //dp[i] 代表金额为i所需要的最少面值
        int[] dp = new int[aim+1];
        //因为下面要取较小张数 所以这块只能设置较大的
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0]=0;
        for (int i = 0; i <=aim ; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if(arr[j]<=i){
                    dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        //dp[aim]>aim 大于全为1元的张数 ，那就是没设置 不存在
        return dp[aim]>aim?-1:dp[aim];
    }

    public static void main(String[] args) {
        int[] arr={5,2,3};
        System.out.println(minMoney(arr,20));
    }
}