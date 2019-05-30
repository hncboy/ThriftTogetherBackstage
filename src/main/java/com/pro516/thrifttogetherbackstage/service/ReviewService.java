package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.Review;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleReviewVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 17:57
 */
public interface ReviewService {

    /**
     * 评价订单
     * @param review
     */
    void reviewOrder(Review review);

    /**
     * 根据商品id获取评价信息
     *
     * @param productId
     * @return
     */
    List<SimpleReviewVO> listReviewsByProductId(@Param("productId") Integer productId);
}
