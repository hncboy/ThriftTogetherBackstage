package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.Banner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 11:47
 */
public interface BannerService {

    /**
     * 获取所有轮播图
     *
     * @return
     */
    List<Banner> listBanners();
}
