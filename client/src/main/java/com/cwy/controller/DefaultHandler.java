package com.cwy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-07-03 21:18:52
 */
@Controller
public class DefaultHandler {

    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "index";
        }
        if (session.getAttribute("admin") != null) {
            return "main";
        }
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
