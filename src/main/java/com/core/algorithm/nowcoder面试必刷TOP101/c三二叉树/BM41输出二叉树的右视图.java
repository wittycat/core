package com.core.algorithm.nowcoder面试必刷TOP101.c三二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * Created by chenxun.
 * Date: 2022/5/20 2:09 PM
 * Description:
 */
public class BM41输出二叉树的右视图 {

    public static int[] solve (int[] xianxu, int[] zhongxu) {
        if(xianxu==null||xianxu.length==0){
            return null;
        }
        if(xianxu.length==1){
            return xianxu;
        }
        TreeNode treeNode = reConstructBinaryTree(xianxu, zhongxu);

        ArrayList<ArrayList<Integer>> all = new ArrayList();
        Deque<TreeNode> deque = new ArrayDeque();
        deque.add(treeNode);
        while (!deque.isEmpty()){

            int size = deque.size();
            ArrayList<Integer> row = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode root = deque.poll();
                row.add(root.val);
                if(root.left!=null){
                    deque.add(root.left);
                }
                if(root.right!=null){
                    deque.add(root.right);
                }
            }
            all.add(row);
        }

        int[] res = new int[all.size()];
        for (int i = 0; i < all.size() ; i++) {
            res[i]= all.get(i).get(all.get(i).size()-1);
        }
        return res;
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
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
        int [] pre= {1,2,4,5,3};
        int [] vin= {4,2,5,1,3};
        int[] solve = solve(pre, vin);
        System.out.println(Arrays.toString(solve));
    }
}