package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.vo.CreatedOrderVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleOrderVO;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 删除订单
     *
     * @param orderNo
     */
    void deleteOrder(Long orderNo);

    /**
     * 修改订单状态
     *
     * @param orderNo
     * @param orderStatus
     */
    void updateOrderStatus(Long orderNo, Integer orderStatus);

    /**
     * 创建订单
     *
     * @param createdOrderVO
     * @return 返回订单号
     */
    Long createOrder(CreatedOrderVO createdOrderVO);
}
