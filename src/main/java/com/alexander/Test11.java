package com.alexander;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * */

/**
 * f(n) = f(n-1) + f(n-2) + ... + f(1)
 * f(n-1) = f(n-2) + ... + f(1)
 * f(n) = 2 * f(n-1)
 * 等比数列
 */
public class Test11 {
    public static void main(String[] args) {
        System.out.println(jumpFloorII(8));
    }
    public static int jumpFloorII(int target) {
        return (int)Math.pow(2, target - 1);
    }
}
