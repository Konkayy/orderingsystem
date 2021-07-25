package com.cwy.controller;

import com.cwy.entity.User;
import com.cwy.entity.UserVO;
import com.cwy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-26 11:33:40
 */
@RestController
@RequestMapping("/user")
public class UserHandler {

    private final UserRepository userRepository;

    @Autowired
    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/findAll/{page}/{limit}")
    @ResponseBody
    public UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        List<User> userList = userRepository.findAll((page - 1) * limit, limit);
        int cnt = userRepository.count();
        return new UserVO(0, "", cnt, userList);
    }

    @GetMapping("/count")
    public int count() {
        return userRepository.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }
}
