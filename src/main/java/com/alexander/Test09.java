package com.alexander;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * */
public class Test09 {
    public static int Fibonacci(int n) {
        int a = 0;
        int b = 1;
        int t = 0;
        for(int i = 0; i < n; i++) {
            t = b;
            b = b + a;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(1));
    }
}
