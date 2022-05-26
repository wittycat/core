package com.core.algorithm.nowcoder面试必刷TOP101.五哈希;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chenxun.
 * Date: 2022/5/26 3:02 PM
 * Description:
 */
public class BM52数组中只出现一次的两个数字 {
    public static int[] FindNumsAppearOnce (int[] array) {

        if(array==null||array.length<2){
            return array;
        }
        Map<Integer,Integer> map = new TreeMap();
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        Object[] objects = map.entrySet().stream().filter(entry -> entry.getValue().equals(1)).map(Map.Entry::getKey).toArray();
        int[] a = new int[2];
        if(objects.length>=2){
            a[0] = (int) objects[0];
            a[1] = (int) objects[1];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3,6};
        System.out.println(FindNumsAppearOnce(a).toString());
    }


}