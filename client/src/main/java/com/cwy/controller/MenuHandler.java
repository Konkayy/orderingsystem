package com.cwy.controller;

import com.cwy.entity.Menu;
import com.cwy.entity.MenuVO;
import com.cwy.feign.MenuFeign;
import com.cwy.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-24 10:34:27
 */
@Controller
@RequestMapping("/menu")
public class MenuHandler {

    private final MenuFeign menuFeign;
    private final OrderFeign orderFeign;

    @Autowired
    public MenuHandler(MenuFeign menuFeign, OrderFeign orderFeign) {
        this.menuFeign = menuFeign;
        this.orderFeign = orderFeign;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(int page, int limit) {
        return menuFeign.findAll(page, limit);
    }

    @GetMapping("/prepareSave")
    public String prepareSave(Model model) {
        model.addAttribute("list", menuFeign.findAll());
        return "menu_add";
    }

    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "redirect:/account/redirect/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable long id, Model model) {
        model.addAttribute("list", menuFeign.findAll());
        model.addAttribute("menu", menuFeign.findById(id));
        return "menu_update";
    }

    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "redirect:/account/redirect/menu_manage";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable long id) {
        orderFeign.deleteByMid(id);
        menuFeign.deleteById(id);
        return "redirect:/account/redirect/menu_manage";
    }

}
