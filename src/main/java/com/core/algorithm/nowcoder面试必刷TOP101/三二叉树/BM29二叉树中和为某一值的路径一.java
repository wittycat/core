package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

/**
 * Created by chenxun.
 * Date: 2022/5/16 3:08 PM
 * Description:
 */
public class BM29二叉树中和为某一值的路径一 {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {


        boolean flag = exist(root,sum);

        return flag;
    }

    private boolean exist(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && (root.val - sum) == 0) {
            return true;
        }
        return exist(root.left, sum - root.val) || exist(root.right, sum - root.val);
    }
}