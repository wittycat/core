package com.core.algorithm.leetcode全部题目;

import java.util.PriorityQueue;

/**
 * Created by chenxun.
 * Date: 2020/6/6 下午7:00
 * Description:
 *
 * Java中的PriorityQueue实现了数据结构堆，通过指定comparator字段来表示小顶堆或大顶堆，默认为null，表示自然序（natural ordering）。
 *
 */
public  class leetcode215 {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            integerPriorityQueue.add(nums[i]);
            if (integerPriorityQueue.size() > k) {
                integerPriorityQueue.poll();
            }
        }
        return integerPriorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] count = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(count,4));
    }
}