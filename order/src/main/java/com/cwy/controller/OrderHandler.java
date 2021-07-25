package com.cwy.controller;

import com.cwy.entity.Order;
import com.cwy.entity.OrderVO;
import com.cwy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-23 19:50:25
 */
@RestController
@RequestMapping("/order")
public class OrderHandler {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/save")
    public void save(@RequestBody Order order) {
        order.setDate(new Date());
        order.setState(0);
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{uid}/{page}/{limit}")
    public OrderVO findAllByUid(@PathVariable("uid") long uid, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(uid, (page - 1) * limit, limit));
        return orderVO;
    }

    @DeleteMapping("/deleteByMid/{mid}")
    public void deleteByMid(@PathVariable("mid") long mid) {
        orderRepository.deleteByMid(mid);
    }

    @DeleteMapping("/deleteByUid/{uid}")
    public void deleteByUid(@PathVariable("uid") long uid) {
        orderRepository.deleteByUid(uid);
    }

    @GetMapping("/findAllByState/{state}/{page}/{limit}")
    public OrderVO findAllByState(@PathVariable("state") int state, @PathVariable("page") int page, @PathVariable("limit") int limit) {
        OrderVO orderVO = new OrderVO();
        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByState(0));
        orderVO.setData(orderRepository.findAllByState(0, (page - 1) * limit, limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}/{state}/{aid}")
    public void updateState(@PathVariable("id") long id, @PathVariable("state") int state, @PathVariable("aid") long aid) {
        orderRepository.updateState(id, aid, state);
    }

}
