package com.cwy.repository;

import com.cwy.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-23 22:42:57
 */
@Mapper
@Repository
public interface MenuRepository {

    List<Menu> findAll(int index, int limit);

    int count();

    Menu findById(long id);

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(long id);
}
