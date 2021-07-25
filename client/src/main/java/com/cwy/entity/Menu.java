package com.cwy.entity;

import lombok.Data;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-23 22:41:20
 */
@Data
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private Type type;

    public Menu(long id, String name, double price, String flavor, Type type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flavor = flavor;
        this.type = type;
    }

    public Menu() {
    }
}
