package com.example.demo.java.handle小数;

import java.text.DecimalFormat;

/**
 * @author Boris
 * @date 2020/3/26 12:21
 */
public class format小数 {

    public static void main(String[] args) {
        //test11();
        test2();
    }

    /**
     * 四舍五入
     *
     * String.format 创建格式化的字符串以及连接多个字符串对象
     *
     * 格式化字符串
     * 参考：https://www.cnblogs.com/Dhouse/p/7776780.html
     */
    private static void test1() {
        String numStr = String.format("%.2f", 2.3366d);
        System.out.println(numStr);
    }


    private static void test10() {
        String numStr = String.format("%,.3f", 23422.33d);
        System.out.println(numStr);
    }

    /**
     * + - 0 ,等不可以一起使用
     */
    private static void test11() {
        String numStr = String.format("%06d", 23422);
        System.out.println(numStr);
    }

    /**
     * 四舍五入
     * 参考：https://www.jianshu.com/p/b3699d73142e
     */
    private static void test2() {
        DecimalFormat df = new DecimalFormat(",#.000");
        System.out.println(df.format(12.36757));
    }
}
