package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.vo.SimpleOrderVO;
import com.pro516.thrifttogetherbackstage.mapper.OrderMapper;
import com.pro516.thrifttogetherbackstage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<SimpleOrderVO> listAllOrders(Integer userId) {
        return null;
    }

    @Override
    public List<SimpleOrderVO> listOrdersByStatus(Integer userId, Integer orderStatus) {
        return orderMapper.listOrdersByStatus(userId, orderStatus);
    }
}
