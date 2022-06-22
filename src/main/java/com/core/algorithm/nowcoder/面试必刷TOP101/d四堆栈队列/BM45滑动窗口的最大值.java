package com.core.algorithm.nowcoder.面试必刷TOP101.d四堆栈队列;

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
        System.out.println(":"+integers);
    }


    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size || num.length == 0) {
            return res;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int start = 0;
        int end = 0;

        while (end < num.length ) {
            queue.add(num[end]);
            if (end - start < size - 1) {
                end++;
                continue;
            } else {
                if (res.size() > 0 && num[end] >= res.get(res.size() - 1)) {
                    res.add(num[end]);
                } else {
                    System.out.println(queue.toString());
                    res.add(queue.peek());
                }
                queue.remove(num[start]);
                start++;
                end++;
            }
        }
        return res;
    }
}