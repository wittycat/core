package com.core.algorithm.nowcoder面试必刷TOP101.j十贪心算法;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by chenxun.
 * Date: 2022/5/28 9:40 AM
 * Description:
 */
public class BM96主持人调度二 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     * 2,[[1,3],[2,4]]
     */
    public static int minmumNumberOfHost (int n, int[][] startEnd) {
        Arrays.sort(startEnd, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return o1[0] - o2[0];
            }
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return -1;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(startEnd[0][1]);
        for (int i = 1; i < startEnd.length; i++) {
            //有已经结束的，不需要新主持人
            if(startEnd[i][0]>=pq.peek()){
                pq.poll();//移除上一个活动结束时间
                pq.offer(startEnd[i][1]);//更新活动结束时间
            }else {
                //没有空闲主持人【因为目前结束最早的主持人时间都要晚于目前活动开始时间】， 新加入一个主持人
                pq.offer(startEnd[i][1]);
            }

        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 4}, {1, 2}};
        System.out.println(minmumNumberOfHost(a.length,a));
    }
}