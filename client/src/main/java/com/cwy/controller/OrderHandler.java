package com.cwy.controller;

import com.alibaba.fastjson.JSON;
import com.cwy.entity.*;
import com.cwy.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Date;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-28 13:51:56
 */
@Controller
@RequestMapping("/order")
public class OrderHandler {

    private final OrderFeign orderFeign;

    @Autowired
    public OrderHandler(OrderFeign orderFeign) {
        this.orderFeign = orderFeign;
    }

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") long mid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Order order = new Order();
        Menu menu = new Menu();
        menu.setId(mid);
        order.setUser(user);
        order.setMenu(menu);
        order.setDate(new Date());
        orderFeign.save(order);
        return "redirect:/account/redirect/order";
    }

    @GetMapping("/findAllByUid")
    @ResponseBody
    public OrderVO findAllByUid(@RequestParam("page") int page,@RequestParam("limit") int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        return orderFeign.findAllByUid(user.getId(), page, limit);
    }

    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page") int page,@RequestParam("limit") int limit) {
        return orderFeign.findAllByState(0, page, limit);
    }

    @GetMapping("/updateState/{id}/{state}")
    public String updateState(@PathVariable long id,@PathVariable int state, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
        orderFeign.updateState(id, admin.getId(), state);
        return "redirect:/account/redirect/order_handler";
    }
}
