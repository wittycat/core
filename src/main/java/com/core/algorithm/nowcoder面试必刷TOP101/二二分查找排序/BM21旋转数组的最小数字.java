package com.core.algorithm.nowcoder面试必刷TOP101.二二分查找排序;

/**
 * Created by chenxun.
 * Date: 2022/5/13 10:24 PM
 * Description:
 * <p>
 * 思路：
 * <p>
 * 旋转数组将原本有序的数组分成了两部分有序的数组，因为在原始有序数组中，最小的元素一定是在首位，旋转后无序的点就是最小的数字。
 * 我们可以将旋转前的前半段命名为A，旋转后的前半段命名为B，旋转数组即将AB变成了BA，我们想知道最小的元素到底在哪里。
 * 因为A部分和B部分都是各自有序的，所以我们还是想用分治来试试，每次比较中间值，确认目标值（最小元素）所在的区间。
 * <p>
 * 具体做法：
 * step 1：双指针指向旋转后数组的首尾，作为区间端点。
 * step 2：若是区间中点值大于区间右界值，则最小的数字一定在中点右边。
 * step 3：若是区间中点值等于区间右界值，则是不容易分辨最小数字在哪半个区间，比如[1,1,1,0,1]，应该逐个缩减右界。
 * step 4：若是区间中点值小于区间右界值，则最小的数字一定在中点左边。
 * step 5：通过调整区间最后即可锁定最小值所在。
 *
 * 本地始终没太明白只能 mid和right 比较 ，为啥不能 mid和left比较
 *
 * 看了比较多的解题思路感觉好像 原数组AB ，旋转后为BA 。最小值始终在A的左端 ，只能比较A部分
 *
 * ----这个一个关于取左边的解释 不是很理解-----------------------------------------------------------------------
 * 【二分最清晰的理解】这道题的二分解法一开始也困扰了我很久，总所周知二分的逻辑非常简单，难点在边界处理。
 * 这道题我说说自己的理解， 首先二分的根本是有序，只要有序就能二分，哪怕是部分有序（这个是重点！！）
 * 我们先搞清楚题目中的数组是通过怎样的变化得来的，基本上就是等于将整个数组向右平移（想象一个圆形的环）。
 * 重点来了，不管怎么移，数组总有一半是有序的！！要么左半边完全有序，要么右半边完全有序。 那么大家可以想想，
 * 最小值在有序的那半边还是无序的那半边。答案很显然是在无序的那半边（想想数组是如何变化得来的）。那就很简单了，
 * 每一次二分都找无序的那一半，到最后剩下的就是最小值。
 *
 * class Solution:
 *     def findMin(self, nums: List[int]) -> int:
 *         left = 0
 *         right = len(nums) - 1
 *         while left < right:
 *             mid = (left+right) // 2
 *             if nums[mid] > nums[right]:   ##判断哪边是有序的
 *                 left = mid + 1  ##将范围缩小到无序的那一半，因为答案就在那一半。之所以要+1，是因为mid肯定不是最小的那个，至少nums[right]比nums[mid]更小
 *             else:
 *                 right = mid  ##这里直接取mid，因为此时mid的左边（包含）是不完全有序的那一半，mid有可能直接是最小值，所以要取mid
 *         return nums[left]
 * ---------------------------------------------------------------------------
 *
 */
public class BM21旋转数组的最小数字 {

    public static int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {//##判断哪边是有序的
                left = mid + 1;
            } else if (array[mid] == array[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return array[left];
    }

    public static void main(String[] args) {
        int[] data = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(data));
    }


}