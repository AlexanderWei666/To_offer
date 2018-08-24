package com.alexander;

/**
 * 打印从1到n位最大十进制数
 */

public class Test12 {

    public static void printNum(int n) {
        int[] num = new int[n];
        realPrint(num);
        while (!numIncr(num)){
            realPrint(num);
            System.out.println();
        }

    }

    public static boolean numIncr(int[] num) {
        boolean isOverFlow = false;
        for (int i = num.length - 1; i >= 0; i--) {
            if(num[i] == 9)
            {
                isOverFlow = true;
                num[i] = 0;
            }
            else {
                num[i] ++;
                isOverFlow = false;
                break;
            }
        }
        return isOverFlow;
    }

    public static void realPrint(int[] num) {
        boolean beforeZero = true;
        for (int i = 0; i < num.length; i++) {
            if (!beforeZero)
                System.out.print(num[i]);
            else if (num[i] != 0) {
                beforeZero = false;
                System.out.print(num[i]);
            }
        }
        if(beforeZero)
            System.out.println(0);
    }

    public static void main(String[] args) {
        //测试数组打印
//        realPrint(new int[]{0, 0, 2, 3});
//        System.out.println();

        //测试numIncr
//        int[] i = new int[]{9, 9, 9, 9};
//        numIncr(i);
//        realPrint(i);

        //
        printNum(2);
    }
}
