package com.core.algorithm.nowcoder.面试必刷TOP101.c三二叉树;

import java.util.Arrays;

/**
 * Created by chenxun.
 * Date: 2022/5/19 8:30 PM
 * Description:
 */
public class BM40重建二叉树 {
    /**
     * 对于二叉树的前序遍历，我们知道序列的第一个元素必定是根节点的值，因为序列没有重复的元素，因此中序遍历中可以找到相同的这个元素，
     * 而我们又知道中序遍历中根节点将二叉树分成了左右子树两个部分，
     */
    public static TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        int root = pre[0];
        if (pre.length == 1) {
            return new TreeNode(root);
        }

        int binarySearch = 0;
        for (int i = 0; i < vin.length; i++) {
            if (vin[i] == root) {
                binarySearch = i;
                break;
            }
        }

        int[] vin_left = Arrays.copyOfRange(vin, 0, binarySearch);
        int[] vin_right = Arrays.copyOfRange(vin, binarySearch + 1, vin.length);

        int[] pre_left = Arrays.copyOfRange(pre, 1, binarySearch + 1);
        int[] pre_right = Arrays.copyOfRange(pre, vin_left.length + 1, pre.length);


        TreeNode treeNode = new TreeNode(root);
        treeNode.left = reConstructBinaryTree(pre_left, vin_left);
        treeNode.right = reConstructBinaryTree(pre_right, vin_right);
        return treeNode;
    }

    public static void main(String[] args) {
        int [] pre= {1,2,3,4};
        int [] vin= {4,3,2,1};
        TreeNode build = reConstructBinaryTree(pre, vin);
        System.out.println(build);
    }
}