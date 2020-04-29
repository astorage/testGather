package com.example.demo.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boris
 * @date 2020/3/26 9:58
 */
public class ListTest {

    private static void listorderre() {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i<= 5; i++) {
            list.add(i);
        }
        System.out.println(list);
        list.remove(2);
        list.add(0, 3);
        System.out.println(list);

    }
}
