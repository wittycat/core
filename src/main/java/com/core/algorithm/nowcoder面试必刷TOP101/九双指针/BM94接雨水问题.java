package com.core.algorithm.nowcoder面试必刷TOP101.九双指针;

/**
 * Created by chenxun.
 * Date: 2022/5/23 9:29 PM
 * Description:
 */
public class BM94接雨水问题 {

    public static long maxWater (int[] arr) {
        //排除空数组
        if(arr.length == 0)
            return 0;
        long res = 0;
        //左右双指针
        int left = 0;
        int right = arr.length - 1;
        //中间区域的边界高度
        int maxL = 0;
        int maxR = 0;
        //直到左右指针相遇
        while(left < right){
            //每次维护往中间的最大边界
            maxL = Math.max(maxL, arr[left]);
            maxR = Math.max(maxR, arr[right]);
            //较短的边界确定该格子的水量
            if(maxR > maxL)
                res += maxL - arr[left++];
            else
                res += maxR - arr[right--];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {3,1,1,1,1,1};
        maxWater(a);
    }

}