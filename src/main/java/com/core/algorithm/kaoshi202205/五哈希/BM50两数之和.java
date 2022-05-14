package com.core.algorithm.kaoshi202205.五哈希;

import java.util.HashMap;

/**
 * Created by chenxun.
 * Date: 2022/5/11 10:35 PM
 * Description:
 */
public class BM50两数之和 {
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer,Integer> map=new HashMap();
        for (int i = 0; i < numbers.length ; i++) {
            if(map.containsKey(target-numbers[i])){
                return new int[]{i+1,map.get(target-numbers[i]+1)};
            }else {
                map.put(numbers[i],i);
            }
        }
        return new int[]{};
    }
}