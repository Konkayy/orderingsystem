package com.cwy.controller;

import com.cwy.entity.Account;
import com.cwy.repository.AdminRepository;
import com.cwy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-27 07:09:10
 */
@RestController
@RequestMapping("/account")
public class AccountHandler {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public AccountHandler(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    @RequestMapping("/login/{username}/{password}/{type}")
    public Account login(@PathVariable("username") String username,
                         @PathVariable("password") String password,
                         @PathVariable("type") String type) {
        Account account = null;
        switch (type) {
            case "user":
                account = userRepository.login(username, password);
                break;
            case "admin":
                account = adminRepository.login(username, password);
                break;
        }
        return account;
    }
}
