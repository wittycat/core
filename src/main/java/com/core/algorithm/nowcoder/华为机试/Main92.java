package com.core.algorithm.nowcoder.华为机试;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/profile/121472/codeBookDetail?submissionId=1519346
 *
 */
public class Main92 {

    /**
     * 输入参数：
     *    char* intputstr  输入字符串；
     *
     * 输出参数：
     *    char** pOutputstr: 连续最长的数字串，如果连续最长的数字串的长度为0，应该返回空字符串；如果输入字符串是空，也应该返回空字符串；
     *
     * 返回值：
     *   连续最长的数字串的长度
     *
     *   输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            line = line.replaceAll("\\s", "");
            if (line.length() == 0) {
                System.out.println(",0");
            } else {

                StringBuffer str = new StringBuffer();
                char[] chars = line.toCharArray();
                boolean has = false;
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        str.append(chars[i]);
                        has = true;
                    } else {
                        str.append(" ");
                    }
                }
                if (has) {
                    StringBuffer print = new StringBuffer();
                    String[] split = str.toString().trim().split(" ");
                    int length = Arrays.stream(split).max(Comparator.comparingInt(String::length)).get().length();
                    for (int i = 0; i < split.length; i++) {
                        String s = split[i];
                        if (s.length() == length) {
                            print.append(s);
                        }
                    }
                    print.append("," + length);
                    System.out.println(print.toString());
                } else {
                    System.out.println(",0");
                }
            }
        }
        sc.close();
    }
}