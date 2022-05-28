package com.core.algorithm.nowcoder面试必刷TOP101.b二二分查找排序;

/**
 * Created by chenxun.
 * Date: 2022/5/13 7:07 PM
 * Description:
 */
public class BM17二分查找I {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @return int整型
     */

    public static void main(String[] args) {
        search(new  int[]{0,1},1);
    }

    public static int search (int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int l=0;
        int r=nums.length-1;

        while (l<=r){
            int m = (l+r)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[m]>target){
                r=m-1;
            }else {
                l=m+1;
            }
        }
        return -1;
    }
}