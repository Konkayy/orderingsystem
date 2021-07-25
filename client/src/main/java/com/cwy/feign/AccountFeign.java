package com.cwy.feign;

import com.cwy.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author MSI-PC
 * @description: Feign调用返回的是HashMap，其key值可以自动装填至类的属性中
 * @date 2021-06-27 11:21:34
 */
@FeignClient("account")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    Account login(@PathVariable String username, @PathVariable String password, @PathVariable String type);

}
