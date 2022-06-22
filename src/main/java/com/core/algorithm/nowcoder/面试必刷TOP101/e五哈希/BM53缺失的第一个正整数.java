package com.core.algorithm.nowcoder.面试必刷TOP101.e五哈希;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/26 3:18 PM
 * Description:
 */
public class BM53缺失的第一个正整数 {
    public static int minNumberDisappeared (int[] nums) {
        Arrays.sort(nums);
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0){
                if((nums[i]-t)>1){
                    return t+1;
                }
                t = nums[i];
            }
        }
        return t+1;
    }

    public static void main(String[] args) {
        int[] a = {-1,2,3,4};
        System.out.println(minNumberDisappeared(a));
    }

}