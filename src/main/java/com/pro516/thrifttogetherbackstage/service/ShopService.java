package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.vo.ShopDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
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
     * 查询每日推荐的店铺
     *
     * @return
     */
    List<SimpleShopVO> listRecommendedDailyShops();

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
}
