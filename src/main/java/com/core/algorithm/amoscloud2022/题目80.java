package com.core.algorithm.amoscloud2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by chenxun.
 * Date: 2022/6/16 1:41 PM
 * Description:
 */
public class 题目80 {
    /**
     *         给定参数n,从1到n会有n个整数:1,2,3,...,n,
     *         这n个数字共有n!种排列.
     *       按大小顺序升序列出所有排列的情况,并一一标记,
     *       当n=3时,所有排列如下:
     *       "123" "132" "213" "231" "312" "321"
     *       给定n和k,返回第k个排列.
     *
     *       输入描述:
     *         输入两行，第一行为n，第二行为k，
     *         给定n的范围是[1,9],给定k的范围是[1,n!]。
     *       输出描述：
     *         输出排在第k位置的数字。
     *
     *       实例1：
     *         输入:
     *           3
     *           3
     *         输出：
     *           213
     *         说明
     *           3的排列有123,132,213...,那么第三位置就是213
     *
     *       实例2：
     *         输入
     *           2
     *           2
     *         输出：
     *           21
     *         说明
     *           2的排列有12,21，那么第二位置的为21
     */

    public static void main(String[] args) {
        //数字dfs 排序 选取
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        String num = "";
        for (int i = 1; i <= n ; i++) {
            num+=i;
        }
        int[] visit=new int[n];
        List<Integer> res=new ArrayList<>();
        dfs(num,visit,res,"");
        Collections.sort(res);
        System.out.println(res.get(k-1));

    }

    private static void dfs(String num, int[] visit, List<Integer> res, String one) {
        if (one.length() == num.length()) {
            res.add(Integer.parseInt(one));
            return;
        }
        for (int i = 0; i < num.length(); i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                dfs(num, visit, res, one + num.charAt(i));
                visit[i] = 0;
            }
        }
    }
}