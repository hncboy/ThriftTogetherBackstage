package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Order;
import com.pro516.thrifttogetherbackstage.entity.Review;
import com.pro516.thrifttogetherbackstage.entity.User;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleReviewVO;
import com.pro516.thrifttogetherbackstage.mapper.*;
import com.pro516.thrifttogetherbackstage.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 17:57
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public void reviewOrder(Review review) {
        // 修改订单状态
        Order order = orderMapper.getOrderByOrderNo(review.getOrderNo());
        order.setOrderStatus(4);
        order.setReviewTime(new Date());
        orderMapper.updateOrderStatus(order);

        // 添加评价
        review.setProductId(order.getProductId());
        review.setShopId(shopMapper.getShopIdByProductId(review.getProductId()));
        reviewMapper.reviewOrder(review);

        // 根据评价的订单总价获取10%积分
        Integer userId = review.getUserId();
        User user = userMapper.findUserByUserId(userId);
        couponMapper.updateUserIntegral(userId, user.getIntegral() + (int) Math.rint(order.getProductAmountTotal() / 10));
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleReviewVO> listReviewsByShopId(Integer shopId) {
        return reviewMapper.listReviewsByShopId(shopId);
    }
}
