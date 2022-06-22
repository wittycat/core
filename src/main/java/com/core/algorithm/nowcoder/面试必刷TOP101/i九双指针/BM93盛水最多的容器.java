package com.core.algorithm.nowcoder.面试必刷TOP101.i九双指针;

/**
 * Created by chenxun.
 * Date: 2022/5/23 8:29 PM
 * Description:
 */
public class BM93盛水最多的容器 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param height int整型一维数组
     * @return int整型
     */
    public static int maxArea (int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return 0;
        }

        int i = 0;
        int j = height.length - 1;
        int v = 0;
        while (i < j) {
            v = Math.max((Math.min(height[i], height[j])) * (j - i), v);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return v;
    }


    public static void main(String[] args) {
        int[] a = {6,4,3,1,4,6,99,62,1,2,6};//62
        System.out.println(maxArea(a));
    }

}