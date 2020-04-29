package com.example.demo.model;

import lombok.Data;

/**
 * @author Boris
 * @date 2020/3/26 10:04
 */
@Data
public class Order {

    private Long orderId;

    private String orderNum;

    private String money;

    public Order(Long orderId, String orderNum, String money) {
        this.orderId = orderId;
        this.orderNum = orderNum;
        this.money = money;
    }

    public Order() {
    }
}
