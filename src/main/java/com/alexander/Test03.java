package com.alexander;

import java.util.Date;
import java.util.Random;

public class Test03 {
    public static void main(String[] args) {
        int[][] array = new int[][] {
                {1 , 3, 4, 5},
                {2 , 4, 5, 6},
                {3 , 5, 6, 7},
                {4 , 6, 7, 8}
        };
        Random random = new Random((int) (new Date().getTime()));
        int target = random.nextInt(20);

        System.out.println(Find(target, array));
        System.out.println("--------------");
        int[][] array1 = null;
        int[][] array2 = new int[0][0];
        System.out.println(Find(target, array1));
        System.out.println(Find(target, array2));

    }

    public static boolean Find(int target, int[][] array) {
        //特殊情况处理
        if (array == null || array.length < 1 || array[0].length < 1) {
            System.out.println("\n特殊情况：");
            return false;
        }
        //指定列、行
        int columnLength = array[0].length;
        int rowLength = array.length;

        int i = 0;
        int j = columnLength - 1;
        while (i < rowLength && j >= 0) {
            if (target == array[i][j]) {
                System.out.println("普通情况：");
                System.out.println(target);
                for (int k = 0; k < array.length; k++) {
                    for (int l = 0; l < array[0].length; l++) {
                        System.out.printf("%-3d", array[k][l]);
                    }
                    System.out.println();
                }
                return true;
            } else if (target > array[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println("普通情况：");
        System.out.println(target);
        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[0].length; l++) {
                System.out.printf("%-3d", array[k][l]);
            }
            System.out.println();
        }
        return false;
    }
}
