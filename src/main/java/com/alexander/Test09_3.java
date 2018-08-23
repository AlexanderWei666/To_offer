package com.alexander;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 假设矩形放置方向为：
 *     **************
 *     **************
 */

/**
 * f(n - 1)为最后一块竖着放
 * f(n - 2)为最后一块横着放
 * 分析：f(n) = f(n - 1) + f(n - 2)
 */

public class Test09_3 {
    public static int RectCover(int target) {
        //循环方法
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int a = 1;
        int b = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = a + b;
            a = b;
            b = result;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
}
