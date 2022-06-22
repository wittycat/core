package com.core.algorithm.nowcoder.面试必刷TOP101.e五哈希;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/11 10:50 PM
 * Description:
 */
public class BM54三数之和 {

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3) {
            return res;
        }
        ArrayList keys = new ArrayList();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] > 0) {
                break;
            }
            int sum = -num[i];
            if (keys.contains(sum)) {
                continue;
            } else {
                keys.add(sum);
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                if (sum == num[left] + num[right]) {
                    ArrayList<Integer> data = new ArrayList();
                    data.add(num[i]);
                    data.add(num[left]);
                    data.add(num[right]);
                    res.add(data);

                    //排除重复的数字
                    while ((left + 1) < num.length && num[left] == num[left + 1]) {
                        left++;
                    }
                    while ((right - 1) > 0 && num[right] == num[right - 1]) {
                        right--;
                    }
                    //继续+1
                    left++;
                    right--;

                } else if (sum > num[left] + num[right]) {
                    left++;
                } else if (sum < num[left] + num[right]) {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0,-1,1};
        System.out.println(threeSum(a));
    }


}