package com.core.algorithm.kaoshi202205.三二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * Created by chenxun.
 * Date: 2022/5/16 3:03 PM
 * Description:
 */
public class BM27按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> total = new ArrayList();
        if(pRoot==null){
            return total;
        }
        Deque<TreeNode> arrayDeque = new ArrayDeque();
        arrayDeque.add(pRoot);
        boolean flag=true;
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
            if(flag){
                total.add(row);
                flag = false;
            }else {
                Collections.reverse(row);
                total.add(row);
                flag = true;
            }

        }
        return total;
    }
}