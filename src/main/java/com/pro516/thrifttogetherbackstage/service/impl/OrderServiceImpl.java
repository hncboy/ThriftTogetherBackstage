package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.vo.SimpleOrderVO;
import com.pro516.thrifttogetherbackstage.mapper.OrderMapper;
import com.pro516.thrifttogetherbackstage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 8:43
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional(readOnly = true)
    @Override
    public List<SimpleOrderVO> listAllOrders(Integer userId) {
        // 按1待付款，2待使用，5退款售后，3待评价，4已完成排序
        List<SimpleOrderVO> orders = new ArrayList<>();
        orders.addAll(orderMapper.listOrdersByStatus(userId, 1));
        orders.addAll(orderMapper.listOrdersByStatus(userId, 2));
        orders.addAll(orderMapper.listOrdersByStatus(userId, 5));
        orders.addAll(orderMapper.listOrdersByStatus(userId, 3));
        orders.addAll(orderMapper.listOrdersByStatus(userId, 4));
        return orders;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleOrderVO> listOrdersByStatus(Integer userId, Integer orderStatus) {
        return orderMapper.listOrdersByStatus(userId, orderStatus);
    }
}
