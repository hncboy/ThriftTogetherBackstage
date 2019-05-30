package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.Shop;
import com.pro516.thrifttogetherbackstage.mapper.ShopMapper;
import com.pro516.thrifttogetherbackstage.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 13:58
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Shop> listShopsByCityId(Integer cityId) {
        return shopMapper.listShopsByCityId(cityId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shop> listShopsByCategoryId(Integer cityId, Integer categoryId) {
        return shopMapper.listShopsByCategoryId(cityId, categoryId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shop> listShopsBySubdivisionId(Integer cityId, Integer categoryId, Integer subdivisionId) {
        return shopMapper.listShopsBySubdivisionId(cityId, categoryId, subdivisionId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shop> listRecommendedDailyShops() {
        return shopMapper.listRecommendedDailyShops();
    }
}
