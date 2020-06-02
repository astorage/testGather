package com.example.demo.java.tmp;

import com.example.demo.encrypt.TestSecurityUtil;

import java.util.concurrent.*;

/**
 * @author Boris
 * @date 2020/5/23 8:54
 */
public class JavaBase {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(TestSecurityUtil.JavaBaseTest.class.getClassLoader());
        Object obj = new Object();
        try {
            obj.wait();
            obj.wait(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
