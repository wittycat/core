package com.core.algorithm.nowcoder.面试必刷TOP101.c三二叉树;

/**
 * Created by chenxun.
 * Date: 2022/5/16 5:28 PM
 * Description:
 */
public class BM32合并二叉树 {
    /**
     *
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        TreeNode  treeNode= mergeTree(t1,t2);
        return treeNode;
    }

    private TreeNode mergeTree(TreeNode t1, TreeNode t2) {
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }

        int sum = t1.val+t2.val;
        TreeNode root = new TreeNode(sum);

        TreeNode left = mergeTree(t1.left, t2.left);
        TreeNode right = mergeTree(t1.right, t2.right);
        root.left = left;
        root.right = right;
        return root;
    }
}