package com.pro516.thrifttogetherbackstage.service;

import com.pro516.thrifttogetherbackstage.entity.vo.CollectedProductVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 13:17
 */
public interface CollectionService {

    /**
     * 收藏店铺
     *
     * @param userId
     * @param shopId
     */
    void collectShop(Integer userId, Integer shopId);

    /**
     * 收藏商品
     *
     * @param userId
     * @param productId
     */
    void collectProduct(Integer userId, Integer productId);

    /**
     * 取消收藏店铺
     *
     * @param userId
     * @param shopId
     */
    void cancelCollectShop(Integer userId, Integer shopId);

    /**
     * 取消收藏商品
     *
     * @param userId
     * @param productId
     */
    void cancelCollectProduct(Integer userId, Integer productId);

    /**
     * 根据用户id获取用户收藏的的店铺
     * @param userId
     * @return
     */
    List<SimpleShopVO> listShopsByUserId(Integer userId);

    /**
     * 根据用户id获取用户收藏的的商品
     * @param userId
     * @return
     */
    List<CollectedProductVO> listProductsByUserId(Integer userId);
}
