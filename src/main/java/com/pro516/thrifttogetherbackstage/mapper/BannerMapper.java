package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.Banner;
import com.pro516.thrifttogetherbackstage.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 11:47
 */
@Mapper
@Component
public interface BannerMapper {

    /**
     * 获取所有轮播图
     *
     * @return
     */
    List<Banner> listBanners();
}
