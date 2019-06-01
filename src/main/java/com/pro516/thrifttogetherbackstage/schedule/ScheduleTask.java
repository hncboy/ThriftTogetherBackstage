package com.pro516.thrifttogetherbackstage.schedule;

import com.pro516.thrifttogetherbackstage.service.CouponService;
import com.pro516.thrifttogetherbackstage.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 18:43
 * 定时任务
 */
@Component
public class ScheduleTask {

    @Autowired
    private ShopService shopService;

    @Autowired
    private CouponService couponService;

    @Scheduled(cron = "0 0 6 * * ?")
    public void updateRecommendedDaily() {
        // 正式情况下每天6点更新每日推荐
        shopService.updateRecommendedDaily();
    }

    @Scheduled(cron = "0 0 */1 * * ?")
    public void testUpdateRecommendedDaily() {
        // 测试情况下每1小时检测下每日推荐是否更新
        shopService.updateRecommendedDaily();
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void updateCouponStatus() {
        // 正式情况下每天0点更新优惠券状态
        couponService.updateCouponStatus();
    }

    @Scheduled(cron = "0 0 */1 * * ?")
    public void testUpdateCouponStatus() {
        // 测试情况下每1小时更新下优惠券状态
        couponService.updateCouponStatus();
    }
}
