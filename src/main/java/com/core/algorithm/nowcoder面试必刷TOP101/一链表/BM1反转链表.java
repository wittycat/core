package com.core.algorithm.nowcoder面试必刷TOP101.一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/10 5:39 PM
 * Description:
 */
public class BM1反转链表 {

    /**
     * 思路一：使用栈   Stack<ListNode> stack= new Stack<>(); 进栈，出栈
     * 思路二：双链表求解是把原链表的结点一个个摘掉，每次摘掉的链表都让他成为新的链表的头结点，然后更新新链表。下面以链表1→2→3→4为例画个图来看下。
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode res = null;
        while (head!=null){
            ListNode post = head.next;
            head.next=res;
            res=head;
            head = post;
        }
        return res;
    }
}