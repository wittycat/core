package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenxun.
 * Date: 2022/5/17 11:43 AM
 * Description:
 */
public class BM35判断是不是完全二叉树 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @return bool布尔型
     */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);

        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(5);

        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(7);

        isCompleteTree(treeNode);

    }

    /**
     * 思路：
     *
     * 由于完全二叉树在每一层非空节点都是一个接一个连续分布的，不可能出现两个非空节点之间交叉一个空节点。
     *
     * 通过层序遍历从上往下，从左往右将每一个节点（包括非空节点）都放到队列里
     * 在出队列的过程中，如果遇到空节点，则跳出循环
     * 跳出循环后，然后再判断队列中剩下的元素是否有非空节点：
     * 有非空节点：非完全二叉树；
     * 没有非空节点（全是空节点）：完全二叉树。
     * @param root
     * @return
     */
    public static boolean isCompleteTree (TreeNode root) {
        if (root == null) {
            return false;
        }
        Deque<TreeNode> arrayDeque = new LinkedList();
        arrayDeque.add(root);
        boolean flag= true;
        while (!arrayDeque.isEmpty()) {
            TreeNode temproot = arrayDeque.poll();
            if(temproot==null){
                flag = false;
                continue;
            }
            if(temproot!=null&&!flag){
                return false;
            }

            arrayDeque.add(temproot.left);
            arrayDeque.add(temproot.right);
        }
        return true;
    }
}