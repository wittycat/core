package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chenxun.
 * Date: 2022/6/2 1:05 AM
 * Description:
 */
public class BM5合并k个已排序的链表 {
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        PriorityQueue<ListNode> objects = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.size(); i++) {
            ListNode listNode1 = lists.get(i);
            ListNode index = listNode1;
            while (index != null) {
                objects.add(index);
                index = index.next;
            }
        }

        ListNode my = new ListNode(0);
        ListNode index = my;
        while (objects.peek() != null) {
            ListNode poll = objects.poll();
            index.next = poll;
            index = poll;
        }
        return my.next;
    }



    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head1.next = head4;
        head4.next = head5;

        ListNode head0 = new ListNode(0);
        ListNode head2 = new ListNode(2);
        head0.next = head2;

        ArrayList<ListNode> list = new ArrayList();
        list.add(head1);
        list.add(head0);

        ListNode listNode = mergeKLists(list);
        System.out.println(listNode);
    }
}