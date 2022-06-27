package com.core.algorithm.exam.exam20220623;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by chenxun.
 * Date: 2022/6/23 11:00 AM
 * Description:
 */
public class Test01 {
    /**
     * abc efabciiabci
     * abc efghicaibii
     * https://blog.csdn.net/qq_34465338/article/details/124489533
     *
     * 58% 测试通过用例？？？？？？
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line == null || line.length() == 0) {
            System.out.println(-1);
            return;
        }
        String[] s1 = line.split(" ");
        String str1 = s1[0];
        String str2 = s1[1];
        if (str1.length() == 0 || str2.length() == 0) {
            System.out.println(-1);
            return;
        }
        if (str1.length() > str2.length()) {
            System.out.println(-1);
            return;
        }

        int[] visit = new int[str1.length()];
        Set<String> set = new HashSet<>();
        dfs(str1, visit, set, "");
        int i = -1;
        for (String s : set) {
            i = str2.indexOf(s);
            if (i > 0) {
                break;
            }
        }
        System.out.println(i);
    }

    private static void dfs(String str1, int[] visit, Set<String> list, String res) {
        if (res.length() == str1.length()) {
            list.add(res);
            return;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            dfs(str1, visit, list, res + str1.charAt(i));
            visit[i] = 0;
        }
    }
}