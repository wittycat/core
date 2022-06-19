package com.core.algorithm.amoscloud2022;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/19 2:26 PM
 * Description:
 */
public class 题目68 {
    /**
     * 给定一个随机的整数数组(可能存在正整数和负整数)nums,
     * 请你在该数组中找出两个数，其和的绝对值(|nums[x]+nums[y]|)为最小值
     * 并返回这两个数(按从小到大返回)以及绝对值。
     * 每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 输入描述：
     *  一个通过空格空格分割的有序整数序列字符串，最多1000个整数，
     *  且整数数值范围是[-65535,65535]
     *
     * 输出描述：
     *   两个数和两数之和绝对值
     *
     *  示例一：
     *   输入
     *   -1 -3 7 5 11 15
     *   输出
     *   -3 5 2
     *
     * 说明：
     * 因为|nums[0]+nums[2]|=|-3+5|=2最小，
     * 所以返回-3 5 2
     *
     * @param args
     */
    public static void main(String[] args) {
       //伪代码
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer[] array = Arrays.stream(line.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <array.length ; i++) {
            for (int j = i+1; j <array.length ; j++) {
                System.out.println(array[i]+":"+array[j]+" "+Math.abs(array[i]+array[j]));
                min = Math.min(Math.abs(array[i]+array[j]),min);
            }
        }
        System.out.println(min);
    }
}