package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.Review;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/30
 * Time: 16:48
 */
@Mapper
@Component
public interface ReviewMapper {

    /**
     * 评价订单
     * @param review
     */
    void reviewOrder(@Param("review") Review review);

    /**
     * 根据商品id获取评价信息
     *
     * @param shopId
     * @return
     */
    List<SimpleReviewVO> listReviewsByShopId(@Param("shopId") Integer shopId);
}
