package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

/**
 * Created by chenxun.
 * Date: 2022/5/20 7:22 PM
 * Description:
 */
public class BM31对称的二叉树 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return judge(pRoot.left, pRoot.right);
    }

    private boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || right.val != left.val) {
            return false;
        }
        return judge(left.left, right.right) && judge(left.right, right.left);
    }
}