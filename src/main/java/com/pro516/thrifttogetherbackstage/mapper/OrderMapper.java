package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.Order;
import com.pro516.thrifttogetherbackstage.entity.vo.CreatedOrderVO;
import com.pro516.thrifttogetherbackstage.entity.vo.OrderDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 8:28
 */
@Mapper
@Component
public interface OrderMapper {

    /**
     * 根据订单状态获取订单，按时间降序
     *
     * @param orderStatus
     * @return
     */
    List<SimpleOrderVO> listOrdersByStatus(@Param("userId") Integer userId,
                                           @Param("orderStatus") Integer orderStatus);

    /**
     * 删除订单
     *
     * @param orderNo
     */
    void deleteOrder(@Param("orderNo") Long orderNo);

    /**
     * 修改订单状态
     *
     * @param order
     */
    void updateOrderStatus(Order order);

    /**
     * 根据订单号获取订单信息
     *
     * @param orderNo
     * @return
     */
    Order getOrderByOrderNo(@Param("orderNo") Long orderNo);

    /**
     * 插入订单
     *
     * @param createdOrderVO
     */
    void insertOrder(@Param("createdOrderVO") CreatedOrderVO createdOrderVO);

    /**
     * 根据订单号获取订单详细信息
     *
     * @param orderNo
     * @return
     */
    OrderDetailsVO getDetailOrderByOrderNo(@Param("orderNo") Long orderNo);
}
