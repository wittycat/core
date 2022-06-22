package com.core.algorithm.nowcoder.面试必刷TOP101.a一链表;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxun.
 * Date: 2022/6/1 7:51 PM
 * Description:
 */
public class BM10两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null){
            return null;
        }
        List list = new ArrayList();
        ListNode index1=pHead1;
        while (index1!=null){
            list.add(index1);
            index1=index1.next;
        }
        ListNode index2=pHead2;
        while (index2!=null){
            if(list.contains(index2)){
                return index2;
            }
            index2=index2.next;
        }
        return null;
    }
}