package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

/**
 * Created by chenxun.
 * Date: 2022/5/16 9:58 PM
 * Description:
 */
public class BM33二叉树的镜像 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        TreeNode treeNode=createMirror(pRoot);
        return treeNode;
    }

    private TreeNode createMirror(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode treeNode = new  TreeNode(root.val);
        treeNode.left=createMirror(root.right);
        treeNode.right=createMirror(root.left);
        return treeNode;
    }
}