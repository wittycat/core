package com.core.algorithm.nowcoder面试必刷TOP101.四堆栈队列;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by chenxun.
 * Date: 2022/5/13 4:20 PM
 * Description:
 */
public class BM45滑动窗口的最大值 {


    public static void main(String[] args) {
        ArrayList<Integer> integers = maxInWindows(new int[]{10,2,3,1,4}, 3);
        System.out.println(integers);
    }


    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if(num.length<size||num.length==0){
            return res;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        boolean flag = false;
        int length = num.length-size+1;
        int t = size-1;
        for (int i = 0; i < length ; i++) {
            if(!flag){
                int j = i;
                while (j<(i+size)){
                    priorityQueue.add(num[j]);
                    j++;
                }
                flag = true;
            }else {
                priorityQueue.add(num[i+t]);
            }
            res.add(priorityQueue.peek());
            priorityQueue.remove(num[i]);
        }
        return res;
    }
}