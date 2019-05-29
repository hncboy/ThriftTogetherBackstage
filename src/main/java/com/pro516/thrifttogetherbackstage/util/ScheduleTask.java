package com.pro516.thrifttogetherbackstage.util;

import com.pro516.thrifttogetherbackstage.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

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
    private ScheduleService scheduleService;

    @Scheduled(cron = "0 0 6 * * ?")
    public void recommendedDaily() {
        // 正式情况下每天6点更新每日推荐
        scheduleService.updateRecommendedDaily();
    }

    @Scheduled(cron = "0 0 */1 * * ?")
    public void testUpdateRecommendedDaily() {
        // 测试情况下每1小时检测下每日推荐是否更新
        scheduleService.updateRecommendedDaily();
    }
}
