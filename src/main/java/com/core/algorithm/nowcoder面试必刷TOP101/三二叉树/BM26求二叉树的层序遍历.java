package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by chenxun.
 * Date: 2022/5/16 2:38 PM
 * Description:
 */
public class BM26求二叉树的层序遍历 {

    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);

        treeNode.left.left=new TreeNode(4);
        treeNode.left.right=new TreeNode(5);

        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(7);

        levelOrder(treeNode);

    }

    public static ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> total = new ArrayList();
        if(root==null){
            return total;
        }
        Deque<TreeNode> arrayDeque = new ArrayDeque();
        arrayDeque.add(root);
        while (!arrayDeque.isEmpty()){
            int size = arrayDeque.size();
            ArrayList<Integer> row = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode poll = arrayDeque.poll();
                row.add(poll.val);
                if(poll.left!=null){
                    arrayDeque.add(poll.left);
                }
                if(poll.right!=null){
                    arrayDeque.add(poll.right);
                }
            }
            total.add(row);
        }
        return total;
    }
}