package com.cwy.feign;

import com.cwy.entity.User;
import com.cwy.entity.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-26 12:35:58
 */
@FeignClient("user")
public interface UserFeign {

    @GetMapping("/user/findAll/{page}/{limit}")
    UserVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @PostMapping("/user/save")
    void save(@RequestBody User user);

    @DeleteMapping("/user/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);
}
