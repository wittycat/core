package com.core.algorithm.nowcoder面试必刷TOP101.k十一模拟;

import java.util.*;

/**
 * Created by chenxun.
 * Date: 2022/6/7 5:07 PM
 * Description:
 */
public class BM101设计LFU缓存结构 {
    private static Map<Integer,Integer> valueMap = new LinkedHashMap<>();
    private static Map<Integer,Integer> countMap = new LinkedHashMap<>();
    public static int[] LFU (int[][] operators, int k) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < operators.length; i++) {
            int[] operator = operators[i];
            int ops = operator[0];
            int key = operator[1];
            if (ops == 1) {
                //add
                int value = operator[2];
                if (valueMap.containsKey(key)) {
                    valueMap.put(key,value);

                    int newCount = countMap.get(key) + 1;
                    countMap.remove(key);
                    countMap.put(key,newCount);
                }else {
                    if(valueMap.size()<k){
                        valueMap.put(key,value);
                        countMap.put(key,1);
                    }else {
                        //删除
                        Integer count = countMap.values().stream().sorted().findFirst().get();
                        Integer removekey = countMap.entrySet().stream().filter(entry -> entry.getValue().equals(count)).findFirst().get().getKey();
                        valueMap.remove(removekey);
                        countMap.remove(removekey);
                        //添加
                        valueMap.put(key,value);
                        countMap.put(key,1);
                    }
                }
            } else {
                //get
                if (valueMap.containsKey(key)) {
                    list.add(valueMap.get(key));

                    int newCount = countMap.get(key) + 1;
                    countMap.remove(key);
                    countMap.put(key,newCount);
                }else {
                    list.add(-1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] a = {{1,1,1},{1,2,2},{1,3,2},{1,2,4},{1,3,5},{2,2},{1,4,4},{2,1}};
        int[] lfu = LFU(a, 3);
        System.out.println(Arrays.toString(lfu));
    }
}