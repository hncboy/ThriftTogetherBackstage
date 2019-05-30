package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Coupon;
import com.pro516.thrifttogetherbackstage.mapper.CouponMapper;
import com.pro516.thrifttogetherbackstage.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = true)
    @Override
    public List<Coupon> listCoupons() {
        return couponMapper.listCoupons();
    }
}
