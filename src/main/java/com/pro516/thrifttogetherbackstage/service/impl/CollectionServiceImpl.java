package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.vo.CollectedProductVO;
import com.pro516.thrifttogetherbackstage.entity.vo.CollectedShopVO;
import com.pro516.thrifttogetherbackstage.mapper.BannerMapper;
import com.pro516.thrifttogetherbackstage.mapper.CollectionMapper;
import com.pro516.thrifttogetherbackstage.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/5/29
 * Time: 13:19
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public void collectShop(Integer userId, Integer shopId) {
        collectionMapper.addCollectShop(userId, shopId);
    }

    @Override
    public void collectProduct(Integer userId, Integer productId) {
        collectionMapper.addCollectProduct(userId, productId);
    }

    @Override
    public void cancelCollectShop(Integer userId, Integer shopId) {
        collectionMapper.deleteCollectShop(userId, shopId);
    }

    @Override
    public void cancelCollectProduct(Integer userId, Integer productId) {
        collectionMapper.deleteCollectProduct(userId, productId);
    }

    @Override
    public List<CollectedShopVO> listShopsByUserId(Integer userId) {
        return collectionMapper.listShopsByUserId(userId);
    }

    @Override
    public List<CollectedProductVO> listProductsByUserId(Integer userId) {
        return collectionMapper.listProductsByUserId(userId);
    }
}
