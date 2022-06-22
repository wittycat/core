package com.core.algorithm.nowcoder.面试必刷TOP101.f六递归回溯;

import java.util.ArrayList;

/**
 * Created by chenxun.
 * Date: 2022/5/29 10:23 PM
 * Description:
 */
public class BM55没有重复项数字的全排列 {

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> temp = new ArrayList();
        int[] visit = new int[num.length];
        dfs(num, res, temp, visit);
        return res;
    }

    private static void dfs(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] visit) {
        if (temp.size() == num.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int j = 0; j < num.length; j++) {
                if (visit[j] == 1) {
                    continue;
                }
                temp.add(num[j]);
                visit[j] = 1;
                dfs(num, res, temp, visit);
                visit[j] = 0;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array={1,2,3};
        ArrayList<ArrayList<Integer>> permute = permute(array);
        System.out.println(permute);
    }

















}