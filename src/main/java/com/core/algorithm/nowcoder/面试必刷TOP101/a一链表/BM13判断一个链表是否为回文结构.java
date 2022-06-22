package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

import java.util.ArrayList;

/**
 * Created by chenxun.
 * Date: 2022/5/31 5:47 PM
 * Description:
 */
public class BM13判断一个链表是否为回文结构 {
    public boolean isPail (ListNode head) {
        if (head == null) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList();

        ListNode index = head;
        while (index != null) {
            list.add(index.val);
            index = index.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}