package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.entity.vo.CollectedProductVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import com.pro516.thrifttogetherbackstage.mapper.CollectionMapper;
import com.pro516.thrifttogetherbackstage.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void collectShop(Integer userId, Integer shopId) {
        collectionMapper.addCollectShop(userId, shopId);
    }

    @Transactional
    @Override
    public void collectProduct(Integer userId, Integer productId) {
        collectionMapper.addCollectProduct(userId, productId);
    }

    @Transactional
    @Override
    public void cancelCollectShop(Integer userId, Integer shopId) {
        collectionMapper.deleteCollectShop(userId, shopId);
    }

    @Transactional
    @Override
    public void cancelCollectProduct(Integer userId, Integer productId) {
        collectionMapper.deleteCollectProduct(userId, productId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleShopVO> listShopsByUserId(Integer userId) {
        return collectionMapper.listShopsByUserId(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CollectedProductVO> listProductsByUserId(Integer userId) {
        return collectionMapper.listProductsByUserId(userId);
    }
}
