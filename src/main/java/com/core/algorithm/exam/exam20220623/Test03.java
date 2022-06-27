package com.core.algorithm.exam.exam20220623;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by chenxun.
 * Date: 2022/6/23 11:26 AM
 * Description:
 */
public class Test03 {
    /**
     *
     * https://leetcode.cn/problems/largest-number/
     * 10 9
     * 910
     *
     * 109
     * 999
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ss = scanner.nextLine().split(" ");
        int max = 0;
        for (int i = 0; i < ss.length; i++) {
            max = Math.max(ss[i].length(), max);
        }
        int finalMax = max;
        String collect = Arrays.stream(ss).map(s -> {
            int i = finalMax - s.length();
            String bu = "";
            for (int j = 0; j < i; j++) {
                bu += "9";
            }
            return new MyNumber(s, s + bu);
        }).sorted(new Comparator<MyNumber>() {
            @Override
            public int compare(MyNumber o1, MyNumber o2) {
                return o1.bu.compareTo(o2.bu);
            }
        }.reversed()).map(MyNumber::getOld).collect(Collectors.joining(""));
        System.out.println(collect.startsWith("0") ? "0" : collect);
    }

    static class MyNumber{
        private String old;
        private String bu;

        public MyNumber(String old, String bu) {
            this.old = old;
            this.bu = bu;
        }

        public String getOld() {
            return old;
        }
    }
}