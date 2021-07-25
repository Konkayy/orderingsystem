package com.cwy.controller;

import com.cwy.entity.Menu;
import com.cwy.entity.MenuVO;
import com.cwy.entity.Type;
import com.cwy.repository.MenuRepository;
import com.cwy.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-23 21:38:24
 */
@RestController
@RequestMapping("/menu")
public class MenuHandler {

    private final MenuRepository menuRepository;
    private final TypeRepository typeRepository;

    @Autowired
    public MenuHandler(MenuRepository menuRepository, TypeRepository typeRepository) {
        this.menuRepository = menuRepository;
        this.typeRepository = typeRepository;
    }

    @GetMapping("/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page,@PathVariable("limit") int limit) {
        List<Menu> menuList = menuRepository.findAll((page - 1) * limit, limit);
        int cnt = menuRepository.count();
        return new MenuVO(0, "", cnt, menuList);
    }

    @GetMapping("/findAll")
    public List<Type> findTypes() {
        return typeRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Menu menu) {
        menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id) {
        return menuRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu) {
        menuRepository.update(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        menuRepository.deleteById(id);
    }
}
