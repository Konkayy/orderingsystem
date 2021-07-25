package com.cwy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-07-01 13:44:49
 */
@Data
public class Account {

    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerdate;
    private String address;

    public Account() {
    }

    public Account(long id, String username, String password, String nickname, String gender, String telephone, Date registerdate, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.telephone = telephone;
        this.registerdate = registerdate;
        this.address = address;
    }
}
