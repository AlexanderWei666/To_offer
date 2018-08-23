package com.alexander;

public class Test08 {
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};
    }
    public static int minNumberInRotateArray(int [] array) {
        int lo = 0;
        int hi = array.length - 1;

        //普通情况的二分查找
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(array[mid] < array[mid - 1])//最小数满足它比它前一个数小
                return mid;
            else {
                if(array[mid] < (array[lo] + array[hi]) / 2)
                    hi = mid;
                else if(array[mid] > (array[lo] + array[hi]) / 2){
                    lo = mid;
                }
                //遇见特殊情况，直接停止循环
                else break;
            }
        }

        //特殊情况处理，暴力搜索
        int min = 0;
        for (int a: array) {
            if(a <= min){
                min = a;
            }
        }
        return min;
    }

}
