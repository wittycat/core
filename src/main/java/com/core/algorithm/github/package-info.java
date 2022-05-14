package com.core.algorithm.github;

/**
 *
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E7%9B%AE%E5%BD%95.md
 *
 * 寻找左侧边界的二分搜索
 * 以下是最常见的代码形式，其中的标记是需要注意的细节：
 *
 * int left_bound(int[] nums, int target) {
 *     if (nums.length == 0) return -1;
 *     int left = 0;
 *     int right = nums.length; // 注意
 * ​
 *     while (left < right) { // 注意
 *         int mid = (left + right) / 2;
 *         if (nums[mid] == target) {
 *             right = mid;
 *         } else if (nums[mid] < target) {
 *             left = mid + 1;
 *         } else if (nums[mid] > target) {
 *             right = mid; // 注意
 *         }
 *     }
 *     return left;
 * }
 *
 */
