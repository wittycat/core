package com.core.algorithm.kaoshi202205.二二分查找排序;

/**
 * Created by chenxun.
 * Date: 2022/5/13 7:14 PM
 * Description:
 */
public class BM18二维数组中的查找 {
    /**
     * step 1：首先获取矩阵的两个边长，判断特殊情况。
     * step 2：首先以左下角为起点，若是它小于目标元素，则往右移动去找大的，若是他大于目标元素，则往上移动去找小的。
     * step 3：若是移动到了矩阵边界也没找到，说明矩阵中不存在目标值。
     *
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15]
     * ]
     *
     */

    public static void main(String[] args) {
        boolean find = Find(7, new int[][]{{1, 2, 8, 9}, {4, 7, 10, 13}});
        System.out.println(find);
    }


    public static boolean Find(int target, int [][] array) {
       if(array==null||array.length==0||array[0].length==0){
           return false;
       }

       int x= 0;//数组的数组长度
       int y= array.length-1;//数据长度
       while (x<array[0].length && y>=0){
           int m = array[y][x];
           if(m==target){
               return true;
           }
           if(target<m){
               y--;
           }else {
               x++;
           }
       }

       return false;
    }
}