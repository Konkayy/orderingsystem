package com.cwy.entity;

import lombok.Data;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-28 20:14:16
 */
@Data
public class OrderVO {

    private int code;
    private String msg;
    private int count;
    private List<Order> data;

    public OrderVO() {
    }

    public OrderVO(int code, String msg, int count, List<Order> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
