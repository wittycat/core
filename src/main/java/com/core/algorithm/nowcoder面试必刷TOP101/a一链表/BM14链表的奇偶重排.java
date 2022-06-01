package com.core.algorithm.nowcoder面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/6/1 7:02 PM
 * Description:
 */
public class BM14链表的奇偶重排 {
    public static ListNode oddEvenList (ListNode head) {
        ListNode head1=new ListNode(1);
        ListNode head2=new ListNode(2);

        ListNode head1Index=head1;
        ListNode head2Index=head2;

        ListNode index = head;
        int i = 1;
        while (index!=null){
            if(i%2==1){
                head1Index.next=index;
                head1Index=index;
            }else {
                head2Index.next=index;
                head2Index=index;
            }
            index=index.next;
            i++;
        }
        head1Index.next=null;
        head2Index.next=null;

        if(head1.next!=null){
            head1Index.next=head2.next;
            return head1.next;
        }else {
            return head2.next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head6 = new ListNode(6);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;

        ListNode listNode = oddEvenList(head6);
        System.out.println(listNode);
    }
}