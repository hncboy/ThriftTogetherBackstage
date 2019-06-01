package com.pro516.thrifttogetherbackstage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 18:52
 */
@Mapper
@Component
public interface ScheduleMapper {

    /**
     * 查询每日推荐的数量
     * @return
     */
    Integer listRecommendedDaily();

    /**
     * 更新每日推荐
     */
    void insertRecommendedDaily(@Param("shopId") Integer shopId);

    /**
     * 更新优惠券状态
     */
    void updateCouponStatus();
}
