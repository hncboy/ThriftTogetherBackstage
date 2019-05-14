package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.Coupon;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 10:25
 */
public interface CouponService {

    /**
     * 获取所有优惠券
     * @return
     */
    List<Coupon> listCoupons();
}
