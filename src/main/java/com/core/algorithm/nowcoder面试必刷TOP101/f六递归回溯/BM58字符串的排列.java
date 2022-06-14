package com.core.algorithm.nowcoder面试必刷TOP101.f六递归回溯;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by chenxun.
 * Date: 2022/6/14 4:10 PM
 * Description:
 */
public class BM58字符串的排列 {
    public static ArrayList<String> Permutation(String str) {
        HashSet<String> set = new HashSet<>();
        char[] chars = str.toCharArray();
        int[] visit = new int[chars.length];
        dfs(chars, visit, "", set);
        return new ArrayList<>(set);
    }

    private static void dfs(char[] chars, int[] visit, String res, HashSet<String> set) {
        if (res.length() == chars.length) {
            set.add(res);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visit[i] == 1) {
                continue;
            }
            visit[i] = 1;
            char addChar = chars[i];
            dfs(chars, visit, res + addChar, set);
            visit[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Permutation("aa"));
    }
}