package com.core.algorithm.leetcode全部题目;

/**
 * Created by chenxun.
 * Date: 2022/6/22 12:18 PM
 * Description:
 */
public class leetcode1614括号的最大嵌套深度 {
    public static int maxDepth(String s) {
        int res = 0;
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                h++;
                res = Math.max(h, res);
                System.out.println(h+"==="+res);
            }
            if (s.charAt(i) == ')') {
                h--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+2)/(5+((4-9+8)*((1+8+(5*7)*4)/(7+9-5)))/(7/3-8-4-8))"));
    }
}