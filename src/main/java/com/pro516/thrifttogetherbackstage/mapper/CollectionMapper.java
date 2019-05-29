package com.pro516.thrifttogetherbackstage.mapper;

import com.pro516.thrifttogetherbackstage.entity.vo.CollectedProductVO;
import com.pro516.thrifttogetherbackstage.entity.vo.CollectedShopVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 13:15
 */
@Mapper
@Component
public interface CollectionMapper {

    /**
     * 收藏店铺
     *
     * @param userId
     * @param shopId
     */
    void addCollectShop(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    /**
     * 收藏商品
     *
     * @param userId
     * @param productId
     */
    void addCollectProduct(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 取消收藏店铺
     *
     * @param userId
     * @param shopId
     */
    void deleteCollectShop(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    /**
     * 取消收藏商品
     *
     * @param userId
     * @param productId
     */
    void deleteCollectProduct(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 根据用户id获取用户收藏的的店铺
     * @param userId
     * @return
     */
    List<CollectedShopVO> listShopsByUserId(@Param("userId")Integer userId);

    /**
     * 根据用户id获取用户收藏的的商品
     * @param userId
     * @return
     */
    List<CollectedProductVO> listProductsByUserId(@Param("userId") Integer userId);
}
