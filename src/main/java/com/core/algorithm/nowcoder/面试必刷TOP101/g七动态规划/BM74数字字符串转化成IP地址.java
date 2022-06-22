package com.core.algorithm.nowcoder.面试必刷TOP101.g七动态规划;

import java.util.ArrayList;

/**
 * Created by chenxun.
 * Date: 2022/6/13 10:48 AM
 * Description:
 */
public class BM74数字字符串转化成IP地址 {
    public static ArrayList<String> restoreIpAddresses (String s) {
        ArrayList list = new ArrayList();
        char[] chars = s.toCharArray();
        if (chars.length < 3||chars.length>12) {
            return list;
        }
        int length = chars.length;
        for (int i = 1; i < 4 && i < length; i++) {
            Integer a = Integer.valueOf(String.copyValueOf(chars, 0, i));
            if (a > 255) {
                continue;
            }

            for (int j = i + 1; j < i + 4 && j < length && j - i > 0; j++) {
                Integer b = Integer.valueOf(String.copyValueOf(chars, i, j - i));
                if (b > 255) {
                    continue;
                }
                for (int m = j + 1; m < j + 4 && m < length && m - j > 0 && length - m > 0; m++) {
                    Integer c = Integer.valueOf(String.copyValueOf(chars, j, m - j));
                    if (c > 255) {
                        continue;
                    }
                    Integer d = Integer.valueOf(String.copyValueOf(chars, m, length - m));
                    if (d > 255) {
                        continue;
                    }
                    /**
                     * 010010 类似这样 切分后位数就不够了 做个校验
                     */
                    String ip = a + "." + b + "." + c + "." + d;
                    if(ip.length()-3==length){
                        list.add(ip);
                    }
                }
            }
        }
        return list ;
    }


    public static void main(String[] args) {
        String a = "010010";
        System.out.println(restoreIpAddresses(a));
    }
}