package com.core.algorithm.exam20220621;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/6/21 11:14 AM
 * Description:
 *
 * https://leetcode.cn/problems/task-scheduler/submissions/
 */
public class Test03_2 {
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (tasks.length == 1) {
            return 1;
        }
        int[] arr = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            arr[tasks[i] - 'A']++;
        }
        Arrays.sort(arr);
        //除过最后一行的面积
        int res = (arr[25] - 1) * (n + 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[25] == arr[i]) {
                //最后一行有几个
                res++;
            }
        }
        //不能小于实际任务数
        return Math.max(res, tasks.length);
    }


    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int i = leastInterval(tasks, 2);
        System.out.println(i);
    }
}