package com.core.algorithm.nowcoder.面试必刷TOP101.i九双指针;

/**
 * Created by chenxun.
 * Date: 2022/5/23 12:25 PM
 * Description:
 */
public class BM88判断是否为回文字符串 {


    public static boolean judge (String str) {
        int i = 0;
        int j = str.length()-1;
        char[] chars = str.toCharArray();
        while (i<j){
            if(chars[i]!=chars[j]){
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        judge("abaa");
    }
}