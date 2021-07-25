package com.cwy.repository;

import com.cwy.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MSI-PC
 * @description:
 * @date 2021-06-28 13:17:38
 */
@Mapper
@Repository
public interface OrderRepository {

    void save(Order order);

    List<Order> findAllByUid(long uid, int index, int limit);

    int countByUid(long uid);

    void deleteByMid(long mid);

    void deleteByUid(long uid);

    List<Order> findAllByState(int state, int index, int limit);

    int countByState(int state);

    void updateState(long id, long aid, int state);

}
