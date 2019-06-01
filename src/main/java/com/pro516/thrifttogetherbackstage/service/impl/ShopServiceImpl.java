package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.elasticsearch.ShopRepository;
import com.pro516.thrifttogetherbackstage.entity.vo.DiscoverShopVO;
import com.pro516.thrifttogetherbackstage.entity.vo.ShopDetailsVO;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import com.pro516.thrifttogetherbackstage.mapper.SearchMapper;
import com.pro516.thrifttogetherbackstage.mapper.ShopMapper;
import com.pro516.thrifttogetherbackstage.mapper.UserMapper;
import com.pro516.thrifttogetherbackstage.service.ShopService;
import com.pro516.thrifttogetherbackstage.util.DistanceUtil;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

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

    @Transactional(readOnly = true)
    @Override
    public List<DiscoverShopVO> listDiscoverShops(Integer cityId, Double userLng, Double userLat, Integer start, Integer size) {
        List<DiscoverShopVO> discoverShopVOS = shopMapper.listDiscoverShopsByCityId(cityId);
        // 根据用户经纬度与店铺经纬度计算距离
        for (DiscoverShopVO discoverShopVO : discoverShopVOS) {
            double distance = DistanceUtil.getDistance(userLng, userLat, discoverShopVO.getLongitude(), discoverShopVO.getLatitude());
            BigDecimal bigDecimal = new BigDecimal(distance);
            distance = bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
            discoverShopVO.setDistance(distance);
        }
        // 按距离升序
        Collections.sort(discoverShopVOS, new Comparator<DiscoverShopVO>() {
            public int compare(DiscoverShopVO arg0, DiscoverShopVO arg1) {
                return arg0.getDistance().compareTo(arg1.getDistance());
            }
        });
        // TODO 分页
        return discoverShopVOS;
    }
}
