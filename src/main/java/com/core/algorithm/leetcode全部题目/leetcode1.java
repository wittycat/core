package com.core.algorithm.leetcode全部题目;

import java.util.HashMap;

/**
 * Created by chenxun.
 * Date: 2020/6/6 下午7:00
 * Description:
 *
 */
public  class leetcode1 {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                Integer integer = map.get(target - nums[i]);
                int[] ints = {i, integer};
                return ints;
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums,target));
    }
}