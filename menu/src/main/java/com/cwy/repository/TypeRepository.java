package com.cwy.repository;

import com.cwy.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-24 23:10:33
 */
@Mapper
@Repository
public interface TypeRepository {

    List<Type> findAll();

}
