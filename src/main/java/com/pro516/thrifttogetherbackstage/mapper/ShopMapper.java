package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.Product;
import com.pro516.thrifttogetherbackstage.entity.vo.*;
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
     * 根据城市id获取每日推荐的店铺
     *
     * @return
     */
    List<SimpleShopVO> listRecommendedDailyShopsByCityId(@Param("cityId") Integer cityId);

    /**
     * 根据城市id和用户id获取随便看看的店铺
     *
     * @param cityId
     * @return
     */
    List<LookingAroundShopVO> listLookingAroundShops(@Param("cityId") Integer cityId,
                                                     @Param("userId") Integer userId);

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
     * 根据店铺id查询该店铺的所有商品
     *
     * @param shopId
     * @return
     */
    List<SimpleProductVO> listSimpleProductsByShopId(@Param("shopId") Integer shopId);

    /**
     * 根据商品id更新商品团购价格
     *
     * @param productId
     */
    void updateProductDiscountPrice(@Param("productId") Integer productId);

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

    /**
     * 根据城市id查询所需要的发现页店铺信息
     *
     * @param cityId
     * @return
     */
    List<DiscoverShopVO> listDiscoverShopsByCityId(@Param("cityId") Integer cityId);

    /**
     * 根据店铺id和用户id查询店铺商品详情列表
     *
     * @param shopId
     * @return
     */
    List<ProductDetailsVO> listDetailProducts(@Param("shopId") Integer shopId,
                                                      @Param("userId") Integer userId);

    /**
     * 根据商品id查询商品
     *
     * @param productId
     * @return
     */
    Product getProductByProductId(@Param("productId") Integer productId);
}
