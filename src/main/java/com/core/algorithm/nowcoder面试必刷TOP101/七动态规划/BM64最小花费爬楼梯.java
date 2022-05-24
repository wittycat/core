package com.core.algorithm.nowcoder面试必刷TOP101.七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/23 11:40 PM
 * Description:
 */
public class BM64最小花费爬楼梯 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public static int minCostClimbingStairs (int[] cost) {
        int[] free = new int[cost.length+1];//计算最后一个 大于数组长度
        //你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。 其实从index=2开始计算
        for (int i = 2; i <=cost.length ; i++) {
            free[i]=Math.min(free[i-1]+cost[i-1],free[i-2]+cost[i-2]);
        }
        return free[cost.length];
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        System.out.println(minCostClimbingStairs(a));
    }
}