package com.cwy.entity;

import lombok.Data;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-24 15:35:12
 */
@Data
public class MenuVO {

    private int code;
    private String msg;
    private int count;
    private List<Menu> data;

    public MenuVO() {
    }

    public MenuVO(int code, String msg, int count, List<Menu> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
