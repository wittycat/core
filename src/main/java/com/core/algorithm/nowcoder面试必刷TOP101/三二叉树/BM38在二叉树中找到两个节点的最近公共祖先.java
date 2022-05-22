package com.core.algorithm.nowcoder面试必刷TOP101.三二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2022/5/20 3:13 PM
 * Description:
 */
public class BM38在二叉树中找到两个节点的最近公共祖先 {
    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public static int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        List<Integer> listo1 = new ArrayList<>();
        getPath(root, o1,listo1);
        find = false;
        List<Integer> listo2 = new ArrayList();
        getPath(root, o2, listo2);
        int min = Math.min(listo1.size(), listo2.size());
        int lastIndex = 0;
        for (int i = 0; i < min; i++) {
            if(listo1.get(i).equals(listo2.get(i))){
                lastIndex= i;
            }
        }
        return listo1.get(lastIndex);
    }

    static boolean find = false;
    private static void getPath(TreeNode root, int o, List<Integer> list) {
        if (root == null) {
            return ;
        }
        list.add(root.val);
        if (root.val == o) {
            find = true;
            return;
        }

        getPath(root.left, o, list);
        if(!find){
            getPath(root.right, o, list);
        }

        if(find){
            return;
        }else {
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode (1);
        treeNode.right=new TreeNode (2);
        treeNode.right.left=new TreeNode (3);
        treeNode.right.left.left=new TreeNode (4);

        treeNode.left=new TreeNode (22);
        treeNode.left.left=new TreeNode (222);
        int i = lowestCommonAncestor(treeNode, 222, 4);
        System.out.println(i);
    }
}