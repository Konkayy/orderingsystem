package com.cwy.repository;

import com.cwy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-26 11:41:12
 */
@Mapper
@Repository
public interface UserRepository {

    List<User> findAll(int index, int limit);

    int count();

    void save(User user);

    void deleteById(long id);
}
