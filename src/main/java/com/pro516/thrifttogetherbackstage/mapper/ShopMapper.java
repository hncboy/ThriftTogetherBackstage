package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.Shop;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 13:50
 */
@Mapper
@Component
public interface ShopMapper {

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
    List<SimpleShopVO> listShopsByCategoryId(@Param("cityId") Integer cityId,
                                     @Param("categoryId") Integer categoryId);

    /**
     * 根据城市id，分类id和细分id筛选店铺
     *
     * @param cityId
     * @param categoryId
     * @param subdivisionId
     * @return
     */
    List<SimpleShopVO> listShopsBySubdivisionId(@Param("cityId") Integer cityId,
                                        @Param("categoryId") Integer categoryId,
                                        @Param("subdivisionId") Integer subdivisionId);

    /**
     * 查询每日推荐的店铺
     *
     * @return
     */
    List<SimpleShopVO> listRecommendedDailyShops();
}
