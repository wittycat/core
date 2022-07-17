package com.core.algorithm.exam.exam20220629;

/**
 * Created by chenxun.
 * Date: 2022/6/29 11:25 AM
 * Description:
 */
public class Test01 {

    /**
     * 问题描述： 求两个字符串 str1 和 str2 的"最长"的"公共的"子字符串。
     *
     * String str1 = "abc@12345%abcd";
     * String str2 = "abc%12345@abcd";
     *
     * 预期结果： 输出12345 （因为长度是最长的5， 比abcd 长）。
     * ============================================================
     * main() {
     * 	// 不需要从控台获取输入，直接写死：
     * 	String str1 = "abc@12345%abcd";
     * 	String str2 = "abc%12345@abcd";
     *
     * 	String result = getMaxSubstring(str1, str2);
     *
     * 	// 打印出result 结果
     *     System.out.printlin("result = " + result);
     * }
     * String getMaxSubstring(String str1, String str2) {
     * 	return result;
     * }
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "abc@12345%abcd";
        String str2 = "abc%12345@abcd";
        String result = getMaxSubstring(str1, str2);
        System.out.println("result = " + result);
    }

    private static String getMaxSubstring(String str1, String str2) {
        if (str1 == null || str1.length() == 0) {
            return "";
        }
        if (str2 == null || str2.length() == 0) {
            return "";
        }

        int i = 0;
        int j = 1;
        String maxString = "";
        while (i < str1.length() && j < str1.length() && i <= j) {
            String substring = str1.substring(i, j);
            if (str2.contains(substring)) {
                if (substring.length() > maxString.length()) {
                    maxString = substring;
                }
                j++;
            } else {
                i++;
                if (i > 0 && i == j) {
                    j = j + 1;
                }
            }
        }

        return maxString;
    }
}