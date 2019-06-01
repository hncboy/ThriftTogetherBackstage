package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.entity.UserCoupon;
import com.pro516.thrifttogetherbackstage.entity.vo.CouponDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleCouponVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 10:25
 */
public interface CouponService {

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
    CouponDetailsVO getCouponDetailsByCouponId(Integer couponId);

    /**
     * 根据用户id查询领取的优惠券
     *
     * @param userId
     * @return
     */
    List<UserCoupon> listUserCouponsByUserId(Integer userId);

    /**
     * 更新优惠券状态
     */
    void updateCouponStatus();

    /**
     * 根据用户id和优惠券id兑换优惠券
     *
     * @param userId
     * @param couponId
     */
    Result userExchangeCoupon(Integer couponId, Integer userId);
}
