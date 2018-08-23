package com.alexander;

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Test05 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
//        //循环实现
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null)
//        {
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//        while (!stack.isEmpty())
//            list.add(stack.pop());

        addNumberToArray(list, listNode);
        return list;

    }


    public static void addNumberToArray(ArrayList<Integer> list, ListNode listNode) {
        //递归实现
        if (listNode == null)
            return;
        addNumberToArray(list, listNode.next);
        list.add(listNode.val);
    }

}
