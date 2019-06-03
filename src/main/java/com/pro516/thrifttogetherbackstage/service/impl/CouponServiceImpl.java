package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Result;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleUserCouponVO;
import com.pro516.thrifttogetherbackstage.entity.vo.CouponDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleCouponVO;
import com.pro516.thrifttogetherbackstage.mapper.CouponMapper;
import com.pro516.thrifttogetherbackstage.mapper.UserMapper;
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

    @Autowired
    private UserMapper userMapper;

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

    @Transactional
    @Override
    public List<SimpleUserCouponVO> listUserCouponsByUserId(Integer userId) {
        couponMapper.updateUserCouponStatus(userId); // 更新用户领取的优惠券状态
        List<SimpleUserCouponVO> userCoupons = new ArrayList<>();
        userCoupons.addAll(couponMapper.listUserCoupons(userId, 2));
        userCoupons.addAll(couponMapper.listUserCoupons(userId, 1));
        userCoupons.addAll(couponMapper.listUserCoupons(userId, 3));
        return userCoupons;
    }

    @Transactional
    @Override
    public void updateCouponStatus() {
        couponMapper.updateCouponStatus();
    }

    @Override
    public Result userExchangeCoupon(Integer couponId, Integer userId) {
        // 1.判断优惠券有没有过期
        Integer couponStatus = couponMapper.getCouponStatusByCouponId(couponId);
        if (couponStatus == 2) {
            return new Result(500, "优惠券已过期", null);
        }
        // 2.判断用户积分是否足够
        CouponDetailsVO couponDetailsVO = couponMapper.getCouponDetailsByCouponId(couponId);
        Integer userIntegral = userMapper.findUserByUserId(userId).getIntegral();
        if (userIntegral < couponDetailsVO.getCouponIntegral()) {
            return new Result(500, "用户积分不足", null);
        }
        try {
            // 3.扣除积分
            couponMapper.updateUserIntegral(userId, userIntegral - couponDetailsVO.getCouponIntegral());
            // 4.增加优惠券
            couponMapper.insertUserCoupon(userId, couponId);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }
        return Result.success();
    }
}
