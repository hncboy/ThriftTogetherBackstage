package com.pro516.thrifttogetherbackstage.service.impl;

import com.pro516.thrifttogetherbackstage.elasticsearch.ShopRepository;
import com.pro516.thrifttogetherbackstage.entity.vo.SimpleShopVO;
import com.pro516.thrifttogetherbackstage.mapper.SearchMapper;
import com.pro516.thrifttogetherbackstage.mapper.ShopMapper;
import com.pro516.thrifttogetherbackstage.service.SearchService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: hncboy
 * Date 2019/6/1
 * Time: 19:34
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private ShopRepository shopRepository;

    @Transactional(readOnly = true)
    @Override
    public List<String> listUserSearchRecords(Integer cityId, Integer userId, Integer recordNum) {
        return searchMapper.listSearchRecordsByUserId(cityId, userId, recordNum);
    }

    @Transactional
    @Override
    public List<SimpleShopVO> searchShops(Integer cityId, Integer userId, String keyword, Integer start, Integer size) {
        // 记录用户搜索记录
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("cityId", cityId);
        map.put("keyword", keyword);
        searchMapper.insertSearchRecord(map);

        // FIXME 先全部插入，再插入全部数据
        shopRepository.deleteAll();
        List<SimpleShopVO> simpleShopVOList = shopMapper.listShops();
        shopRepository.saveAll(simpleShopVOList);

        Pageable pageable = PageRequest.of(start, size);
        QueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("cityId", cityId))
                .must(QueryBuilders.matchQuery("shopName", keyword));
        Page<SimpleShopVO> simpleShopVOPage = shopRepository.search(queryBuilder, pageable);

        return simpleShopVOPage.getContent();
    }
}
