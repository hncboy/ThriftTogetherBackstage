package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.Shop;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 13:57
 */
public interface ShopService {

    /**
     * 根据城市id筛选店铺
     *
     * @param cityId
     * @return
     */
    List<Shop> listShopsByCityId(Integer cityId);

    /**
     * 根据城市id和分类id筛选店铺
     *
     * @param cityId
     * @param categoryId
     * @return
     */
    List<Shop> listShopsByCategoryId(Integer cityId, Integer categoryId);


    /**
     * 根据城市id，分类id和细分id筛选店铺
     *
     * @param cityId
     * @param categoryId
     * @param subdivisionId
     * @return
     */
    List<Shop> listShopsBySubdivisionId(Integer cityId, Integer categoryId, Integer subdivisionId);
}
