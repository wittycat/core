package com.core.algorithm.nowcoder面试必刷TOP101.i九双指针;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by chenxun.
 * Date: 2022/5/23 3:20 PM
 * Description:
 */
public class BM89合并区间 {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        if(intervals==null||intervals.size()<2){
            return intervals;
        }

        Collections.sort(intervals, (Comparator) (o1, o2) -> {
            Interval interval1 = (Interval)o1;
            Interval interval2 = (Interval)o2;
            return interval1.start-interval2.start;
        });

        Interval interval = intervals.get(0);
        res.add(interval);
        for (int i = 1; i < intervals.size() ; i++) {
            Interval interval1 = intervals.get(i);
            Interval interval2 = res.get(res.size() - 1);
            if(interval1.start<=interval2.end){
                interval2.end=interval2.end>interval1.end?interval2.end:interval1.end;
            }else {
                res.add(interval1);
            }
        }
        return res;
    }
}