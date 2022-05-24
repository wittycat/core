package com.core.algorithm.nowcoder面试必刷TOP101.七动态规划;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/24 11:39 AM
 * Description:
 */
public class BM69把数字翻译成字符串 {
    /**
     *
     * 动态规划
     *
     * 动态规划算法的基本思想是：将待求解的问题分解成若干个相互联系的子问题，先求解子问题，然后从这些子问题的解得到原问题的解；
     * 对于重复出现的子问题，只在第一次遇到的时候对它进行求解，并把答案保存起来，让以后再次遇到时直接引用答案，不必重新求解。
     * 动态规划算法将问题的解决方案视为一系列决策的结果
     *
     *
     * 对于普通数组1-9，译码方式只有一种，但是对于11-19，21-26，
     * 译码方式有可选择的两种方案，因此我们使用动态规划将两种方案累计。
     */

    public static int solve (String nums) {
        // write code here
        if(nums.equals("0")){
            return 0;
        }
        //排除只有一种可能的10 和 20
        if(nums.equals("10") || nums.equals("20")){
            return 1;
        }
        for(int i = 1; i < nums.length(); i++){
            if(nums.charAt(i) == '0')
                if(nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2')
                    return 0;
        }
        int[] dp = new int[nums.length()+1];
        Arrays.fill(dp, 1);

        for (int i = 2; i <=nums.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nums.charAt(i-2));
            stringBuilder.append(nums.charAt(i-1));
            int i1 = Integer.parseInt(stringBuilder.toString());
            if ((i1>10&&i1<20)||(i1>20&&i1<27)) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else  {
                dp[i] = dp[i - 1];
            }
        }
        return dp[nums.length()];
    }

    /**
     * [1, 1, 1, 2, 2, 4, 4, 8, 12, 12, 24, 24, 48, 48, 48, 96, 96, 192]
     *     3  1  7  1  7  1  2  6  2   4   1     5   4   1   7   1   7
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(solve("11"));
    }
}