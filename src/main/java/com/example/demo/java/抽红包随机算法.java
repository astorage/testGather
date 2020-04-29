package com.example.demo.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Boris
 * @date 2020/3/10 13:56
 */
public class 抽红包随机算法 {
    static Random RANDOM = new Random();
    static Map<String, Integer> redpacketNumMap = new HashMap<>();
    static {
        redpacketNumMap.put("packet1", 30);
        redpacketNumMap.put("packet2", 10);
        redpacketNumMap.put("total", 40);
//        redpacketNumMap.put("packet3", 10100);
//        redpacketNumMap.put("packet4", 300);
//        redpacketNumMap.put("packet5", 5000);
//        redpacketNumMap.put("packet6", 2000);
    }

    public static void main(String[] args) {

        getRandomRedpacket();
    }

    /**
     * 抽出一个红包概率变化，在抽完红包之前，每次都能抽取到红包
     *  像一堆奖球放在箱子里，每次去抓一个，知道抓完为止
     *  算法解释：
     *  map<num1, 红包id1>  map<num2, 红包id2> …… map<numN, 红包idN>
     *  numN = num(N-1) + …… num1
     *  生成 0 到 numN + 1 的伪随机数据 random
     *  random落在numM和num(M-1)之间的话 就说明抽中了 numM 对应的红包id
     *
     */
    private static void getRandomRedpacket() {
        while (redpacketNumMap.get("total") > 0){
            Integer totalNum = redpacketNumMap.remove("total");
            Map<Integer, String> dataPool = new HashMap<>();
            Integer num = 0;
            for (Map.Entry<String, Integer> entry : redpacketNumMap.entrySet()) {
                if (entry.getValue() <= 0) {
                    continue;
                }
                num += entry.getValue();
                dataPool.put(num, entry.getKey());
            }

            Integer randomNum = RANDOM.nextInt(num + 1);
            String redpacketIdStr = dataPool.entrySet().stream().filter(entry -> randomNum <= entry.getKey())
                    .min(Comparator.comparing(Map.Entry::getKey))
                    .get().getValue();


            if (redpacketNumMap.get(redpacketIdStr) > 0) {
                redpacketNumMap.put(redpacketIdStr, redpacketNumMap.get(redpacketIdStr) - 1);
                redpacketNumMap.put("total", totalNum - 1);
            }else  {
                redpacketNumMap.put("total", totalNum);
            }
            System.out.println(randomNum + " " + redpacketIdStr + "  剩余：" + redpacketNumMap.get(redpacketIdStr));
        }


        System.out.println(redpacketNumMap);

    }


    /**
     * 根据指定种子产生伪随机
     */
    private static void  random1() {
        Random r = new Random(1);
        for(int i=0 ; i<100 ;  i++)
        {
            ((Runnable) () -> {
                int ran1 = r.nextInt(100);
                System.out.println(ran1);
            }).run();

        }
    }


    /**
     * 根据当前时间产生随机
     */
    private static void  random2() {
        Random r = new Random();
        for(int i=0 ; i<100 ;  i++)
        {
            ((Runnable) () -> {
                int ran1 = r.nextInt(100);
                System.out.println(ran1);
            }).run();
        }
    }


}
