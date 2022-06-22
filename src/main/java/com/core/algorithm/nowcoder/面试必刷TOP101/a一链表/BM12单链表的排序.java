package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/31 9:58 PM
 * Description:
 */
public class BM12单链表的排序 {
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        return splitListNode(head);

    }


    private static ListNode splitListNode(ListNode head) {
        //终止条件
        if (head == null || head.next == null) {
            return head;
        }

        //切分  2个指针不在同一个位置 比如 1 2 3 4 ,如果相同 就成了 1 2 3 ， 4
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;

        //继续切分
        ListNode leftUnit = splitListNode(left);
        ListNode rightUnit = splitListNode(right);
        //归并
        return mergeSort(leftUnit, rightUnit);
    }

    private static ListNode mergeSort(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        //把最后尾巴拼接上
        head.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(6);
        ListNode head3 = new ListNode(9);
        ListNode head4 = new ListNode(6);
        ListNode head5 = new ListNode(8);
        ListNode head99 = new ListNode(99);
        ListNode head0 = new ListNode(0);

        head3.next = head1;
        head1.next = head2;
        head2.next = head5;
        head5.next = head4;
        head4.next = head99;
        head99.next = head0;

        ListNode listNode = splitListNode(head3);
        System.out.println(listNode);
    }
}