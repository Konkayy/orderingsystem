package com.cwy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author MSI-PC
 * @description:
 * CREATE TABLE `t_user`  (
 *   `id` int(0) NOT NULL AUTO_INCREMENT,
 *   `username` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `password` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `nickname` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `gender` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   `registerdate` date NULL DEFAULT NULL,
 *   `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
 *   PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 * @date 2021-06-26 11:35:53
 */
@Data
public class User {

    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerdate;
    private String address;

    public User() {
    }

    public User(long id, String username, String password, String nickname, String gender, String telephone, Date registerdate, String address) {
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
