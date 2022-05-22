package com.core.algorithm.nowcoder面试必刷TOP101.二二分查找排序;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/13 10:24 PM
 * Description:
 */
public class BM21旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        Arrays.sort(array);
        return array[0];
        //方法2: 二分法查找
    }
}