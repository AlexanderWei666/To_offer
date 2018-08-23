package com.alexander;
/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class Test10 {

    public static int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            if ((n & 1) == 1)
                count ++;
                n = n >>> 1;
        }
        return count;
    }

    public static int NumberOf1_1(int n) {
        int count = 0;
        while(n != 0) {
            count ++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1_1(3));
    }
}
