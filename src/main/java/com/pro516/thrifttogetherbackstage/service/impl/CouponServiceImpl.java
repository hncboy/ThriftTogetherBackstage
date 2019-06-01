package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.UserCoupon;
import com.pro516.thrifttogetherbackstage.entity.vo.CouponDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleCouponVO;
import com.pro516.thrifttogetherbackstage.mapper.CouponMapper;
import com.pro516.thrifttogetherbackstage.service.CouponService;
import com.pro516.thrifttogetherbackstage.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 10:26
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Transactional
    @Override
    public List<SimpleCouponVO> listSimpleCoupons() {
        return couponMapper.listSimpleCoupons();
    }

    @Transactional(readOnly = true)
    @Override
    public CouponDetailsVO getCouponDetailsByCouponId(Integer couponId) {
        CouponDetailsVO couponDetailsVO = couponMapper.getCouponDetailsByCouponId(couponId);
        couponDetailsVO.setCouponExchangeInfo("有效期至 " + DateUtil.dateFormat(couponDetailsVO.getExpiredDate()));
        couponDetailsVO.setCouponInfo("通用折扣" + couponDetailsVO.getCouponDiscountedPrice() + "元");
        return couponDetailsVO;
    }

    @Override
    public List<UserCoupon> listUserCouponsByUserId(Integer userId) {
        couponMapper.updateUserCouponStatus(userId); // 更新用户领取的优惠券状态
        List<UserCoupon> userCoupons = new ArrayList<>();
        userCoupons.addAll(couponMapper.listUserCoupons(userId, 2));
        userCoupons.addAll(couponMapper.listUserCoupons(userId, 1));
        userCoupons.addAll(couponMapper.listUserCoupons(userId, 3));
        return userCoupons;
    }

    @Override
    public void updateCouponStatus() {
        couponMapper.updateCouponStatus();
    }
}
