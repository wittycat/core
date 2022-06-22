package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/31 9:20 PM
 * Description:
 */
public class BM9删除链表的倒数第n个节点 {
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (n == 1 && fast == null) {
            return null;
        }
        ListNode pre = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(pre==null){
            return slow.next;
        }
        pre.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head0 = new ListNode(0);
        ListNode head1 = new ListNode(2);
        head0.next=head1;

        ListNode listNode = removeNthFromEnd(head0, 2);
        System.out.println(listNode);
    }
}