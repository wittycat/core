package com.core.algorithm.kaoshi202205.五哈希;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by chenxun.
 * Date: 2022/5/13 6:37 PM
 * Description:
 */
public class BM51数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        MoreThanHalfNum_Solution( new int[]{1,2,3,2,2,2,5,4,2});
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array!=null&&array.length==1){
            return array[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer orDefault = map.getOrDefault(array[i], 0);
            map.put(array[i],orDefault+1);
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().filter(entity -> {
            Integer value = entity.getValue();
            if (value > (array.length / 2)) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        if(collect.size()>0){
            return collect.get(0).getKey();
        }
        return 0;

    }
}