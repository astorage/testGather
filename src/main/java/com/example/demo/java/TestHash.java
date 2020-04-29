package com.example.demo.java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Boris
 * @date 2020/3/10 13:02
 */
public class TestHash {

    public static void main(String[] args) {

        //testHashSorted();
        testTreeMap();
    }

    /**
     * 测试hash的有序性
     * HashMap key的顺序跟key值的hash值（hash的table大小有关系，table的大小又会根据装在因子loadFactor）有关，这个顺序不好掌握，呈现出无序
     * LinkedHashMap key的顺序跟写入的顺序有关系（不包括修改）
     * TreeMap key的顺序跟 key值得大小有关系，如果是字符串或则对象，还需要测试验证
     *
     */
    private static void testHashSorted() {
        Map<Integer, String> map = new HashMap();
        map.put(100, "1");

        map.put(5000, "3");
        map.put(500, "2");
        map.put(10000, "4");

        System.out.print("HashMap:");
        for(Integer key : map.keySet()) {
            System.out.print(map.get(key) + " ");
        }

        Map<Integer, String> linkedMap = new LinkedHashMap();
        linkedMap.put(100, "1");
        linkedMap.put(10000, "4");
        linkedMap.put(500, "2");
        linkedMap.put(5000, "3");


        linkedMap.get(5000);

        System.out.print("LinkedHashMap:");
        for(Integer key : linkedMap.keySet()) {
            System.out.print(linkedMap.get(key) + " ");
        }

        Map<Integer, String> treeMap = new TreeMap();
        treeMap.put(100, "1");
        treeMap.put(10000, "4");
        treeMap.put(50000, "3");
        treeMap.put(500, "2");

        System.out.print("TreeMap:");
        for(Integer key : treeMap.keySet()) {
            System.out.print(treeMap.get(key) + " ");
        }
    }


    /**
     * treeMap 根据key排序的
     */
    private static void  testTreeMap() {
        Map<String, String> testMap = new TreeMap<>();
        testMap.put("appid", "");
        testMap.put("mch_id", "");
        testMap.put("nonce_str", "");
        testMap.put("trade_type", "");
        testMap.put("out_trade_no", "");
        testMap.put("total_fee", "");
        testMap.put("notify_url", "");
        testMap.put("body", "");
        testMap.put("spbill_create_ip", "");
        System.out.println(testMap.keySet());
    }
}
