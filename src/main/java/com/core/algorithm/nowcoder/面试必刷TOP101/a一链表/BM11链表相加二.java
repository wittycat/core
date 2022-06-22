package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

import java.util.ArrayList;

/**
 * Created by chenxun.
 * Date: 2022/5/31 5:55 PM
 * Description:
 */
public class BM11链表相加二 {
    public static ListNode addInList (ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        int[] change1 = change(head1);
        int[] change2 = change(head2);
        int max = Math.max(change1.length, change2.length);
        change1 = copyOfArr(change1, max);
        change2 = copyOfArr(change2, max);

        int[] sumArr = new int[max + 1];

        int high = 0;
        for (int i = max - 1; i > -1; i--) {
            int sum = change1[i] + change2[i] + high;
            high = sum / 10;
            int value = sum % 10;
            sumArr[i + 1] = value;
        }
        if (high != 0) {
            sumArr[0] = high;
        }

        ListNode head = new ListNode(0);
        if (sumArr[0] > 0) {
            head.next = new ListNode(sumArr[0]);
        }
        ListNode index = head.next != null ? head.next : head;
        for (int i = 1; i < sumArr.length; i++) {
            ListNode node = new ListNode(sumArr[i]);
            index.next = node;
            index = node;
        }
        return head.next;
    }

    private static int[] copyOfArr(int[] change1, int max) {
        int[] ints = new int[max];
        int j = ints.length-1;
        for (int i = change1.length - 1; i > -1; i--) {
            ints[j] = change1[i];
            j--;
        }
        return ints;
    }

    private static int[] change(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList();
        ListNode index = head;
        while (index != null) {
            list.add(index.val);
            index = index.next;
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        //937
        //63
        ListNode head = new ListNode(9);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(7);
        head.next = head2;
        head2.next = head3;

        ListNode head4 = new ListNode(6);
        ListNode head5 = new ListNode(3);
        head4.next = head5;

        ListNode listNode = addInList(head, head4);
        System.out.println(listNode);
    }
}