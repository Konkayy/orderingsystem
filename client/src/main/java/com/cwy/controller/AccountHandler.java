package com.cwy.controller;

import com.cwy.entity.Account;
import com.cwy.entity.Admin;
import com.cwy.entity.User;
import com.cwy.feign.AccountFeign;
import com.cwy.utils.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-27 11:18:33
 */
@Controller
@RequestMapping("/account")
public class AccountHandler {

    private final AccountFeign accountFeign;

    @Autowired
    public AccountHandler(AccountFeign accountFeign) {
        this.accountFeign = accountFeign;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("type") String type,
                        HttpSession session) {
        Account account = accountFeign.login(username, password, type);
        String target = null;
        if (account == null) {
            target = "login";
        } else {
            switch (type) {
                case "user":
                    User user = convertUser(account);
                    session.setAttribute("user", user);
                    target = "redirect:/account/redirect/index";
                    break;
                case "admin":
                    Admin admin = convertAdmin(account);
                    session.setAttribute("admin", admin);
                    target = "redirect:/account/redirect/main";
                    break;
            }
        }
        return target;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable String target) {
        return target;
    }

    private User convertUser(Account account) {
        User user = new User();
        user.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
        user.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
        user.setGender(ReflectUtils.getFieldValue(account,"gender")+"");
        user.setId((long)(ReflectUtils.getFieldValue(account,"id")));
        user.setNickname(ReflectUtils.getFieldValue(account,"nickname")+"");
        user.setRegisterdate((Date)(ReflectUtils.getFieldValue(account,"registerdate")));
        user.setTelephone(ReflectUtils.getFieldValue(account,"telephone")+"");
        return user;
    }

    private Admin convertAdmin(Account account) {
        Admin admin = new Admin();
        admin.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
        admin.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
        admin.setId((long)(ReflectUtils.getFieldValue(account,"id")));
        return admin;
    }

}
