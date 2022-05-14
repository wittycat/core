package com.core.algorithm.nowcoder;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/22fdeb9610ef426f9505e3ab60164c93?tpId=37&&tqId=21304&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 *
 */
public class Main81 {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String shorStr = scanner.nextLine();
            String longStr = scanner.nextLine();
            char[] chars = new char[128];
            char[] arry2 = longStr.toCharArray();
            for (int i = 0; i < longStr.length(); i++) {
                int index = arry2[i];
                chars[index] = arry2[i];
            }
            boolean success = true;
            char[] arry1 = shorStr.toCharArray();
            for (int i = 0; i < shorStr.length(); i++) {
                int index = arry1[i];
                if (chars[index] != arry1[i]) {
                    success = false;
                    break;
                }
            }
            System.out.println(success);
        }
    }
}