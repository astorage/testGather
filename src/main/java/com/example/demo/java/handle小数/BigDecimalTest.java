package com.example.demo.java.handle小数;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Boris
 * @date 2020/3/26 12:23
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        //testXiao数计算();

        testXiao2();
    }


    private static void testXiao数计算() {
        BigDecimal bigDecimal1 = new BigDecimal("2.3366");
        BigDecimal bigDecimal2 = new BigDecimal("2.3366");

        //bigDecimal1.setScale(2, RoundingMode.HALF_UP);
        BigDecimal b3 = bigDecimal1.multiply(bigDecimal2);
        System.out.println(b3.toString());
        System.out.println(b3.setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * 四舍五入
     *          *<tr><th scope="row">5.5</th>  <td>6</td>
     *          *<tr><th scope="row">2.5</th>  <td>3</td>
     *          *<tr><th scope="row">1.6</th>  <td>2</td>
     *          *<tr><th scope="row">1.1</th>  <td>1</td>
     *          *<tr><th scope="row">1.0</th>  <td>1</td>
     *          *<tr><th scope="row">-1.0</th> <td>-1</td>
     *          *<tr><th scope="row">-1.1</th> <td>-1</td>
     *          *<tr><th scope="row">-1.6</th> <td>-2</td>
     *          *<tr><th scope="row">-2.5</th> <td>-3</td>
     *          *<tr><th scope="row">-5.5</th> <td>-6</td>
     */
    private static void testXiao1() {
        BigDecimal bigDecimal = new BigDecimal("2.3366");
        System.out.println(bigDecimal.setScale(3, RoundingMode.HALF_UP));
    }

    /**
     * 直接向前进位
     *          *<tr><th scope="row">5.5</th>  <td>6</td>
     *          *<tr><th scope="row">2.5</th>  <td>3</td>
     *          *<tr><th scope="row">1.6</th>  <td>2</td>
     *          *<tr><th scope="row">1.1</th>  <td>2</td>
     *          *<tr><th scope="row">1.0</th>  <td>1</td>
     *          *<tr><th scope="row">-1.0</th> <td>-1</td>
     *          *<tr><th scope="row">-1.1</th> <td>-2</td>
     *          *<tr><th scope="row">-1.6</th> <td>-2</td>
     *          *<tr><th scope="row">-2.5</th> <td>-3</td>
     *          *<tr><th scope="row">-5.5</th> <td>-6</td>
     */
    private static void testXiao2() {
        BigDecimal bigDecimal = new BigDecimal("-5.0005");
        System.out.println(bigDecimal.setScale(3, RoundingMode.UP));
    }

}
