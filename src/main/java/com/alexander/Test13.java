package com.alexander;

/**
 * 在O（1）时间删除链表节点，已知头指针和结点指针,
 * 下面算法，其实并不是真正删除，其实是把下一个内容对象复制到该对象，然后再删除下一个对象
 */

public class Test13 {
    public static ListNode deleteNode(ListNode listHead, ListNode deleteListNode) {
        // 如果输入参数有空值就返回表头结点
        if (listHead == null || deleteListNode == null) {
            return listHead;
        }

        // 如果删除的是头结点，直接返回头结点的下一个结点
        if (listHead == deleteListNode) {
            return listHead.next;
        }

        // 在多个节点的情况下，如果删除的是最后一个元素
        if (deleteListNode.next == null) {
            // 找待删除元素的前驱
            ListNode tmp = listHead;
            while (tmp.next != deleteListNode) {
                tmp = tmp.next;
            }
            // 删除待结点
            tmp.next = null;

        }
        // 在多个节点的情况下，如果删除的是某个中间结点
        else {
            // 将下一个结点的值输入当前待删除的结点
            deleteListNode.val = deleteListNode.next.val;
            // 待删除的结点的下一个指向原先待删除引号的下下个结点，即将待删除的下一个结点删除
            deleteListNode.next = deleteListNode.next.next;
        }

        // 返回删除节点后的链表头结点
        return listHead;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listHead = listNode;
        ListNode deleteListNode = listNode;
        for (int i = 1; i < 10; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
            if(i == 6) {
                deleteListNode = listNode;
            }
        }
        for (ListNode listNode1 = listHead; listNode1 != null ; listNode1 = listNode1.next) {
            System.out.print(listNode1.val + " ");
        }
        System.out.println();
        listHead = deleteNode(listHead, deleteListNode);
        for (ListNode listNode1 = listHead; listNode1 != null ; listNode1 = listNode1.next) {
            System.out.print(listNode1.val + " ");
        }

    }
}
