package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Banner;
import com.pro516.thrifttogetherbackstage.mapper.BannerMapper;
import com.pro516.thrifttogetherbackstage.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 11:50
 */
@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Banner> listBanners() {
        return bannerMapper.listBanners();
    }
}
