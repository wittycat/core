package com.core.algorithm.nowcoder面试必刷TOP101.一链表;

/**
 * Created by chenxun.
 * Date: 2022/5/11 4:16 PM
 * Description:
 * 我们都知道链表不像二叉树，每个节点只有一个val值和一个next指针，也就是说一个节点只能有一个指针指向下一个节点，
 * 不能有两个指针，那这时我们就可以说一个性质：环形链表的环一定在末尾，末尾没有NULL了。
 *
 * 具体做法：
 *
 * step 1：设置快慢两个指针，初始都指向链表头。
 * step 2：遍历链表，快指针每次走两步，慢指针每次走一步。
 * step 3：如果快指针到了链表末尾，说明没有环，因为它每次走两步，所以要验证连续两步是否为NULL。
 * step 4：如果链表有环，那快慢双指针会在环内循环，因为快指针每次走两步，因此快指针会在环内追到慢指针，二者相遇就代表有环。
 */
public class BM6判断链表中是否有环 {

    public boolean hasCycle(ListNode head) {

        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
}