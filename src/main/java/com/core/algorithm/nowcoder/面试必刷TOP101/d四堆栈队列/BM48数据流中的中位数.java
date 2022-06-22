package com.core.algorithm.nowcoder.面试必刷TOP101.d四堆栈队列;

import java.util.PriorityQueue;

/**
 * Created by chenxun.
 * Date: 2022/6/5 5:31 PM
 * Description:
 */
public class BM48数据流中的中位数 {

    //4 5 6
    PriorityQueue<Integer> min = new PriorityQueue();
    //1 2 3
    PriorityQueue<Integer> max = new PriorityQueue((o1, o2) -> (Integer)o2-(Integer)o1);

    public void Insert(Integer num) {
        min.add(num);
        max.add(min.poll());
        if(min.size()<max.size()){
            min.add(max.poll());
        }
    }

    public Double GetMedian() {
        if (min.size()>max.size()){
            return Double.valueOf(min.peek());
        }else {
            return (Double.valueOf(min.peek())+max.peek())/2;
        }
    }
}