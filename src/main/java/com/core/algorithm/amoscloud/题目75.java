package com.core.algorithm.amoscloud;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/16 5:19 PM
 * Description:
 */
public class 题目75 {
    /**
     *   输入一串字符串
     *   字符串长度不超过100
     *   查找字符串中相同字符连续出现的最大次数
     *
     *   输入描述
     *     输入只有一行，包含一个长度不超过100的字符串
     *
     *   输出描述
     *     输出只有一行，输出相同字符串连续出现的最大次数
     *
     *    说明：
     *      输出
     *
     *    示例1：
     *      输入
     *        hello
     *      输出
     *        2
     *
     *     示例2：
     *       输入
     *        word
     *       输出
     *        1
     *
     *      示例3：
     *       输入
     *         aaabbc
     *        输出
     *         3
     *
     *     字符串区分大小写
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char pre = line.charAt(0);
        int lastMax = 0;
        int max = 1;
        for (int i = 1; i < line.length(); i++) {
            if (pre == line.charAt(i)) {
                max += 1;
            } else {
                lastMax = Math.max(lastMax, max);
                max=1;
            }
            pre = line.charAt(i);
        }
        System.out.println(lastMax);
    }
}