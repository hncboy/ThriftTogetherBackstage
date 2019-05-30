package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.vo.SimpleOrderVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 8:31
 */
public interface OrderService {

    /**
     * 获取所有订单
     *
     * @return
     */
    List<SimpleOrderVO> listAllOrders(Integer userId);

    /**
     * 根据订单状态获取订单
     *
     * @param userId
     * @param orderStatus
     * @return
     */
    List<SimpleOrderVO> listOrdersByStatus(Integer userId, Integer orderStatus);
}
