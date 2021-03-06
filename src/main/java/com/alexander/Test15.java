package com.alexander;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Test15 {
    public static ListNode FindKthToTail(ListNode head, int k) {
        //边界条件处理
        if (head == null)
            return null;
        if (k == 0)
            return null;

        ListNode l1 = head;
        ListNode l2 = head;

        for (int i = 0; i < k - 1; i++) {
            if (l2.next != null)
                l2 = l2.next;
            else return null;//处理链表长度小于k的情况
        }

        while (l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        return l1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        for (int i = 1; i < 10; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode listNode2 = null;

        for (ListNode listNode3 = head;  listNode3 != null ; listNode3 = listNode3.next) {
            System.out.print(listNode3.val + " ");
        }
        System.out.println();
        listNode = FindKthToTail(head, 4);
        System.out.println(listNode.val);
        System.out.println(FindKthToTail(head, 20));
        System.out.println(FindKthToTail(head, 0));
        System.out.println(FindKthToTail(listNode2, 1));
    }
}
