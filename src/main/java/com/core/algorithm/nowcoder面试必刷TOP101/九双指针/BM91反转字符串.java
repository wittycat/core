package com.core.algorithm.nowcoder面试必刷TOP101.九双指针;

/**
 * Created by chenxun.
 * Date: 2022/5/23 3:11 PM
 * Description:
 */
public class BM91反转字符串 {
    public String solve (String str) {
        if(str==null||str.length()==0){
            return str;
        }
        int i = 0;
        int j = str.length() - 1;
        char[] chars = str.toCharArray();
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}