package com.core.algorithm.nowcoder;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2020/6/2 下午10:38
 * Description:
 * https://www.nowcoder.com/practice/98dc82c094e043ccb7e0570e5342dd1b?tpId=37&&tqId=21298&rp=1&ru=/activity/oj&qru=/ta/huawei/question-ranking
 *
 */
public class Main75 {

    /**
     * 二位数组求解
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();
            char[] chars1 = line1.toCharArray();
            char[] chars2 = line2.toCharArray();
            int[][] c = new int[chars1.length][chars2.length];
            int maxLength = 0;
            for (int i = 0; i < chars1.length; i++) {
                for (int j = 0; j < chars2.length; j++) {
                    if (chars1[i] == chars2[j]) {
                        if (i == 0 || j == 0) {
                            c[i][j] = 1;
                        } else {
                            //最大标记
                            c[i][j] = c[i - 1][j - 1] + 1;
                        }
                        if (c[i][j] > maxLength) {
                            maxLength = c[i][j];
                        }
                    }
                }
            }
            System.out.println(maxLength);
        }
        sc.close();
    }
}