package com.core.algorithm.nowcoder面试必刷TOP101.c三二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by chenxun.
 * Date: 2022/5/16 3:02 PM
 * Description:
 */
public class BM28二叉树的最大深度 {

    /**
     * 方法一
     * @param root
     * @return
     */
    public int maxDepth (TreeNode root) {
        if(root==null){
            return 0;
        }
        int max = Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
        return max;
    }

    /**
     * 方法二
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth2 (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> total = new ArrayList();
        if(root==null){
            return total.size();
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
        return total.size();
    }
}