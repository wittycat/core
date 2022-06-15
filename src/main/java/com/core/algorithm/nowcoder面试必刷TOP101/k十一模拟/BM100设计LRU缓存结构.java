package com.core.algorithm.nowcoder面试必刷TOP101.k十一模拟;

import java.util.*;

/**
 * Created by chenxun.
 * Date: 2022/6/7 3:44 PM
 * Description:
 */
public class BM100设计LRU缓存结构 {


    private Map<Integer,Integer> map = new LinkedHashMap<>();
    private int count= 0;

    public BM100设计LRU缓存结构(int capacity) {
        count=capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if(value!=null){
            map.remove(key);
            map.put(key,value);
        }
        return value==null?-1:value;
    }

    public void set(int key, int value) {
        if(map.size()<count){
            if(map.containsKey(key)){
                map.remove(key);
            }
            map.put(key,value);
        }else {
            if(map.containsKey(key)){
                map.remove(key);
                map.put(key,value);
            }else {
                Integer key1 = map.entrySet().iterator().next().getKey();
                map.remove(key1);
                map.put(key,value);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        map.put(1,1);
        map.put(9,9);
        map.put(5,5);
        System.out.println(map.toString());
        map.put(1,2);
        System.out.println(map.toString());
    }
}