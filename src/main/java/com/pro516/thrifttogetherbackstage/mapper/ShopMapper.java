package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.vo.ShopDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleProductVO;
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
     * 查询所有店铺
     *
     * @return
     */
    List<SimpleShopVO> listShops();

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

    /**
     * 根据店铺id查询简单店铺信息
     *
     * @param shopId
     * @return
     */
    SimpleShopVO getSimpleShopByShopId(@Param("shopId") Integer shopId);

    /**
     * 根据用户id和店铺id查询店铺详情
     *
     * @param shopId
     * @param userId
     * @return
     */
    ShopDetailsVO getShopDetails(@Param("shopId") Integer shopId,
                                 @Param("userId") Integer userId);

    /**
     * 根据店铺id查询改店铺的所有商品
     *
     * @param shopId
     * @return
     */
    List<SimpleProductVO> listSimpleProductsByShopId(@Param("shopId") Integer shopId);

    /**
     * 根据商品id查询所属的店铺id
     *
     * @param productId
     * @return
     */
    Integer getShopIdByProductId(@Param("productId") Integer productId);

    /**
     * 查询每日推荐的数量
     *
     * @return
     */
    Integer listRecommendedDailyCount();

    /**
     * 更新每日推荐
     */
    void insertRecommendedDaily(@Param("shopId") Integer shopId);
}
