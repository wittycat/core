package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/10 7:14 PM
 * Description:
 */
public class BM2链表内指定区间反转 {


    /**
    *
    * @param head ListNode类
    * @param m int整型
    * @param n int整型
    * @return ListNode类
    */
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == n) {
            return head;
        }
        ListNode my = new ListNode(0);
        ListNode myIndex = my;

        ListNode son = new ListNode(0);
        ListNode index = head;

        int i = 1;
        boolean headadd = false;
        ListNode midLast = null;
        while (index != null) {
            ListNode cur = index;
            index=index.next;
            if(i<m){
                myIndex.next=cur;
                myIndex=cur;
            }else if (i >= m && i <= n) {
                if(i==m&&i==1){
                    myIndex=cur;
                    headadd=true;
                }
                if(i==m){
                    midLast=cur;
                }
                cur.next=null;
                ListNode next = son.next;
                cur.next=next;
                son.next=cur;
                if(i==n){
                    if(headadd){
                        my.next=son.next;
                    }else {
                        myIndex.next=son.next;
                    }
                    myIndex=midLast;
                }
            }else {
                myIndex.next=cur;
                myIndex=cur;
            }
            i++;
        }
        return my.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        ListNode listNode = reverseBetween(head1, 2,5);
        System.out.println(listNode);
    }
}