package com.core.algorithm.nowcoder面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/6/2 12:00 AM
 * Description:
 */
public class BM8链表中倒数最后k个结点 {
    public static ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead == null || k == 0) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;

        for (int i = 0; i < k; i++) {
            if (i < (k - 1) && fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        if(fast==null){
            return slow;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.next;
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode listNode = FindKthToTail(head1, 5);
        System.out.println("");
    }
}