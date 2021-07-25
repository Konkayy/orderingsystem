package com.cwy.repository;

import com.cwy.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-27 07:02:38
 */
@Mapper
@Repository
public interface AdminRepository {

    Admin login(String username, String password);

}
