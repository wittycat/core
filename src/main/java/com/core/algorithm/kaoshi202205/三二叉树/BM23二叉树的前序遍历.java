package com.core.algorithm.kaoshi202205.三二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2022/5/16 11:10 AM
 * Description:
 */
public class BM23二叉树的前序遍历 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal (TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        getData(root,list);

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i]=list.get(i);
        }
        return ints;
    }

    private void getData(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);

        if(root.left!=null){
            getData(root.left,list);
        }

        if(root.right!=null){
            getData(root.right,list);
        }
    }
}