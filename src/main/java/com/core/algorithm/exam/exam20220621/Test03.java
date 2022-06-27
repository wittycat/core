package com.core.algorithm.exam.exam20220621;

import java.util.*;

/**
 * Created by chenxun.
 * Date: 2022/6/21 11:14 AM
 * Description:
 * https://www.nowcoder.com/discuss/931139?channel=-1&source_id=community_index_nctrack
 * https://leetcode.cn/problems/task-scheduler/submissions/
 */
public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] tasks = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).toArray(Integer[]::new);
        if (tasks == null || tasks.length == 0) {
            System.out.println(0);
            return;
        }
        if (tasks.length == 1) {
            System.out.println(1);
            return;
        }
        Arrays.sort(tasks);
        int n = Integer.parseInt(scanner.nextLine());
        int[] visit = new int[tasks.length];
        Set<String> types = new HashSet<>();
        dsf(tasks, visit, types, "");
        int min = Integer.MAX_VALUE;
        for (String type : types) {
            int wait = 0;
            int cost = 1;
            for (int i = 1; i < type.length(); i++) {
                char cur = type.charAt(i);
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
                    cost += wait;
                    cost += 1;
                    wait = 0;
                } else {
                    cost += 1;
                }
                if (cost >= min) {
                    continue;
                }
            }
            min = Math.min(cost, min);
        }
        System.out.println(min);
    }

    private static void dsf(Integer[] tasks, int[] visit, Set<String> types, String s) {
        if (s.length() == tasks.length) {
            types.add(s);
            return;
        }
        for (int i = 0; i < tasks.length; i++) {
            if (visit[i] == 1 || (i - 1 > -1 && visit[i - 1] == 1 && tasks[i].equals(tasks[i - 1]))) {
                continue;
            }
            visit[i] = 1;
            dsf(tasks, visit, types, s + tasks[i]);
            visit[i] = 0;
        }
    }
}