package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.elasticsearch.ShopRepository;
import com.pro516.thrifttogetherbackstage.entity.vo.ShopDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import com.pro516.thrifttogetherbackstage.mapper.ShopMapper;
import com.pro516.thrifttogetherbackstage.mapper.UserMapper;
import com.pro516.thrifttogetherbackstage.service.ShopService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date: 2019-05-14
 * Time: 13:58
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ShopRepository shopRepository;

    @Transactional(readOnly = true)
    @Override
    public List<SimpleShopVO> listShopsByCityId(Integer cityId) {
        return shopMapper.listShopsByCityId(cityId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleShopVO> listShopsByCategoryId(Integer cityId, Integer categoryId) {
        return shopMapper.listShopsByCategoryId(cityId, categoryId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleShopVO> listShopsBySubdivisionId(Integer cityId, Integer categoryId, Integer subdivisionId) {
        return shopMapper.listShopsBySubdivisionId(cityId, categoryId, subdivisionId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SimpleShopVO> listRecommendedDailyShops() {
        return shopMapper.listRecommendedDailyShops();
    }

    @Transactional
    @Override
    public ShopDetailsVO getShopDetails(Integer shopId, Integer userId) {
        ShopDetailsVO shopDetailsVO = shopMapper.getShopDetails(shopId, userId);
        shopDetailsVO.setSimpleProductList(shopMapper.listSimpleProductsByShopId(shopId));
        userMapper.insertRecentlyBrowseShop(userId, shopId);
        return shopDetailsVO;
    }

    @Transactional
    @Override
    public void updateRecommendedDaily() {
        for (int i = 0; i < 6; i++) {
            if (shopMapper.listRecommendedDailyCount() >= 6) {
                break;
            }
            // TODO 推荐算法
            shopMapper.insertRecommendedDaily(i + 1);
        }
    }

    @Override
    public List<SimpleShopVO> searchShops(Integer cityId, String keyword, Integer start, Integer size) {

        Pageable pageable = PageRequest.of(start, size);

        // FIXME 先全部插入，再插入全部数据
        shopRepository.deleteAll();
        List<SimpleShopVO> simpleShopVOList = shopMapper.listShops();
        shopRepository.saveAll(simpleShopVOList);

        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("cityId", cityId))
                .must(QueryBuilders.matchQuery("shopName", keyword));
        Page<SimpleShopVO> simpleShopVOPage = shopRepository.search(queryBuilder, pageable);

        return simpleShopVOPage.getContent();
    }
}
