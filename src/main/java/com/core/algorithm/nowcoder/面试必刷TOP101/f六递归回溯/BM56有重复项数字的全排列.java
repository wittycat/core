package com.core.algorithm.nowcoder.面试必刷TOP101.f六递归回溯;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/31 1:24 AM
 * Description:
 */
public class BM56有重复项数字的全排列 {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
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
                ////当前的元素num[i]与同一层的前一个元素num[i-1]相同且num[i-1]已经用过了
                if (j > 0 && num[j] == num[j - 1] && visit[j - 1] == 1) {
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
        int[] array={1,1,2,1};
        ArrayList<ArrayList<Integer>> permute = permuteUnique(array);
        System.out.println(permute);
    }
}