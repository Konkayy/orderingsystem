package com.cwy.entity;

import lombok.Data;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-24 23:08:30
 */
@Data
public class Type {

    private long id;
    private String name;

    public Type() {
    }

    public Type(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
