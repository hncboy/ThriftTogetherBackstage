package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.UserCoupon;
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

    /**
     * 根据用户id和用户优惠券状态查询领取的优惠券
     *
     * @param userId
     * @param userCouponStatus
     * @return
     */
    List<UserCoupon> listUserCoupons(@Param("userId") Integer userId,
                                     @Param("userCouponStatus") Integer userCouponStatus);

    /**
     * 更新优惠券状态
     */
    void updateCouponStatus();

    /**
     * 更新用户优惠券状态
     *
     * @param userId
     */
    void updateUserCouponStatus(Integer userId);

    /**
     * 根据优惠券id获取优惠券状态
     *
     * @param couponId
     * @return
     */
    Integer getCouponStatusByCouponId(@Param("couponId") Integer couponId);

    /**
     * 根据用户id更新用户积分
     *
     * @param userId
     * @param integral
     */
    void updateUserIntegral(@Param("userId") Integer userId,
                            @Param("integral") Integer integral);

    /**
     * 根据用户id和优惠券id添加用户优惠券
     *
     * @param userId
     * @param couponId
     */
    void insertUserCoupon(@Param("userId") Integer userId,
                          @Param("couponId") Integer couponId);

    /**
     * 用户使用优惠券
     *
     * @param orderNo
     * @param userCouponId
     */
    void userUseCoupon(@Param("orderNo") Long orderNo,
                       @Param("userCouponId") Integer userCouponId);
}
