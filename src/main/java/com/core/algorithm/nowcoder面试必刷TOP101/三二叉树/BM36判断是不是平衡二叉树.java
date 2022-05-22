package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

/**
 * Created by chenxun.
 * Date: 2022/5/18 11:55 AM
 * Description:
 */
public class BM36判断是不是平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        /**
         * 左右两个子树的高度差的绝对值不超过1
         * 左右两个子树都是一棵平衡二叉树
         */


        int lefth = deep(root.left);
        int righth = deep(root.right);
        //左右两个子树的高度差的绝对值不超过1              //左右两个子树都是一棵平衡二叉树
        return Math.abs(lefth-righth)<2 && IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.left);
    }

    private int deep(TreeNode treeNode) {
        if(treeNode==null){
            return 0;
        }
        return Math.max(deep(treeNode.left),deep(treeNode.right))+1;
    }
}