package com.core.algorithm.nowcoder面试必刷TOP101.五哈希;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/11 10:50 PM
 * Description:
 */
public class BM54三数之和 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
       if(num.length<3){
           return res;
       }
        Arrays.sort(num);
        for (int i = 0; i < num.length-2; i++) {
            int sum= -num[i];
            int left=i+1;
            int right=num.length-1;
            while (left<right){
                if(sum==num[left]+num[right]){
                    ArrayList<Integer> data =new ArrayList();
                    data.add(num[i]);
                    data.add(num[left]);
                    data.add(num[right]);
                    res.add(data);
                    continue;
                }else if(sum>num[left]+num[right]) {
                    left++;
                }else if(sum<num[left]+num[right]) {
                    right--;
                }
            }
        }
        return res;
    }
}