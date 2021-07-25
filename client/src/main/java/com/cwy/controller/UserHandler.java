package com.cwy.controller;

import com.cwy.entity.User;
import com.cwy.entity.UserVO;
import com.cwy.feign.OrderFeign;
import com.cwy.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-26 18:01:46
 */
@Controller
@RequestMapping("/user")
public class UserHandler {

    private final UserFeign userFeign;
    private final OrderFeign orderFeign;

    @Autowired
    public UserHandler(UserFeign userFeign, OrderFeign orderFeign) {
        this.userFeign = userFeign;
        this.orderFeign = orderFeign;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(int page, int limit) {
        return userFeign.findAll(page, limit);
    }

    @PostMapping("/save")
    public String save(User user) {
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/account/redirect/user_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable long id) {
        orderFeign.deleteByUid(id);
        userFeign.deleteById(id);
        return "redirect:/account/redirect/user_manage";
    }
}
