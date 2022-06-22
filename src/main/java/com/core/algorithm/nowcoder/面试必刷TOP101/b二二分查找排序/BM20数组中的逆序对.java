package com.core.algorithm.nowcoder.面试必刷TOP101.b二二分查找排序;

/**
 * Created by chenxun.
 * Date: 2022/5/14 8:19 PM
 * Description:
 */
public class BM20数组中的逆序对 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(a));
    }


    /**
     * 归并排序
     */
    static Integer count = 0;
    public static int InversePairs(int [] array) {
        splitArr(array,0,array.length-1);
        return count;
    }

    private   static void splitArr(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        splitArr(array, left, mid);
        splitArr(array, mid+1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] arr = new int[right - left + 1];
        int arrIndex = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                arr[arrIndex] = array[i];
                i++;
            } else {
                arr[arrIndex] = array[j];
                //理解这句  举例 「1 2 3 4」   「0 5 6 7 」，1大于0，1后面都大于0，到mid ，那么就是mid-i+1
                count = count + mid - i + 1;
                j++;
            }
            arrIndex++;
        }
        while (i <= mid) {
            arr[arrIndex] = array[i];
            i++;
            arrIndex++;
        }
        while (j <= right) {
            arr[arrIndex] = array[j];
            j++;
            arrIndex++;
        }

        for (int k = left; k <= right; k++) {
            array[k] = arr[k - left];
        }
    }

    /**
     *
     *  方式1 ：暴力破解法 ，不能跑完所有用例
     * @param array
     * @return
     */
    public static int InversePairs2(int [] array) {
        int[] count = new int[array.length];
        for (int i = array.length - 2; i > -1; i--) {
            count[i] = count[i + 1];
            int cur = array[i];
            int temp = i;
            temp++;
            while (temp < array.length) {
                if (cur > array[temp]) {
                    count[i] = count[i]+1;
                }
                temp++;
            }
        }
        return count[0];
    }


}