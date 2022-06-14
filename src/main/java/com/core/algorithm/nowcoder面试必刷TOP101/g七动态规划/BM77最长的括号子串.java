package com.core.algorithm.nowcoder面试必刷TOP101.g七动态规划;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by chenxun.
 * Date: 2022/6/14 3:04 AM
 * Description:
 */
public class BM77最长的括号子串 {

    /**
     * https://www.bilibili.com/video/BV1VQ4y1a7it/?spm_id_from=autoNext&vd_source=a30bba17223939a1bea53d90c11ab6f3
     * @param s
     * @return
     */
    public static int longestValidParentheses (String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (i == 0 || dp[i - 1] == 0 && s.charAt(i - 1) == ')') {
                    continue;
                }

                if (dp[i - 1] == 0) {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - 1 - dp[i - 1] >= 0) {
                        if (s.charAt(i - 1 - dp[i - 1]) == '(') {
                            dp[i] = 2 + dp[i - 1] + ((i - 1 - dp[i - 1] - 1 >= 0) ? (dp[i - 1 - dp[i - 1] - 1]) : 0);
                        }
                    }
                }
            }
        }
        Arrays.sort(dp);
        return dp[len - 1];
    }

    public static int longestValidParentheses1 (String s) {
        Stack<Integer> in = new Stack<>();
        int max = 0;
        char[] chars = s.toCharArray();
        int left = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                in.push(i);
            } else {
                if (!in.empty()) {
                    in.pop();
                    if (!in.empty()) {
                        max = Math.max(i - in.peek(), max);
                    } else  {
                        max = Math.max(i-left, max);
                    }
                }else {
                    left=i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses1("(()(()()"));
    }
}