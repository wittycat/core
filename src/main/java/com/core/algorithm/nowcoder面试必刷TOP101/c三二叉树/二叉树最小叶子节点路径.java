package com.core.algorithm.nowcoder面试必刷TOP101.c三二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by chenxun.
 * Date: 2022/5/23 10:34 AM
 * Description:
 */
public class 二叉树最小叶子节点路径 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left=new TreeNode(5);
        treeNode.right=new TreeNode(7);


        treeNode.right.left=new TreeNode(2);
        treeNode.right.right=new TreeNode(4);

        printAllPath(treeNode);

    }

    public static void printAllPath (TreeNode root) {

        TreeSet<Integer> all = new TreeSet();
        getAllSon(root,all);
        System.out.println(all);

        List<Integer> minPath = getMinPath(root, all.pollFirst());
        Collections.reverse(minPath);
        System.out.println(minPath.toString());


    }

    private static List<Integer> getMinPath(TreeNode root, Integer min) {
        if(root==null){
            return null;
        }
        if(root.val==min){
            List<Integer> list = new ArrayList<>();
            list.add(min);
            return list;
        }
        List<Integer> minPath = getMinPath(root.left, min);
        if(minPath!=null){
            minPath.add(root.val);
        }
        List<Integer> minPath2 = getMinPath(root.right, min);
        if(minPath2!=null){
            minPath2.add(root.val);
        }
        return minPath!=null?minPath:minPath2;
    }

    private static void getAllSon(TreeNode root, TreeSet<Integer> all) {
        if(root==null){
            return ;
        }

        if(root.left==null&&root.right==null){
            all.add(root.val);
            return;
        }
        getAllSon(root.left,all);
        getAllSon(root.right,all);
    }
}