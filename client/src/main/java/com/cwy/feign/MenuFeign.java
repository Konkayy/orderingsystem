package com.cwy.feign;

import com.cwy.entity.Menu;
import com.cwy.entity.MenuVO;
import com.cwy.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-23 23:54:45
 */
@FeignClient("menu")
public interface MenuFeign {

    @GetMapping("/menu/findAll/{page}/{limit}")
    MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit);

    @GetMapping("/menu/findAll")
    List<Type> findAll();

    @PostMapping("/menu/save")
    void save(@RequestBody Menu menu);

    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") long id);

    @PutMapping("/menu/update")
    void update(@RequestBody Menu menu);

    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);
}
