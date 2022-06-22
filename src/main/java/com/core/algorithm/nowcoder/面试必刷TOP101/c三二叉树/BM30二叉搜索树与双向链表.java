package com.core.algorithm.nowcoder.面试必刷TOP101.c三二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2022/5/20 7:39 PM
 * Description:
 */
public class BM30二叉搜索树与双向链表 {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }


        List<TreeNode> treeNodes = inorderTraversal(pRootOfTree);
        if(treeNodes.size()==1){
            return treeNodes.get(0);
        }
        treeNodes.get(0).left=null;
        treeNodes.get(0).right=null;

        treeNodes.get(treeNodes.size()-1).left=null;
        treeNodes.get(treeNodes.size()-1).right=null;

        for (int i = 0; i < treeNodes.size(); i++) {
            if(i>0){
                TreeNode treeNode0 = treeNodes.get(i-1);
                TreeNode treeNode1 = treeNodes.get(i);
                treeNode0.right=treeNode1;
                treeNode1.left=treeNode0;
            }
        }

        return treeNodes.get(0);

    }

    public List<TreeNode> inorderTraversal (TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        getData(root,list);
        return list;
    }

    private void getData(TreeNode root, List<TreeNode> list) {
        if(root==null){
            return;
        }

        if(root.left!=null){
            getData(root.left,list);
        }
        list.add(root);

        if(root.right!=null){
            getData(root.right,list);
        }
    }
}