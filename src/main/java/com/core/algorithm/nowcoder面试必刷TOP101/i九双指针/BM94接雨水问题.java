package com.core.algorithm.nowcoder面试必刷TOP101.i九双指针;

/**
 * Created by chenxun.
 * Date: 2022/5/23 9:29 PM
 * Description:
 */
public class BM94接雨水问题 {

    public static long maxWater (int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        /**
         *
         * 传统思想没求出来，写的巨复杂
         *
         * 参考：https://www.bilibili.com/video/BV1D34y1Y7xp?spm_id_from=333.337.search-card.all.click
         *
         * 1.每根柱子左右的最大值(提前动态规划写好)
         * 2.每根柱子与左右最小值的值， 最小值大于当前柱子才能接雨水
         * 3.累加求和
         *
         */

        int[] arrLeft=new int[arr.length];
        arrLeft[0]=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            arrLeft[i]=Math.max(arrLeft[i-1],arr[i]);
        }

        int[] arrRight=new int[arr.length];
        arrRight[arr.length-1]=arr[arr.length-1];
        for (int i = arr.length-2; i >-1 ; i--) {
            arrRight[i]=Math.max(arrRight[i+1],arr[i]);
        }

        int sum = 0 ;
        for (int i = 1; i <arr.length-1 ; i++) {
            int v = arr[i];
            int min = Math.min(arrLeft[i - 1], arrRight[i + 1]);
            if(min>v){
                sum=sum+min-v;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {3,1,0,1,1,4};
        long l = maxWater(a);
        System.out.println(l);
    }

}