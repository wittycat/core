package com.core.algorithm.nowcoder面试必刷TOP101.f六递归回溯;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/29 10:23 PM
 * Description:
 */
public class BM55没有重复项数字的全排列 {

//    public static ArrayList<ArrayList<Integer>> permute1(int[] num) {
//        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
//        getPermute(result,num,0);
//        return result;
//    }
//    public static  void getPermute(ArrayList<ArrayList<Integer>> result, int[] num, int start) {
//        if (start == num.length - 1) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int i = 0; i < num.length; i++) {
//                list.add(num[i]);
//            }
//            result.add(list);
//        } else {
//            for (int i = start; i < num.length; i++) {
//                swap(num, i, start);
//                getPermute(result, num, start + 1);
//                swap(num, i, start);
//            }
//        }
//
//    }
//    public static void swap(int[] nums,int i,int j) {
//        int temp;
//        temp=nums[i];
//        nums[i]=nums[j];
//        nums[j]=temp;
//    }
//

//
//    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
//    static ArrayList<Integer> ls = new ArrayList<>();
//    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
//        int[] used = new int[num.length];
//        dfs(num,used);
//        return res;
//    }
//    private static void dfs(int[] a,int[] used) {
//        if (ls.size() == a.length) {
//            res.add(new ArrayList<>(ls));
//            return;
//        }
//        for (int i = 0; i < a.length; i++) {
//            if (used[i] == 1) {
//                continue;
//            }
//            used[i] = 1;
//            ls.add(a[i]);
//            dfs(a, used);
//            used[i] = 0;
//            ls.remove(ls.size() - 1);
//        }
//    }

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
                System.out.println(temp.toString()+"++"+ Arrays.toString(visit));
                dfs(num, res, temp, visit);
                System.out.println(temp.toString()+"--"+ Arrays.toString(visit));
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