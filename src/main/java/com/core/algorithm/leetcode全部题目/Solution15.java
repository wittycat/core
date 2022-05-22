package com.core.algorithm.leetcode全部题目;

import java.util.*;

/**
 * Created by chenxun.
 * Date: 2020/6/6 下午7:00
 * Description:
 *
 */
public  class Solution15 {

    /**
     * 两次遍历加hash
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        Set<List<Integer>> set = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (i != j) {
                    map.remove(i);
                    map.remove(j);
                    int three = 0 - nums[i] - nums[j];
                    if (map.containsValue(three)) {
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], three);
                        integers.sort(Comparator.naturalOrder());
                        set.add(integers);
                    }
                    map.put(i, nums[i]);
                    map.put(j, nums[j]);

                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}