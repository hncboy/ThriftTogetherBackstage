package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.mapper.ScheduleMapper;
import com.pro516.thrifttogetherbackstage.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 18:51
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Transactional
    @Override
    public void updateRecommendedDaily() {
        for (int i = 0; i < 6; i++) {
            if (scheduleMapper.listRecommendedDaily() >= 6) {
                break;
            }
            // TODO 推荐算法
            scheduleMapper.insertRecommendedDaily(i + 1);
        }
    }

    @Transactional
    @Override
    public void updateCouponStatus() {
        scheduleMapper.updateCouponStatus();
    }
}
