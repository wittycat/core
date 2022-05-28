package com.core.algorithm.nowcoder面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/10 7:14 PM
 * Description:
 */
public class BM2链表内指定区间反转 {


    /**
     * 12/20 组用例通过
     * @param args
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next=listNode2;

        ListNode listNode = reverseBetween(listNode1, 1, 2);
        System.out.println(listNode);
    }
    /**
    *
    * @param head ListNode类
    * @param m int整型
    * @param n int整型
    * @return ListNode类
    */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        ListNode cur = head;
        ListNode son = null;
        ListNode firstson = null;
        int index = 0;
        while (cur!=null){
            ListNode post=cur.next;
            index++;
            if(index>=m&&index<=n){
                cur.next= son;
                son = cur;
                if(index==m){
                    firstson =cur;
                }
            }else {
                if(son!=null){
                    temp.next=son;
                    firstson.next=cur;
                }else{
                    temp.next = cur;
                }
                temp = cur;
            }
            cur=post;
        }
        if(res.next==null){
            return son;
        }
        return res.next;
    }
}