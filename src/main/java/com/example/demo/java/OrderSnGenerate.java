package com.example.demo.java;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OrderSnGenerate {

    private static final Integer SIGN_LENGTH = 6;

    private static final String FORMT_STRING_PREFIX = "0";
    private static final String FORMT_STRING = "888888";
    private static final String ORDER_FIRST_SIGN = "7";

    public static void main(String[] args) {
        String orderSn = generateOrderSn();
        System.out.println(orderSn);
    }

    private static String generateOrderSn() {
        long userId = 1;
        String id = formatSign(userId);
        String[] ids = id.split("");
        String times = Long.toString(System.currentTimeMillis() + generateRandom(10000)); // 随机加上一个10000以下的随机数，保证在拆单时子订单编号不重复
        times = times.substring(1);
        String prefix = times.substring(0, SIGN_LENGTH);
        String suffix = times.substring(SIGN_LENGTH);
        String[] prefixs = prefix.split("");
        List<String> s = Arrays.asList(prefixs);
        Collections.reverse(s);
        StringBuffer sb = new StringBuffer();
        String replace = "0";
        for (int i = 0; i < SIGN_LENGTH; i++) {
            if (i == 0 && replace.equals(s.get(i))) {
                sb.append(ORDER_FIRST_SIGN).append(ids[i]);
            } else {
                sb.append(s.get(i)).append(ids[i]);
            }
        }
        String code = sb.toString();
        sb = new StringBuffer();
        sb.append(code.substring(0, SIGN_LENGTH))
                .append(suffix.substring(0, SIGN_LENGTH / 2))
                .append(code.substring(SIGN_LENGTH))
                .append(suffix.substring(SIGN_LENGTH / 2));

        String orderSn;
        System.out.println(orderSn = sb.toString());
        return orderSn;
    }


    private static String formatSign(long param) {
        String str = Long.toString(param);
        int length = str.length() - SIGN_LENGTH;
        if (length == 0) {
            return str;
        } else if (length < 0) {
            str = FORMT_STRING_PREFIX + str;
            return FORMT_STRING.substring(0, Math.abs(length) - 1) + str;
        } else {
            return str.substring(length, str.length());
        }
    }

    private static int generateRandom(int length) {
        return new Random().nextInt(length);
    }
}
