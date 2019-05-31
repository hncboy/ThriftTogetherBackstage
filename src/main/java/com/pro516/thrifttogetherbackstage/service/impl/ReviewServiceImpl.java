package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Review;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleReviewVO;
import com.pro516.thrifttogetherbackstage.mapper.OrderMapper;
import com.pro516.thrifttogetherbackstage.mapper.ReviewMapper;
import com.pro516.thrifttogetherbackstage.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void reviewOrder(Review review) {
        orderMapper.updateOrderStatus(orderMapper.getOrderByOrderNo(review.getOrderId()));
        reviewMapper.reviewOrder(review);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleReviewVO> listReviewsByProductId(Integer productId) {
        return reviewMapper.listReviewsByProductId(productId);
    }
}
