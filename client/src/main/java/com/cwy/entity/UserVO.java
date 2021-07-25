package com.cwy.entity;

import lombok.Data;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-26 19:38:13
 */
@Data
public class UserVO {

    private int code;
    private String msg;
    private int count;
    private List<User> data;

    public UserVO() {
    }

    public UserVO(int code, String msg, int count, List<User> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
