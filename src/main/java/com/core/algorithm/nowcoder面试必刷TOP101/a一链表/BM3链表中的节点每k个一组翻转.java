package com.core.algorithm.nowcoder面试必刷TOP101.a一链表;

/**
 * Created by chenxun.
 * Date: 2022/6/1 8:04 PM
 * Description:
 */
public class BM3链表中的节点每k个一组翻转 {
    public static ListNode reverseKGroup (ListNode head, int k) {
        ListNode total = new ListNode(0) ;
        ListNode total1Index = null ;
        ListNode total2Index = null ;

        ListNode item = new ListNode(0) ;

        ListNode last=null;
        ListNode lastlast=null;

        ListNode index = head;
        int i = k;
        while (index!=null){
            ListNode temp =index;
            if(i==k){
                lastlast=last;
                last = temp;
                total1Index=index;
            }
            if(i==-k){
                lastlast=last;
                last = temp;
                total2Index=index;
            }

            index=index.next;
            temp.next=null;

            temp.next=item.next;
            item.next=temp;

            if(i>0){
                i--;
                if(i==0){
                    i=-k;
                    if(total.next==null){
                        total.next=item.next;
                        item.next=null;
                    }else {
                        total2Index.next=item.next;
                        item.next=null;
                    }
                }
            }else {
                i++;
                if(i==0){
                    total1Index.next=item.next;
                    item.next=null;
                    i=k;
                }
            }
        }

        if(item.next!=null){
            ListNode listNode = new ListNode(1) ;
            ListNode next = item.next;
            while (next!=null){
                ListNode pre = next;
                next=next.next;

                ListNode temp = listNode.next;
                pre.next=temp;
                listNode.next=pre;
            }

            if(total.next==null){
                total.next=listNode.next;
            }else {
                lastlast.next=listNode.next;
            }
        }
       return total.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode listNode = reverseKGroup(head1, 3);
        System.out.println("");
    }
}