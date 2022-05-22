package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2022/5/16 10:34 PM
 * Description:
 */
public class BM34判断是不是二叉搜索树 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST (TreeNode root) {
        if(root==null){
            return true;
        }else {
            return judje(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
    }

    private boolean judje(TreeNode root, int min, int max) {
        if(root==null){
            return false;
        }
        if(root.val<=min || root.val>=max){
            return false;
        }
        return judje(root.left,min,root.val) && judje(root.right,root.val,max);
    }

    /**
     * 方法二
     * @param root
     * @return
     */
    public boolean isValidBST2 (TreeNode root) {
        int[] ints = inorderTraversal(root);
        if(ints==null||ints.length<2){
            return true;
        }else {
            for (int i = 0; i < ints.length-1 ; i++) {
                if(ints[i]>ints[i+1]){
                    return false;
                }
            }
        }
        return true;
    }


    private int[] inorderTraversal (TreeNode root) {
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
        list.add(root.val);

        if(root.right!=null){
            getData(root.right,list);
        }
    }
}