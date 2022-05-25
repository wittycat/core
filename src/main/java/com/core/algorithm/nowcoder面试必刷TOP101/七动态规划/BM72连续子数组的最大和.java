package com.core.algorithm.nowcoder面试必刷TOP101.七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/24 9:46 PM
 * Description:
 *
 * 贪心思想属于动态规划思想中的一种，
 * 其基本原理是找出整体当中给的每个局部子结构的最优解，
 * 并且最终将所有的这些局部最优解结合起来形成整体上的一个最优解。
 */
public class BM72连续子数组的最大和 {
    public static int FindGreatestSumOfSubArray(int[] array) {

        int sum = 0;
//        for (int i = 0; i < array.length; i++) {
//            sum+=array[i];
//        }
//
//        int i = 0;
//        int j = array.length-1;
//        while (i<j){
//            int temp = sum;
//            if(array[i]>array[j]){
//                temp = temp-array[j];
//                j--;
//            }else {
//                temp = temp-array[i];
//                i++;
//            }
//            sum = Math.max(sum,temp);
//        }
        return sum;
    }

    public static void main(String[] args) {
       int[] a = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(a));
    }
}