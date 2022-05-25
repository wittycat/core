package com.core.algorithm.nowcoder面试必刷TOP101.七动态规划;

/**
 * Created by chenxun.
 * Date: 2022/5/25 2:23 PM
 * Description:
 *
 *
 *
 * 中心扩展法 奇数偶数都对比
 */
public class BM73最长回文子串 {
    public static int getLongestPalindrome (String A) {
        if(A==null){
            return 0;
        }
        if(A.length()<2){
            return A.length();
        }
        String s = A;
        char[] chars = s.toCharArray();
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            max = Math.max(max,Math.max(get(s,i,i),get(s,i,i+1)));
        }
        return max;
    }

    private static int get(String s, int start, int end) {
        while (start <= end && start > -1 && end < s.length() && s.charAt(start)==s.charAt(end) ) {
            start--;
            end++;
        }
        return end-start-1;
    }

    public static void main(String[] args) {
        System.out.println(getLongestPalindrome("baabccc"));
    }
}