package com.core.algorithm.nowcoder面试必刷TOP101.k十一模拟;

import java.util.ArrayList;

/**
 * Created by chenxun.
 * Date: 2022/5/28 12:25 PM
 * Description:
 *
 * 定义4个指针 任何一次遍历后，4个指针其中的一组不符合逻辑就终止
 */
public class BM98螺旋矩阵 {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList list = new ArrayList();
        if (matrix.length == 0) {
            return list;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int high = 0;
        int low = matrix.length - 1;
        for (;;) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[high][i]);
            }
            high++;
            if (high > low) {
                break;
            }


            for (int i = high; i <= low; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (left > right) {
                break;
            }


            for (int i = right; i >= left; i--) {
                list.add(matrix[low][i]);
            }
            low--;
            if (high > low) {
                break;
            }

            for (int i = low; i >= high; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] a= {{2,3}};
        System.out.println(spiralOrder(a));
    }
}