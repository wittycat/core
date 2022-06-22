package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/6/1 9:49 AM
 * Description:
 */
public class BM16删除有序链表中重复的元素II {
    public static ListNode deleteDuplicates (ListNode head) {
        ListNode myhead = new ListNode(-1);
        myhead.next = head;
        //不同节点连接点
        ListNode pre = myhead;
        //链表指针
        ListNode index = head;
        while (index != null && index.next != null) {
            if (index.val == index.next.val) {
                int same = index.next.val;
                index = index.next;
                //跳过所有相同的
                while (index != null && index.val == same) {
                    index = index.next;
                }
                //只去掉相同的， 连接点位置不变（因为加入连接点位置变了，可能就无法完全移除接下来相同的了，比如：111112222）
                pre.next = index;
            } else {
                //连接点位置更新
                pre=index;
                index = index.next;
            }
        }
        return myhead.next;
    }

    public static void main(String[] args) {
        ListNode head0 = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(2);
        head0.next=head1;
        head1.next=head2;
        ListNode listNode = deleteDuplicates(head0);
    }
}