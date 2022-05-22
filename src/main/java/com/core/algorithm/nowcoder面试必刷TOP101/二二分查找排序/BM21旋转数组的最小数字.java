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
 */
public class BM21旋转数组的最小数字 {
    public static int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
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