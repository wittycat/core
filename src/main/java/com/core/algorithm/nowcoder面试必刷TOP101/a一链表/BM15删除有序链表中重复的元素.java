package com.core.algorithm.nowcoder面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/31 9:14 PM
 * Description:
 */
public class BM15删除有序链表中重复的元素 {
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
        if(head==null){
            return head;
        }
        ListNode index = head;
        while (index.next!=null){
            if(index.val==index.next.val){
                index.next=index.next.next;
            }else {
                index=index.next;
            }
        }
        return head;
    }
}