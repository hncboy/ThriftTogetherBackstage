package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.vo.CouponDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleCouponVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 9:57
 */
@Mapper
@Component
public interface CouponMapper {

    /**
     * 获取所有优惠券
     *
     * @return
     */
    List<SimpleCouponVO> listSimpleCoupons();

    /**
     * 根据优惠卷id查询优惠券详情
     *
     * @param couponId
     * @return
     */
    CouponDetailsVO getCouponDetailsByCouponId(@Param("couponId") Integer couponId);
}
