package com.cwy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-28 12:54:13
 */
@Data
public class Order {

    private long id;
    private User user;
    private Menu menu;
    private Admin admin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private int state;

    public Order() {
    }

    public Order(long id, User user, Menu menu, Admin admin, Date date, int state) {
        this.id = id;
        this.user = user;
        this.menu = menu;
        this.admin = admin;
        this.date = date;
        this.state = state;
    }
}
