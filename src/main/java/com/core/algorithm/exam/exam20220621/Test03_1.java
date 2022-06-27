package com.core.algorithm.exam.exam20220621;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenxun.
 * Date: 2022/6/21 11:14 AM
 * Description:
 *
 * https://leetcode.cn/problems/task-scheduler/submissions/
 */
public class Test03_1 {
    public static int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (tasks.length == 1) {
            return 1;
        }
        Arrays.sort(tasks);
        int[] visit = new int[tasks.length];
        Set<String> types = new HashSet<>();
        dsf(tasks, visit, types, "");
        int min = Integer.MAX_VALUE;
        for (String type1 : types) {
            String type = type1;
            int wait = 0;
            for (int i = 1; i < type.length(); i++) {
                char cur = type.charAt(i);
                if (cur == '1') {
                    continue;
                }
                int temp = i - 1;
                int end = temp - n;
                while (temp > -1 && temp >= end) {
                    char pre = type.charAt(temp);
                    if (pre == cur) {
                        wait = n - (i - temp) + 1;
                        break;
                    }
                    temp--;
                }
                if (wait > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(type);
                    stringBuilder.insert(i, wait == 1 ? "1" : "11");
                    type = stringBuilder.toString();
                    i = 0;
                    wait = 0;
                }
            }
            min = Math.min(min, type.length());
        }
        return min;
    }

    private static void dsf(char[] tasks, int[] visit, Set<String> types, String s) {
        if (s.length() == tasks.length) {
            types.add(s);
            return;
        }
        for (int i = 0; i < tasks.length; i++) {
            if (visit[i] == 1 || (i - 1 > -1 && visit[i - 1] == 1 && tasks[i] == (tasks[i - 1]))) {
                continue;
            }
            visit[i] = 1;
            dsf(tasks, visit, types, s + tasks[i]);
            visit[i] = 0;
        }
    }


    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int i = leastInterval(tasks, 2);
        System.out.println(i);
    }
}