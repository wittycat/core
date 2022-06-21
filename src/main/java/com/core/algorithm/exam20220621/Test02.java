package com.core.algorithm.exam20220621;

import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/21 11:02 AM
 * Description:
 */
public class Test02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String replace = scanner.nextLine().replace(",/", ",");
        replace = replace.replace("/,", ",");
        replace = replace.replace(",", "/");
        System.out.println(replace);
    }
}