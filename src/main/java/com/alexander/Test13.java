package com.alexander;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Test13 {
    public ListNode FindKthToTail(ListNode head, int k) {
        //边界条件处理
        if (head == null)
            return null;
        if(k == 0)
            return null;

        ListNode l1 = head;
        ListNode l2 = head;

        for (int i = 0; i < k - 1; i++) {
            if (l2.next != null)
                l2 = l2.next;
            else return null;//处理链表长度小于k的情况
        }

        while(l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }
}
