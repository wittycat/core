package com.core.algorithm.kaoshi202205.三二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2022/5/16 11:24 AM
 * Description:
 */
public class BM25二叉树的后序遍历 {

    public int[] postorderTraversal (TreeNode root) {
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

        if(root.left!=null){
            getData(root.left,list);
        }
        if(root.right!=null){
            getData(root.right,list);
        }
        list.add(root.val);
    }
}