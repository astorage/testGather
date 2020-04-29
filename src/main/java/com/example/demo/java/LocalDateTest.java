package com.example.demo.java;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author Boris
 * @date 2020/3/26 9:57
 */
public class LocalDateTest {

    public static void main(String[] args) {

    }

    private static void testDatecount() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime afterYear = now.plusYears(1);

        System.out.println( now.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println( afterYear.toInstant(ZoneOffset.of("+8")).toEpochMilli());

        System.out.println(now);
        System.out.println(afterYear);

    }
}
