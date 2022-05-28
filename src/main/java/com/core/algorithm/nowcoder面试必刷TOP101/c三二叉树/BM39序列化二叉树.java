package com.core.algorithm.nowcoder面试必刷TOP101.c三二叉树;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenxun.
 * Date: 2022/5/18 12:51 PM
 * Description:
 */
public class BM39序列化二叉树 {

    /**
     * 整数的两倍不超过 0x7f7f7f7f，则int表示的最大正整数。
     * 当你需要吧一个数组中的数值初始化成正无穷大时就需要用0x3f3f3f3f数值代替，避免加法算数溢出。
     */
    static int VALUE = 0x3f3f3f3f;
    static String flag = "#";
    static TreeNode emptyNode = new TreeNode(VALUE);

    static String Serialize(TreeNode root) {
        StringBuffer sb = new  StringBuffer();
        if(root==null){
            sb.append(flag);
            return sb.toString();
        }

        int deep= getDeep(root);

        Queue<TreeNode> arrayQueue = new ArrayDeque<>();
        arrayQueue.add(root);

        for (int j = 0; j < deep; j++){
            int size = arrayQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = arrayQueue.poll();
                if(poll.val != VALUE){
                    sb.append(poll.val+",");
                }else {
                    sb.append(flag+",");
                }
                arrayQueue.add(poll.left!=null?poll.left:emptyNode);
                arrayQueue.add(poll.right!=null?poll.right:emptyNode);
            }
        }
        return sb.subSequence(0,sb.length()-1).toString();
    }

    private static int getDeep(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(getDeep(root.left),getDeep(root.right))+1;
    }

    static TreeNode Deserialize(String str) {
        if (str.equals(flag)) {
            return null;
        }
        String[] datas = str.split(",");

        Deque<TreeNode> arrayQueue = new LinkedList();
        TreeNode root = new TreeNode(parseInta(datas[0]));
        arrayQueue.add(root);
        int index = 1;
        while ( (index + arrayQueue.size()-1) * 2  < datas.length) {
            int size = arrayQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = arrayQueue.poll();

                TreeNode left = new TreeNode(parseInta(datas[(index+i) * 2 - 1]));
                TreeNode right = new TreeNode(parseInta(datas[(index+i) * 2]));

                if (poll.val != VALUE && left.val != VALUE) {
                    poll.left = left;
                }
                if (poll.val != VALUE && right.val != VALUE) {
                    poll.right = right;
                }
                arrayQueue.add(left);
                arrayQueue.add(right);
            }
            index = index * 2;
        }
        return root;
    }

    private static int parseInta(String data) {
         if(data.equals("#")){
             return VALUE;
         }else {
             return Integer.parseInt(data);
         }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.left.left=new TreeNode(3);
        treeNode.left.left.left=new TreeNode(2);

        String serialize = Serialize(treeNode);

        TreeNode deserialize = Deserialize(serialize);

    }
}