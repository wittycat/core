package com.core.algorithm.leetcode全部题目;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2020/6/6 下午7:00
 * Description:
 */
public  class Solution239 {
    /**
     * 双指针
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int index1 = 0;
        int index2 = k ;
        ArrayList<Integer> maxs = new ArrayList<>();
        while (index2 <= (nums.length)) {
            int[] temp = Arrays.copyOfRange(nums, index1, index2);
            Arrays.sort(temp);
            maxs.add(temp[temp.length - 1]);
            index1++;
            index2++;
        }
        int[] r = new int[maxs.size()];
        Object[] objects = maxs.toArray();
        for (int i = 0; i < objects.length; i++) {
            r[i] = (int) objects[i];
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a ={1,3,-1,-3,5,3,6,7};
        int b =3;
        int[] ints = maxSlidingWindow(a, b);
        Arrays.stream(ints).forEach(s-> System.out.println(s));
    }
}