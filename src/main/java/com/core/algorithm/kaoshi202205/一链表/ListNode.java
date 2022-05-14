package com.core.algorithm.kaoshi202205.一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/11 4:17 PM
 * Description:
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "["+val+"]";
    }
}