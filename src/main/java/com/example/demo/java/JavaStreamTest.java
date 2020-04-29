package com.example.demo.java;

import com.example.demo.model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Boris
 * @date 2020/3/25 20:26
 */
public class JavaStreamTest {

    public static void main(String[] args) {
        testReduce();
    }

    private static void flatMapsdfd() {
        List<String> first= Arrays.asList("one", "two", "three", "four");
        List<String> second= Arrays.asList("A", "B", "C", "D");
        Stream.of(first,second).flatMap(Collection::stream).forEach(System.out::print);
    }


  /**
    * sdfjdkchongtu sf 所发生的发生
    */
    private static void testReduce() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L, "00001", "22.56"));
        orderList.add(new Order(2L, "00002", "13.56"));
        orderList.add(new Order(3L, "00003", "22.77"));
        orderList.add(new Order(4L, "00004", "55.60"));
        orderList.add(new Order(5L, "00005", "47.19"));
        Double money = orderList.stream()
                .map(order -> Double.valueOf(order.getMoney()))
                .reduce(Double::sum).get();
        System.out.println(money);
    }

}
