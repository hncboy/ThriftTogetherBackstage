package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.vo.*;
import org.apache.ibatis.annotations.Param;

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
    List<SimpleShopVO> listShopsByCityId(Integer cityId);

    /**
     * 根据城市id和分类id筛选店铺
     *
     * @param cityId
     * @param categoryId
     * @return
     */
    List<SimpleShopVO> listShopsByCategoryId(Integer cityId, Integer categoryId);


    /**
     * 根据城市id，分类id和细分id筛选店铺
     *
     * @param cityId
     * @param categoryId
     * @param subdivisionId
     * @return
     */
    List<SimpleShopVO> listShopsBySubdivisionId(Integer cityId, Integer categoryId, Integer subdivisionId);

    /**
     * 根据城市id获取每日推荐的店铺
     *
     * @return
     */
    List<SimpleShopVO> listRecommendedDailyShopsByCityId(Integer cityId);

    /**
     * 根据城市id和用户id获取随便看看的店铺
     *
     * @param cityId
     * @param userId
     * @return
     */
    List<LookingAroundShopVO> listLookingAroundShops(Integer cityId, Integer userId);

    /**
     * 根据用户id和店铺id查询店铺详情
     *
     * @param shopId
     * @param userId
     * @return
     */
    ShopDetailsVO getShopDetails(Integer shopId, Integer userId);

    /**
     * 更新每日推荐
     */
    void updateRecommendedDaily();

    /**
     * 根据城市id，用户所在经纬度查询周边
     *
     * @param cityId
     * @param userLng
     * @param userLat
     * @return
     */
    List<DiscoverShopVO> listDiscoverShops(Integer cityId, Double userLng, Double userLat, Integer start, Integer size);

    /**
     * 根据店铺id和用户id查询店铺商品详情列表
     *
     * @param shopId
     * @return
     */
    List<ProductDetailsVO> listDetailProducts(Integer shopId, Integer userId);
}
