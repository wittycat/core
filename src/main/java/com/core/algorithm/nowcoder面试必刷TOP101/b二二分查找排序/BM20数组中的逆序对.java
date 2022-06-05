package com.core.algorithm.nowcoder面试必刷TOP101.b二二分查找排序;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/14 8:19 PM
 * Description:
 */
public class BM20数组中的逆序对 {
    Integer count = 0;
    public int InversePairs(int [] array) {
        //分

//        splitArr(array)
        //合

        return 0;
    }

    private int[] splitArr(int[] array) {
        if(array.length<=1){
            return array;
        }

        int start=0;
        int end=array.length-1;
        int mid = (end-start)/2;

        int[] left= Arrays.copyOf(array,mid-start);
        int[] right= Arrays.copyOf(array,end-mid);
        int[] leftItem = splitArr(left);
        int[] rightItem = splitArr(right);

        int[] newArr =  merge(leftItem,rightItem);

        return newArr;
    }

    private int[] merge(int[] leftItem, int[] rightItem) {
        int[] arr = new int[leftItem.length + rightItem.length];
        int i = 0;
        int j = 0;

        while (i < leftItem.length || j < rightItem.length) {
            if (leftItem[i] > rightItem[j]) {
                count++;
                i++;
            } else {
                j++;
            }
        }
        return new int[0];
    }
}