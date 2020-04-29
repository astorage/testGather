package com.example.demo.java.handle小数;

import java.math.BigDecimal;

/**
 * @author Boris
 * @date 2020/3/25 20:56
 */
public class Java小数计算 {


    public static void main(String[] args) {
        //testDoubleError();
        //testDoubleMulti();
        testBigDecimal();
    }

    /**
     * 测试Double类型计算存在误差的情况
     *
     * 问题在于1.1这个数字不能被精确表示为一个double，因此它被表
     * 示为最接近它的double值，该程序从2中减去的就是这个值，但这个计算的结果并不是最接近0.9的double值。
     */
    private static void testDoubleError() {
        Double dd1 = 10.0d;
        Double dd2 = 9.98d;

        System.out.println("本应该0.02，计算结果" + (dd1 - dd2));
        System.out.println(2.00);
        System.out.println(2.00 -1.10);//0.8999999999999999
    }

    /**
     * bigdecimal 能解决Double计算不准确的问题
     * 不过构建bigdecimal对象的时候必须以String的形式， 以double的形式也有问题
     */
    private static void testBigDecimal() {
        BigDecimal b1 = new BigDecimal("10.0");
        BigDecimal b2 = new BigDecimal("9.98");
        System.out.println(b1.subtract(b2));

        System.out.println("2.00 -1.10 = " + new BigDecimal(2.00).subtract(new BigDecimal(1.10)));
        System.out.println("2.00 -1.10 = " + new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
    }

    /**
     * double乘除后，小数点增多
     */
    private static void testDoubleMulti() {
        double d1 = 2.33;
        double d2 = 16.33;
        double d3 = 20.33;

        Double d4 =  d1 * d2 / d3 ;
        System.out.println(d4);
    }



}
