package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
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
    List<Coupon> listCoupons();
}
