package com.alexander;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */

public class Test16 {
    public static ListNode reverseList(ListNode head) {
        //边界条件判断
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        Stack<ListNode> stack = new Stack<>();
        for (ListNode listNode = head; listNode != null; listNode = listNode.next) {
            stack.push(listNode);
        }
        ListNode newHead = stack.pop();
        ListNode listNode1 = newHead;
        for (; !stack.isEmpty(); listNode1 = stack.pop()) {
            listNode1.next = stack.peek();
        }
        listNode1.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        for (int i = 1; i < 20; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        for (ListNode listNode1 = head; listNode1 != null; listNode1 = listNode1.next) {
            System.out.print(listNode1.val + " ");
        }
        System.out.println();
        listNode = reverseList(head);
        for (ListNode listNode1 = listNode; listNode1 != null; listNode1 = listNode1.next) {
            System.out.print(listNode1.val + " ");
        }

        //边界条件测试
        ListNode listNodeNull = null;
        ListNode listNodeSingle = new ListNode(100);

        System.out.println();

        listNodeNull = reverseList(listNodeNull);
        System.out.println(listNodeNull == null);

        listNodeSingle = reverseList(listNodeSingle);
        System.out.println(listNodeSingle.val);

    }
}