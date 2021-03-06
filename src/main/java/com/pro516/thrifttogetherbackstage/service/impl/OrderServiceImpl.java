package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.AfterSaleOrder;
import com.pro516.thrifttogetherbackstage.entity.Order;
import com.pro516.thrifttogetherbackstage.entity.Product;
import com.pro516.thrifttogetherbackstage.entity.UserCoupon;
import com.pro516.thrifttogetherbackstage.entity.vo.*;
import com.pro516.thrifttogetherbackstage.mapper.CouponMapper;
import com.pro516.thrifttogetherbackstage.mapper.OrderMapper;
import com.pro516.thrifttogetherbackstage.mapper.ShopMapper;
import com.pro516.thrifttogetherbackstage.service.OrderService;
import com.pro516.thrifttogetherbackstage.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private ShopMapper shopMapper;

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
        // 各自状态时间排序
        return orderMapper.listOrdersByStatus(userId, orderStatus);
    }

    @Transactional
    @Override
    public void deleteOrder(Long orderNo) {
        orderMapper.deleteOrder(orderNo);
    }

    @Transactional
    @Override
    public void updateOrderStatus(Long orderNo, Integer orderStatus) {
        Order order = orderMapper.getOrderByOrderNo(orderNo);
        // 修改订单状态只能从状态为2的时候开始
        switch (orderStatus) {
            case 2:
                order.setOrderStatus(2);
                order.setPayTime(new Date());
                break;
            case 3:
                order.setOrderStatus(3);
                order.setUseTime(new Date());
                break;
            case 4:
                order.setOrderStatus(4);
                order.setReviewTime(new Date());
                break;
            case 5:
                order.setOrderStatus(5);
                order.setAfterSaleTime(new Date());
                break;
            default:
                break;
        }
        orderMapper.updateOrderStatus(order);
    }

    @Transactional
    @Override
    public Long createOrder(CreatedOrderVO createdOrderVO) {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0, 0);
        Long orderNo = snowflakeIdWorker.nextId();
        createdOrderVO.setOrderNo(orderNo);
        orderMapper.insertOrder(createdOrderVO);

        // 判断是否使用优惠券
        if (createdOrderVO.getIsUseCoupon() == 1 && createdOrderVO.getUserCouponId() != null) {
            couponMapper.userUseCoupon(createdOrderVO.getOrderNo(), createdOrderVO.getUserCouponId());
        } else {
            createdOrderVO.setUserCouponId(0);
        }
        return orderNo;
    }

    @Transactional(readOnly = true)
    @Override
    public OrderDetailsVO getDetailOrderByOrderNo(Long orderNo) {
        OrderDetailsVO orderDetailsVO = orderMapper.getDetailOrderByOrderNo(orderNo);
        // 1.添加商品名称，商品封面
        // 1.1 根据商品id查询商品
        Product product = shopMapper.getProductByProductId(orderDetailsVO.getProductId());
        orderDetailsVO.setProductName(product.getProductName());
        orderDetailsVO.setProductCoverUrl(product.getProductCoverUrl());

        // 有优惠券
        if (orderDetailsVO.getIsUseCoupon() == 1) {
            // 2.添加优惠券折扣价格
            // 2.1根据用户优惠券id查询用户优惠券详情
            UserCoupon userCoupon = couponMapper.getUserCouponByUserCouponId(orderDetailsVO.getUserCouponId());
            // 2.2根据优惠券id查询优惠券折扣价格
            Integer discountedPrice = couponMapper.getCouponDetailsByCouponId(userCoupon.getCouponId()).getCouponDiscountedPrice();
            orderDetailsVO.setDiscountedPrice(discountedPrice);
        }

        // 3.添加商品所属店铺名称
        // 3.1根据商品查询店铺id
        Integer shopId = product.getShopId();
        // 3.2根据店铺id查询店铺信息
        SimpleShopVO simpleShopVO = shopMapper.getSimpleShopByShopId(shopId);
        // 3.3传入店铺名称
        orderDetailsVO.setShopName(simpleShopVO.getShopName());

        return orderDetailsVO;
    }

    @Transactional
    @Override
    public void refundAfterSaleOrder(AfterSaleOrder afterSaleOrder) {
        // 修改订单状态
        Order order = orderMapper.getOrderByOrderNo(afterSaleOrder.getOrderNo());
        order.setOrderStatus(5);
        order.setAfterSaleTime(new Date());
        orderMapper.updateOrderStatus(order);
        // 插入售后订单
        orderMapper.insertAfterSaleOrder(afterSaleOrder);
    }
}
