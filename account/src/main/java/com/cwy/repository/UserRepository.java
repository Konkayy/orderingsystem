package com.cwy.repository;

import com.cwy.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-27 07:02:26
 */
@Mapper
@Repository
public interface UserRepository {

    User login(String username, String password);

}
