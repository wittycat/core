package com.core.algorithm.kaoshi202205.二二分查找排序;

/**
 * Created by chenxun.
 * Date: 2022/5/13 10:31 PM
 * Description:
 */
public class BM19寻找峰值 {

    public static void main(String[] args) {
        int peakElement = findPeakElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(peakElement);
    }

    public static int findPeakElement (int[] nums) {
        if(nums==null||nums.length==1){
            return 0;
        }
        if(nums==null||nums.length==2){
            return nums[0]>nums[1]?0:1;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(i+2<nums.length ){
                int l = nums[i];
                int m = nums[i+1];
                int r = nums[i+2];
                if(l>m){
                    return i;
                }
                if(l< m && m>r){
                    return i+1;
                }
            }else if (i+1<nums.length){
                int l = nums[i];
                int m = nums[i+1];
                return l< m?i+1:i;
            }
        }
        return 0;
    }
}