package com.core.algorithm.nowcoder面试必刷TOP101.i九双指针;

/**
 * Created by chenxun.
 * Date: 2022/5/23 4:33 PM
 * Description:
 */
public class BM90最小覆盖子串 {


    public String minWindow (String S, String T) {
        char[] charsS = S.toCharArray();
        char[] charsT = T.toCharArray();

        int[] pairs = change(charsT);

        int i = 0;
        int start = 0;
        int end = 0;

        int left = 0;
        int right = 0;
        boolean over = false;
        while (i < charsS.length) {
            if (!over) {
                pairs[charsS[i]]--;
                if (over(pairs)) {
                    over = true;

                    end = i;
                    left = start;
                    right = end;
                }
            } else {
                if (over(pairs)) {
                    char charsS1 = charsS[start];
                    pairs[charsS1]--;
                    start++;
                } else {

                }

            }
            i++;
        }
        return null;
    }

    private boolean over(int[] pairs) {
        for (int i = 0; i < 128; i++) {
            if(pairs[i]>0){
                return false;
            }
        }
        return true;
    }

    private int[]  change(char[] charsT) {
        int[] arr = new int[128];
        for (int i = 0; i < 128; i++) {
            arr[i]=-1;
        }
        for (char c:charsT){
            arr[c]++;
        }
        return arr;
    }

}