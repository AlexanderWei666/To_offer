package com.alexander;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Test09_1 {
    public int JumpFloor(int target) {

        //递归方法，效率低
        /*if(target == 0)
            return 1;
        if(target == 1)
            return 1;
        return JumpFloor(target - 1) + JumpFloor(target - 2);*/

        //循环方法
        if(target <= 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 2; i < target; i++){
            result = one+ two;
            one = two;
            two = result;
        }
        return result;
    }
}
