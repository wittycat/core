package com.core.algorithm.leetcode全部题目;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/23 5:45 PM
 * Description:
 */
public class leetcode179最大数 {

        public String largestNumber(int[] nums) {
            String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
            Arrays.sort(arr, (o1, o2) -> -(o1 + o2).compareTo(o2 + o1));
            String res = String.join("", arr);
            return res.startsWith("0") ? "0" : res;
        }
}