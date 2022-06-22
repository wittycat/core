package com.core.algorithm.nowcoder.面试必刷TOP101.i九双指针;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by chenxun.
 * Date: 2022/5/23 4:07 PM
 * Description:
 */
public class BM92最长无重复子数组 {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        if(arr==null){
            return 0;
        }
        if(arr.length==1){
            return 1;
        }

        int i = 0;
        int maxLength = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        while (i<arr.length){
            int v = arr[i];
            if(queue.contains(v)){
                maxLength = maxLength>queue.size()?maxLength:queue.size();
                while (queue.peek()!=v){
                    queue.poll();
                }
                queue.poll();
                queue.add(v);
            }else {
                queue.add(v);
            }
            i++;
        }
        maxLength = maxLength>queue.size()?maxLength:queue.size();
        return maxLength;
    }
}