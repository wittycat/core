package com.core.algorithm.exam20220623;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/23 11:26 AM
 * Description:
 */
public class Test031 {
    /**
     * 10 9
     * 910
     *
     * 109
     * 999
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        Arrays.sort(arr, (o1, o2) -> -(o1 + o2).compareTo(o2 + o1));
        String res = String.join("", arr);
        System.out.println(res.startsWith("0") ? "0" : res);
    }
}