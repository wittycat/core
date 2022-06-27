package com.core.algorithm.exam.exam20220625;

/**
 * Created by chenxun.
 * Date: 2022/6/25 3:10 PM
 * Description:
 * https://leetcode.cn/problems/solve-the-equation/
 */
public class Solution01 {

    /**
     * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
     *
     * 如果方程没有解，请返回 "No solution" 。
     * 如果方程有无限解，则返回 “Infinite solutions” 。
     * 如果方程中只有一个解，要保证返回值 'x' 是一个整数。
     *
     * @param equation
     * @return
     */
    public static String solveEquation(String equation) {
        String[] arr = equation.split("=");
        String right = (arr[1].charAt(0) == '-' ? "" : "+") + arr[1];
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for (int i = 0; i < right.length(); i++) {
            switch (right.charAt(i)) {
                case '+':
                    sb.append("-");
                    break;
                case '-':
                    sb.append("+");
                    break;
                default:
                    sb.append(right.charAt(i));
            }
        }
        String s = sb.toString();
        int x = 0;
        int number = 0;

        boolean flag = s.startsWith("-");
        int tempI = flag?1:0;
        for (int i = tempI; i < s.length(); ) {
            int j = i;
            while (j < s.length() && s.charAt(j) != '+' && s.charAt(j) != '-') {
                j++;
            }
            char c;
            if (flag) {
                c = '-';
                flag = false;
            } else {
                c = i < 1 ? '+' : s.charAt(i - 1);
            }

            String num = s.substring(i, j);
            if (num.contains("x")) {
                String temp = num.replace("x", "");
                int value = Integer.parseInt(temp.length() == 0 ? "1" : temp);
                x = c == '-' ? x - value : x + value;
            } else {
                number = c == '-' ? number - Integer.parseInt(num) : number + Integer.parseInt(num);
            }
            i = j + 1;
        }

        if (x != 0) {
            return "x=" + (-number / x);
        } else {
            return number == 0 ? "Infinite solutions" : "No solution";
        }
    }

    public static void main(String[] args) {
        System.out.println(solveEquation("-x=-1"));

    }

}