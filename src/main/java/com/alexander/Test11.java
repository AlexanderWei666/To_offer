package com.alexander;

public class Test11 {
    public double Power(double base, int exponent) {
        double result = 1;

        //底数为0进行异常处理
        if (base == 0.0) {
            if (exponent > 0) return 0.0;
            else return Double.POSITIVE_INFINITY;
        }

        //指数大于等于0处理
        if (exponent >= 0)
            while (exponent != 0) {
                exponent--;
                result *= base;
            }
            //指数小于0处理
        else {
            while (exponent != 0) {
                exponent++;
                result /= base;
            }
        }

        return result;
    }
}
