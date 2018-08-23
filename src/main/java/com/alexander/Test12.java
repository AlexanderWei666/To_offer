package com.alexander;

import java.util.LinkedList;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

interface DistinctNum<T> {
    boolean isThisType(T i);
}

public class Test12 <T>{
    public T[] reOrderArray(T[] array, DistinctNum<T> distinctNum) {
        //准备两个队列
        LinkedList<T> a = new LinkedList<>();
        LinkedList<T> b = new LinkedList<>();

        //入队操作
        for (T i : array) {
            if (distinctNum.isThisType(i))
                a.offer(i);
            else
                b.offer(i);
        }
        //出队操作
        for (int i = 0; i <= array.length - 1; i++) {
            if (!b.isEmpty()) array[i] = b.poll();
            else if (!a.isEmpty()) array[i] = a.poll();
        }

        for (T i : array) {
            System.out.println(i);
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        a = new Test12<Integer>().reOrderArray(a, (i) -> (i & 1) != 1);//奇数在偶数前面
        Integer[] b = {-1, 2, -2, -3, 5 ,-4};//负数在非负数前面
        b = new Test12<Integer>().reOrderArray(b, i -> (i >= 0));
    }
}
