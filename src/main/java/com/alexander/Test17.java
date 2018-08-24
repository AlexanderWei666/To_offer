package com.alexander;

import java.util.Stack;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

public class Test17 {
    public static ListNode merge(ListNode list1, ListNode list2) {
        //边界条件处理
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else if (list1 == null) {
            return list2;
        }

        Stack<ListNode> stack1 = new Stack<>();
        for (ListNode listNode = list1; listNode != null; listNode = listNode.next) {
            stack1.push(listNode);
        }
        Stack<ListNode> stack2 = new Stack<>();
        for (ListNode listNode = list2; listNode != null; listNode = listNode.next) {
            stack2.push(listNode);
        }

        ListNode lna = stack1.pop();
        ListNode lnb = stack2.pop();
        //判断头结点，哪个栈先空，头结点就是另外一个表头
        boolean list1IsHead = false;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (lna.val <= lnb.val) {
                lna.next = lnb;
                lnb = stack2.pop();
                list1IsHead = true;
            } else {
                lnb.next = lna;
                lna = stack1.pop();
            }
        }
        //最后一段处理
        if (lna.val <= lnb.val) {
            lna.next = lnb;
            list1IsHead = true;
        } else {
            lnb.next = lna;
        }
        if (list1IsHead)
            return list1;
        else return list2;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);

        ListNode head2 = new ListNode(2);

        ListNode listNode = head1;
        for (int i = 3; i <= 6; i += 2) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        for (ListNode listNode1 = head1; listNode1 != null; listNode1 = listNode1.next) {
            System.out.print(listNode1.val + " ");
        }
        System.out.println();
        listNode = head2;
        for (int i = 4; i <= 6; i += 2) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        for (ListNode listNode1 = head2; listNode1 != null; listNode1 = listNode1.next) {
            System.out.print(listNode1.val + " ");
        }
        System.out.println();

        ListNode result = merge(head1, head2);
        for (ListNode listNode1 = result; listNode1 != null; listNode1 = listNode1.next) {
            System.out.print(listNode1.val + " ");
        }
    }
}
