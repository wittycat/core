package com.core.algorithm.nowcoder面试必刷TOP101.一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/10 8:28 PM
 * Description:
 */
public class BM4合并两个排序的链表 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        //最终不返回第一个
        ListNode dummy = new ListNode(-1);
        //记录头结点
        ListNode res = dummy;
        // 必须保证两个list都不为空
        while(list1 != null & list2 != null) {
            if(list1.val > list2.val) {
                dummy.next = list2;
                list2 = list2.next;
                dummy = dummy.next;
            } else if(list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
                dummy = dummy.next;
            }
        }
        // list1后面还有，就把剩下的全部拿走
        if(list1 != null) {
            dummy.next = list1;
        }
        if(list2 != null) {
            dummy.next = list2;
        }
        return res.next;
    }
}