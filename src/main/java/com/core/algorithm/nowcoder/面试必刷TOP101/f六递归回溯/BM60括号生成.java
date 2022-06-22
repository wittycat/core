package com.core.algorithm.nowcoder.面试必刷TOP101.f六递归回溯;

import java.util.ArrayList;

/**
 * Created by chenxun.
 * Date: 2022/6/14 4:00 PM
 * Description:
 *  https://www.bilibili.com/video/BV1MA411L7h3?p=1&vd_source=a30bba17223939a1bea53d90c11ab6f3
 *
 *  剪枝 回溯
 */
public class BM60括号生成 {

    public static ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> list = new ArrayList<>();
        dfs("", 0, 0, n, list);
        return list;
    }

    private static void dfs(String res, int left, int right, int n, ArrayList<String> list) {
        if (left == n && right == n) {
            list.add(res);
            return;
        }
        if (left < n) {
            dfs(res + "(", left + 1, right, n, list);
        }
        if (right < left) {
            dfs(res + ")", left, right + 1, n, list);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

}