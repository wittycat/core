package com.core.algorithm.amoscloud2022;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/16 12:40 PM
 * Description:
 */
public class 题目82 {
    /**
     *   1.输入字符串s输出s中包含所有整数的最小和，
     *   说明：1字符串s只包含a~z,A~Z,+,-，
     *   2.合法的整数包括正整数，一个或者多个0-9组成，如：0,2,3,002,102
     *   3.负整数，负号开头，数字部分由一个或者多个0-9组成，如-2,-012,-23,-00023
     *   输入描述：包含数字的字符串
     *   输出描述：所有整数的最小和
     *   示例：
     *     输入：
     *       bb1234aa
     *   　输出
     *       10
     *   　输入：
     *       bb12-34aa
     *   　输出：
     *       -31
     *   说明：1+2-(34)=-31
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '-') {
                i++;
                String num = "";
                while (i < line.length() && Character.isDigit(line.charAt(i))) {
                    num = num + line.charAt(i);
                    i++;
                }
                sum = sum - Integer.parseInt(num);
                if (i == line.length()) {
                    break;
                }
            }
            if (Character.isDigit(line.charAt(i))) {
                sum = (line.charAt(i) - '0') + sum;
            }
        }
        System.out.println(sum);
    }


}