package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.vo.CouponDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleCouponVO;
import com.pro516.thrifttogetherbackstage.mapper.CouponMapper;
import com.pro516.thrifttogetherbackstage.service.CouponService;
import com.pro516.thrifttogetherbackstage.util.DateUtil;
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
}
