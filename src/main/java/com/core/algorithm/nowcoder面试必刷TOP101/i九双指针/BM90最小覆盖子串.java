package com.core.algorithm.nowcoder面试必刷TOP101.i九双指针;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/23 4:33 PM
 * Description:
 */
public class BM90最小覆盖子串 {

    static int[] pairs = null;
    static int[] copyOf = null;

    public static String minWindow(String S, String T) {
        char[] charsS = S.toCharArray();
        char[] charsT = T.toCharArray();

        pairs = new int[128];
        copyOf = change(T.toCharArray());

        String res="";
        int start = 0;
        int end = 0;
        while (start < charsS.length || end < charsS.length) {
            boolean all = all(charsT);
            int i = 0;
            if (all && start < charsS.length) {
                String value = String.valueOf(Arrays.copyOfRange(charsS, start, end));
                if(res.equals("")){
                    res=value;
                }
                res=value.length()>res.length()?res:value;
                pairs[charsS[start]]--;
                start++;
                i++;
            }
            if (!all && end < charsS.length) {
                pairs[charsS[end]]++;
                end++;
                i++;
            }
            if (i == 0) {
                break;
            }
        }
        return res;
    }

    private static boolean all(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (pairs[chars[i]] < copyOf[chars[i]]) {
                return false;
            }
        }
        return true;
    }

    private static int[] change(char[] chars) {
        int[] arr = new int[128];
        for (char c : chars) {
            arr[c]++;
        }
        return arr;
    }


    public static void main(String[] args) {
        String s = minWindow("a", "a");
        System.out.println(s);
    }
}