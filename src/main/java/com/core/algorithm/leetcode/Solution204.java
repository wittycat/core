package com.core.algorithm.leetcode;

/**
 * Created by chenxun.
 * Date: 2020/6/6 下午7:00
 * Description:
 */
public  class Solution204 {
    public static int countPrimes(int n) {
        int count = 0;
        if (n == 4) {
            return 2;
        }
        if (n == 3) {
            return 1;
        }
        if (n <= 2) {
            return 0;
        }
        count = 0;
        for (int i = 4; i < n; i++) {
            if (is(i))
                count++;
        }
        return count + 2;
    }
    private static boolean is(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = countPrimes(10);
        System.out.println(count);
    }
}