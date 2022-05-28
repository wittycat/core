package com.core.algorithm.nowcoder面试必刷TOP101.d四堆栈队列;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by chenxun.
 * Date: 2022/5/13 6:24 PM
 * Description:
 */
public class BM46最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input==null||input.length==0||k==0){
            return res;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i <input.length ; i++) {
            priorityQueue.add(input[i]);
        }
        for (int i = 0; i <k ; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }
}