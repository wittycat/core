package com.core.algorithm.nowcoder.面试必刷TOP101.d四堆栈队列;

/**
 * Created by chenxun.
 * Date: 2022/6/5 1:48 PM
 * Description:
 */
public class BM47寻找第K大 {

    /**
     * 9/10 组用例通过  官方的也超时
     * @param a
     * @param n
     * @param K
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        quickSort(a,0,n-1,K);
        return a[n-K];
    }

    private static void quickSort(int[] arr, int l, int r,  int k) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;
        //pivot
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
            }
            if (left >= right) {
                arr[left] = pivot;
            }
        }
        if (right + 1 > arr.length - k) {
            quickSort(arr, l, right, k);
        } else if (right + 1 == arr.length - k) {
            return;
        } else {
            quickSort(arr, right + 1, r, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,2};
        quickSort(arr,0,arr.length-1, 2);
        System.out.println("");
    }

}